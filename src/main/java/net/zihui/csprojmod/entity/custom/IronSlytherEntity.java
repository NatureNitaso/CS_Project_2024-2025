package net.zihui.csprojmod.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class IronSlytherEntity extends IronGolem implements GeoAnimatable {

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public IronSlytherEntity(EntityType<? extends IronGolem> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier setAttributes()
    {
        return IronGolem.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 120)
                .add(Attributes.ARMOR, 10)
                .add(Attributes.ARMOR_TOUGHNESS, 5)
                .add(Attributes.ATTACK_KNOCKBACK, 20)
                .add(Attributes.ATTACK_SPEED, 0.01)
                .add(Attributes.ATTACK_DAMAGE, 5)
                .build();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this,
                "controller", 0, this::predicate));
        controllerRegistrar.add(new AnimationController<>(this,
                "attackController", 0, this::attackPredicate));

    }

    private PlayState attackPredicate(AnimationState<IronSlytherEntity> state) {
        if (this.swinging && state.getController().getAnimationState().equals(AnimationController.State.STOPPED))
        {
            state.getController().forceAnimationReset();
            state.getController().setAnimation(RawAnimation.begin().then
                    ("animation.iron_slyther.smash", Animation.LoopType.PLAY_ONCE));
            this.swinging = false;
        }
        return PlayState.CONTINUE;
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<IronSlytherEntity> state) {
        if (state.isMoving())
        {
            state.getController().setAnimation(RawAnimation.begin().then
                    ("animation.iron_slyther.move", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        state.getController().setAnimation(RawAnimation.begin().then
                ("animation.iron_slyther.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object o) {
        return 0;
    }
}
