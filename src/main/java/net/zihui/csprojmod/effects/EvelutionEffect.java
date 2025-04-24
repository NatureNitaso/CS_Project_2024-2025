package net.zihui.csprojmod.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.level.Level;
import net.zihui.csprojmod.entity.ModEntities;
import net.zihui.csprojmod.entity.custom.IronSlytherEntity;
import org.jetbrains.annotations.Nullable;

public class EvelutionEffect extends MobEffect {
    public int transformTime;
    protected EvelutionEffect(MobEffectCategory category, int color) {
        super(category, color);
        transformTime = 100;
    }


    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amp) {
        super.applyEffectTick(livingEntity, amp);
        boolean isInstance = livingEntity instanceof IronGolem;
        boolean isSlyther = livingEntity instanceof IronSlytherEntity;
        boolean shouldTurn = isInstance && !isSlyther;

        if (!livingEntity.level.isClientSide && shouldTurn && transformTime <= 0) {
            BlockPos pos = livingEntity.getOnPos();
            Level lvl = livingEntity.getLevel();
            double random = Math.random();
            IronSlytherEntity newMob = ModEntities.IRON_SLYTHER.get().create(lvl);

            assert newMob != null;
            if (random >= 0.9){
                newMob.setXRot(livingEntity.getXRot());
                newMob.setYRot(livingEntity.getYRot());
                livingEntity.discard();
                newMob.moveTo(pos.getX(), pos.getY() + 1, pos.getZ());
                lvl.addFreshEntity(newMob);
            }
            else {
                livingEntity.discard();
            }
        }
        if (transformTime == 0){
            transformTime = 100;
        }
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
