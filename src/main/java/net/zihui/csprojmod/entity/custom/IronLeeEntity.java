package net.zihui.csprojmod.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
<<<<<<< Updated upstream
=======
import net.minecraft.world.phys.AABB;
import net.zihui.csprojmod.entity.goal.CustomAttackGoal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
>>>>>>> Stashed changes
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import java.util.Objects;

public class IronLeeEntity extends IronGolem implements GeoEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);


    private double cd = 9000;

    public IronLeeEntity(EntityType<? extends IronGolem> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
//        this.goalSelector.addGoal(1, new CustomAttackGoal(this, 1.0D, true));

    }

    @Override
    public void swing(InteractionHand p_21012_, boolean p_21013_) {
        super.swing(p_21012_, p_21013_);
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
<<<<<<< Updated upstream
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));

    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<IronLeeEntity> ironLeeEntityAnimationState) {
        if (ironLeeEntityAnimationState.isMoving())
=======
        controllerRegistrar.add(new AnimationController<>(this, "controller",
                0, this::predicate));
        controllerRegistrar.add(new AnimationController<>(this, "attackController",
                0, this::attackPredicate));


    }

    private <T extends GeoAnimatable> PlayState attackPredicate(AnimationState<IronLeeEntity> state) {
        if (this.swinging && state.getController().getAnimationState().equals(AnimationController.State.STOPPED))
>>>>>>> Stashed changes
        {
            state.getController().forceAnimationReset();
            state.getController().setAnimation(RawAnimation.begin().then
                    ("animation.iron_lee.slap", Animation.LoopType.PLAY_ONCE));
            this.swinging = false;
        }
        return PlayState.CONTINUE;
    }


    private <T extends GeoAnimatable> PlayState predicate(AnimationState<IronLeeEntity> state) {
            if(state.isMoving())
        {
            state.getController().setAnimation(RawAnimation.begin().then
                    ("animation.iron_lee.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        state.getController().setAnimation(RawAnimation.begin().then
                ("animation.iron_lee.idle", Animation.LoopType.LOOP));
                return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
<<<<<<< Updated upstream
=======

    @Override
    public void tick() {
        super.tick();
        if (this.swinging && cd >= 1000)
        {
            //this.getLevel().explode(this, this.getX(), this.getY(), this.getZ(), 0, Level.ExplosionInteraction.BLOCK);
        }
    }
>>>>>>> Stashed changes
}
