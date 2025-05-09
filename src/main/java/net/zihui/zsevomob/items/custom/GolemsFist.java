package net.zihui.zsevomob.items.custom;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.zihui.zsevomob.items.abstracts.ModWeaponItems;
import net.zihui.zsevomob.items.cilent.GolemsFistRenderer;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.RenderUtils;

import java.util.Random;
import java.util.function.Consumer;

public class GolemsFist extends ModWeaponItems implements GeoItem {

    public static int cD;
    private static Player p;
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public GolemsFist(int dmg, float speed, Properties props) {
        super(Tiers.IRON, dmg, speed, props);
        cD = 100;
    }



    public float randomPower() {
        return (float) (Math.random() * 1.2 + Math.random());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return super.use(level, player, hand);
    }

    @Override
    public double getTick(Object itemStack) {
        return RenderUtils.getCurrentTick();
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity entity, LivingEntity entity1) {
        Vec3 movement = entity.getDeltaMovement();


        if (cD > 0) {
            cD--;
        } else {
            cD = 100;
        }

        if (!entity.getLevel().isClientSide) {
            entity.setDeltaMovement(movement.x(), randomPower(), movement.z());
        } else {
//            leve..displayClientMessage(Component.literal("Cooldown: " + (cD % 20) + "s left"), true);
        }

        return true;
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predecate));

    }


    private PlayState predecate(AnimationState animationState) {
        animationState.getController().setAnimation(RawAnimation.begin().then(
                "idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private GolemsFistRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
            if(this.renderer == null) {
                    renderer = new GolemsFistRenderer();
                }
                return this.renderer;
            }
        });
    }
}
