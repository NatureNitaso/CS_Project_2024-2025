package net.zihui.zsevomob.items.custom;

import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.zihui.zsevomob.items.abstracts.ModWeaponItems;

public class GolemsFist extends ModWeaponItems {
    public static int cD;

    public GolemsFist(int dmg, float speed) {
        super(Tiers.IRON, dmg, speed, new Item.Properties().stacksTo(1));
        cD = 100;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        Vec3 momentum = player.getDeltaMovement();


        if (!level.isClientSide) {
            player.setDeltaMovement(2, 2, 2);
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
