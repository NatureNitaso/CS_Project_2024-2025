package net.zihui.csprojmod.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class IronSlytherEntity extends IronGolem implements GeoEntity {

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public IronSlytherEntity(EntityType<? extends IronGolem> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier setAttributes()
    {
        return IronGolem.createMobAttributes().add(Attributes.MAX_HEALTH, 150)
                .add(Attributes.MOVEMENT_SPEED, 0.15)
                .add(Attributes.ATTACK_DAMAGE, 5.0)
                .add(Attributes.ARMOR, 3)
                .add(Attributes.ATTACK_KNOCKBACK, 10)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.5)
                .add(Attributes.ATTACK_SPEED, 0.1).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.5, false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.00));
        //this.goalSelector.addGoal(3, new );

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, false));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0,
                this::predicate));

    }

    private <GeoAnimatable> PlayState predicate(AnimationState<IronSlytherEntity> state) {
        if (state.isMoving())
        {
            state.setAnimation(RawAnimation.begin().then
                    ("animation.iron_slyther.move", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        state.setAnimation(RawAnimation.begin().then
                ("animation.iron_slyther.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
