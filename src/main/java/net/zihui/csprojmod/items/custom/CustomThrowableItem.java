package net.zihui.csprojmod.items.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.zihui.csprojmod.entity.custom.CustomThrowableEntity;

import java.util.Properties;

public class CustomThrowableItem extends Item{
    public CustomThrowableItem(Properties props) {
        super(props);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand resultHolder) {
        ItemStack item = player.getItemInHand(resultHolder);
        if (level.isClientSide) {

        }
        return super.use(level, player, resultHolder);
    }
}
