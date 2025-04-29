package net.zihui.zsevomob.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.level.Level;
import net.zihui.zsevomob.entity.ModEntities;
import net.zihui.zsevomob.entity.custom.IronSlytherEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EvelutionEffect extends MobEffect {
    public int transformTime;
    protected EvelutionEffect(MobEffectCategory category, int color) {
        super(category, color);
        transformTime = 100;
    }


    // Overriding the pre-existing command for the effects (updates every tick)
    // 20 ticks is about 1 second
    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amp) {
        super.applyEffectTick(livingEntity, amp);
        boolean isInstance = livingEntity instanceof IronGolem; // Checks if the entity hit is any instance of IronGolem
        boolean isSlyther = livingEntity instanceof IronSlytherEntity; // Checks if entity is Iron Slyther
        boolean shouldTurn = isInstance && !isSlyther; // Conditional: Can only turn into Slyther if its not one

        // Checks to see if this is ran on clientside and other conditions
        if (!livingEntity.level.isClientSide && shouldTurn && transformTime <= 0) {
            // Variables that decide whether the mob turns into a iron slyther or not
            BlockPos pos = livingEntity.getOnPos();
            Level lvl = livingEntity.getLevel();
            double random = Math.random();
            double area = 5.0D;
            IronSlytherEntity newMob = ModEntities.IRON_SLYTHER.get().create(lvl);
            List<Mob> mobsAround = livingEntity.level.getEntitiesOfClass(Mob.class, livingEntity.getBoundingBox().inflate(area));

            for (int i = 0; i < mobsAround.size(); i++) {
                // If aa mob is villager class then increase chance by 5%
                if (mobsAround.get(i) instanceof Villager){
                    random += 0.05;
                } // increase chance by 15% if golem class (not slyther!)
                else if (mobsAround.get(i) instanceof IronGolem && mobsAround.get(i).getClass() != IronSlytherEntity.class) {
                    random += 0.15;
                }

            }

            assert newMob != null;
            if (random >= 0.9){
                //Note: 10% Chance to successfully change
                newMob.setXRot(livingEntity.getXRot()); // Extra code to make sure the entity spawns in facing the same
                newMob.setYRot(livingEntity.getYRot());// direction that the previous mob did if success
                livingEntity.discard(); // Removes old mob
                newMob.moveTo(pos.getX(), pos.getY() + 1, pos.getZ()); // Puts mob in old mob pos with offsets
                lvl.addFreshEntity(newMob); // Adds new mob into game
            }
            else {
                // Discards mob if failed
                livingEntity.discard();
            }
        }

        if (transformTime == 0){
            // Resets transformation time is its exactly 0
            transformTime = 100;
        }// Ticking down transformation time if above 0
        else transformTime--;
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity entity, @Nullable Entity entity1, LivingEntity entity2, int effect, double applied) {
        super.applyInstantenousEffect(entity, entity1, entity2, effect, applied);
    }

    @Override
    public boolean isDurationEffectTick(int p_19455_, int p_19456_) {
        return true;
    }
}
