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
    protected EvelutionEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amp) {
        super.applyEffectTick(livingEntity, amp);
        System.out.print("[DEBUG] applyEffectTick is running!");
        if (!livingEntity.level.isClientSide && livingEntity instanceof IronGolem) {
            System.out.print("[DEBUG] first if is running!");
            BlockPos pos = livingEntity.getOnPos();
            Level lvl = livingEntity.getLevel();
            double random = Math.random();
            IronSlytherEntity newMob = ModEntities.IRON_SLYTHER.get().create(lvl);
            livingEntity.discard();
            if (random >= 0 && newMob != null){
                System.out.print("[DEBUG] second if is running!");
                newMob.moveTo(pos.getX(), pos.getY(), pos.getZ());
                lvl.addFreshEntity(newMob);
            }
        }
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
