package net.zihui.csprojmod.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.level.Level;
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
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));

    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<IronLeeEntity> ironLeeEntityAnimationState) {
        if (ironLeeEntityAnimationState.isMoving())
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
}
