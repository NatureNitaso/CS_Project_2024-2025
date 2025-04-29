package net.zihui.zsevomob.items.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.Tags;
import net.zihui.zsevomob.entity.ModEntities;
import net.zihui.zsevomob.entity.custom.EveLotion;
import net.zihui.zsevomob.items.ModItems;

public class CustomThrowableItem extends Item{
    public CustomThrowableItem(Properties props) {
        super(props);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand resultHolder) {
        ItemStack item = player.getItemInHand(resultHolder);
        if (!level.isClientSide) {
            EveLotion pot = new EveLotion(ModEntities.EVE_LOTION.get(), player, level);

            pot.setItem(ModItems.EVE_LOTION.get().getDefaultInstance()); // Insurance covering for errors in thrownppotionentit
            pot.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 0.75f, 1.5f);
            level.addFreshEntity(pot);
            System.out.print("Shots fired!");
        }

        player.getCooldowns().addCooldown(this, 10);

        if (!player.getAbilities().instabuild) {
            item.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(item, level.isClientSide());
    }
}
