package net.zihui.csprojmod.entity.custom;

import net.minecraft.advancements.critereon.DamageSourcePredicate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.entity.goal.LeapAtTargetGoal;
import net.zihui.csprojmod.entity.goal.RangedSmashAttackGoal;
import net.zihui.csprojmod.entity.goal.enums.LeapTypes;
import net.zihui.csprojmod.entity.goal.interfaces.SpecialMoveset;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import net.zihui.csprojmod.entity.goal.enums.LeapTypes;

import java.util.Objects;

public class IronSlytherEntity extends IronGolem implements GeoEntity, SpecialMoveset {

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private int cD;
    private boolean usedAbility;
    private LivingEntity target;
    private boolean isLeaping = false;;


    public IronSlytherEntity(EntityType<? extends IronGolem> entityType, Level level) {
        super(entityType, level);
        usedAbility = false;
        cD = 0;;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));// Makes mob wander around
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.3f));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true));

//        // Adds targets to the said mob
//        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, false));
//        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
//        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Mob.class, false));
    }

    public float randomPower() {
        return (float) (Math.random() * 1.2 + Math.random());
    }

    @Override
    public boolean causeFallDamage(float v, float v1, DamageSource damageSource) {
        if (isLeaping) return false;
        return super.causeFallDamage(v, v1, damageSource);
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (this.isOnGround()){
            isLeaping = false;
        }

        if (this.getLastAttacker() != null){
            setTarget(this.getLastAttacker());
        }


        if (this.isOnGround() && target != null && cD > 0){
            double distance = this.distanceTo(target);

            if (distance < 4.0D){
                target.addEffect(new MobEffectInstance(MobEffects.HARM));
                cD = 500;
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (!usedAbility) {
            specialAbility();
        }

        if (this.getTarget() != null){
            this.target = this.getTarget();
        }

        if (cD > 0){
            cD--;
        }

        if (this.target != null && this.isOnGround() && this.distanceTo(target) < 10 && cD == 0){
            isLeaping = true;
            specialAttack(target);
        }
        if (this.isOnGround()) {
            isLeaping = false;
        }

    }

    @Override
    public void specialAbility() {
        double maxHealth = this.getMaxHealth();
        double hp = this.getHealth();
        System.out.println("Checking special ability: HP = " + hp + "/" + maxHealth);
        if (hp < maxHealth/2) {
            this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 2));
            this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 2));
            usedAbility = true;
        }
//        boolean hasTarget = this.getTarget() != null;
//        if (hasTarget && this.isOnGround()){
//            Vec3 leap = this.getDeltaMovement();
//            Vec3 target = this.getTarget().getDeltaMovement();
//
//            this.setDeltaMovement(leap.x - target.x, leap.y + 5, leap.z - target.z);
//        }

    }

    @Override
    public void setTarget(LivingEntity target) {
        super.setTarget(target);
        this.target = target;
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
                .add(Attributes.MAX_HEALTH, 150)
                .add(Attributes.ARMOR, 10)
                .add(Attributes.ARMOR_TOUGHNESS, 5)
                .add(Attributes.ATTACK_KNOCKBACK, 200)
                .add(Attributes.ATTACK_SPEED, 0.01f)
                .add(Attributes.ATTACK_DAMAGE, 4)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
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

    @Override
    public void specialAttack(LivingEntity entity) {
        SpecialMoveset.super.specialAttack(entity);

        double dx = target.getX() - this.getX(); // gives the horizontal difference on the x-axis
        double dz = target.getZ() - this.getZ(); // gives the horizontal difference on the z-axis

        double hD = Math.sqrt(dx * dx + dz * dz); // Pythagorean Theorem to find 2D distance b/w entities
        if (hD > 0.1) {
            this.setDeltaMovement((dx / hD) * 1.2, 1.5, (dz / hD) * 1.2);
            this.hasImpulse = true; //Applies Physics dx or dz / hD sets it so the mob goes directly toward the target
            cD = 500;
        }
        //hasImpulse tells Minecraft's AI to not interfere with the movement

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
    protected ResourceLocation getDefaultLootTable() {
        System.out.println("[DEBUG] Iron Slyther loot table is being called!");
        return new ResourceLocation(CSProjMain.MOD_ID, "entity/iron_slyther.json");
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource damageSource, int aVoid, boolean b) {
        super.dropCustomDeathLoot(damageSource, aVoid, b);

        int amount = 3 + this.random.nextInt(7);

        for (int i = 0; i < amount; i++) {
            this.spawnAtLocation(Items.IRON_BLOCK.asItem());
        }
    }

    @Override
    protected void dropExperience() {
        super.dropExperience();
    }
}
