package net.zihui.zsevomob.items.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.zihui.zsevomob.entity.ModEntities;
import net.zihui.zsevomob.entity.custom.CustomThrowableEntity;

public class CustomThrowableItem extends Item{
    public CustomThrowableItem(Properties props) {
        super(props);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand resultHolder) {
        ItemStack item = player.getItemInHand(resultHolder);
        if (level.isClientSide) {
            CustomThrowableEntity projectile = new CustomThrowableEntity(ModEntities.CUSTOM_THROWABLE_ENTITY.get(), level);
            projectile.setOwner(player);
            projectile.setItem(item.copy());
            projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(projectile);
        }

        player.getCooldowns().addCooldown(this, 10);

        if (!player.getAbilities().instabuild) {
            item.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(item, level.isClientSide());
    }
}
