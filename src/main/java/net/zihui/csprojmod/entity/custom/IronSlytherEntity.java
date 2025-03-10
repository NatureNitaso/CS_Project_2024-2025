package net.zihui.csprojmod.entity.custom;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.zihui.csprojmod.entity.goal.LeapAtTargetGoal;
import net.zihui.csprojmod.entity.goal.RangedSmashAttackGoal;
import net.zihui.csprojmod.entity.goal.enums.LeapTypes;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import net.zihui.csprojmod.entity.goal.enums.LeapTypes;

import java.util.Objects;

public class IronSlytherEntity extends IronGolem implements GeoEntity {

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private int leapCd = 0;
    private LivingEntity target;
    private final LeapTypes leapTypes;


    public IronSlytherEntity(EntityType<? extends IronGolem> entityType, Level level) {
        super(entityType, level);
        this.leapTypes = LeapTypes.MEDIUM;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));// Makes mob wander around
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.1f));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 20, true));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, randomPower()));
        this.goalSelector.addGoal(1, new RangedSmashAttackGoal(this, 100));
        // Adds targets to the said mob
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, false));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Mob.class, false));

    }

    public float randomPower() {
        return (float) (Math.random() + 1);
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        boolean flag = super.doHurtTarget(entity);
        if (flag && entity instanceof LivingEntity)
        {
             // Power up launch on hit
            Vec3 motion = entity.getDeltaMovement();
            entity.setDeltaMovement(motion.x, randomPower(), motion.z);
            entity.hurtMarked = true;
        }
        return flag;
    }

    public static AttributeSupplier setAttributes()
    {
        return IronGolem.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 120)
                .add(Attributes.ARMOR, 10)
                .add(Attributes.ARMOR_TOUGHNESS, 5)
                .add(Attributes.ATTACK_KNOCKBACK, 200)
                .add(Attributes.ATTACK_SPEED, 0.01f)
                .add(Attributes.ATTACK_DAMAGE, 5)
                .add(Attributes.MOVEMENT_SPEED, 0.01)
                .add(Attributes.KNOCKBACK_RESISTANCE, 10)
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
            state.setAnimation(RawAnimation.begin().then
                    ("animation.iron_slyther.smash", Animation.LoopType.PLAY_ONCE));
            this.swinging = false;
        }
        return PlayState.CONTINUE;
    }

    private PlayState predicate(AnimationState<IronSlytherEntity> state) {
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

    @Override
    public boolean causeFallDamage(float v, float v1, DamageSource damageSource) {
        return super.causeFallDamage(v, v1, damageSource);
    }
}
