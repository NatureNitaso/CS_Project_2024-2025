package net.zihui.csprojmod.entity.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class ShipwreckCaptainEntity extends Monster implements GeoEntity {

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private boolean canSummonSkeletons = false; // Add ability to summon skeletons later

    public ShipwreckCaptainEntity (EntityType<? extends Monster> entityType, Level level){
        super(entityType, level);
    }
    // Defines the attributes of the mob
    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 50)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.3f).build();
    }


    @Override
    public void registerGoals (){
        this.goalSelector.addGoal(2, new RestrictSunGoal(this));
        this.goalSelector.addGoal(3, new FleeSunGoal(this, 1.0));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Wolf.class, 6.0F, 1.0, 1.2));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 5.0f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        // Add Target Selectors
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<ShipwreckCaptainEntity> shipwreckCaptainEntityAnimationState) {
        if (shipwreckCaptainEntityAnimationState.isMoving()) {
            shipwreckCaptainEntityAnimationState.setAnimation(RawAnimation.begin().then(
                    "animation.swcaptain.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        shipwreckCaptainEntityAnimationState.setAnimation(RawAnimation.begin().then(
                "animation.swcaptain.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }






    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
