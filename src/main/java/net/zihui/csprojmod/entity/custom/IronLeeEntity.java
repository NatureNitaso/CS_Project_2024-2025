package net.zihui.csprojmod.entity.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class IronLeeEntity extends IronGolem implements GeoEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public IronLeeEntity(EntityType<? extends IronGolem> entityType, Level level) {
        super(entityType, level);
        super.registerGoals();;
    }

    public static AttributeSupplier setAttributes() {
        return IronGolem.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.MOVEMENT_SPEED, 0.7)
                .add(Attributes.ATTACK_KNOCKBACK, 5.0)
                .add(Attributes.ATTACK_DAMAGE, 20.0)
                .add(Attributes.ATTACK_SPEED, 1.2f).build();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller",
                0, this::predicate));
    }

    @Override
    public boolean doHurtTarget(@NotNull Entity target) {
        boolean flag = super.doHurtTarget(target);

        if (flag) {
            this.swing(InteractionHand.MAIN_HAND, true);
        }

        return flag;
    }

        private <T extends GeoAnimatable> PlayState predicate(AnimationState<IronLeeEntity> ironLeeEntityAnimationState) {
            if (this.swinging && ironLeeEntityAnimationState.getController().hasAnimationFinished())
            {
                ironLeeEntityAnimationState.getController().setAnimation(RawAnimation.begin().then
                        ("animation.iron_lee.slap", Animation.LoopType.PLAY_ONCE));
                this.swinging = false;
                return PlayState.CONTINUE;
            }
        if(ironLeeEntityAnimationState.isMoving())
        {
            ironLeeEntityAnimationState.setAnimation(RawAnimation.begin().then
                    ("animation.iron_lee.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        ironLeeEntityAnimationState.setAnimation(RawAnimation.begin().then
                ("animation.iron_lee.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void swing(@NotNull InteractionHand hand, boolean b) {
        super.swing(hand, b);
        this.swinging = true;
    }

    @Override
    public float getAttackAnim(float p_21325_) {
        return super.getAttackAnim(p_21325_);
    }
}
