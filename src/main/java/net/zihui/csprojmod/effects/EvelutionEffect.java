package net.zihui.csprojmod.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class EvelutionEffect extends MobEffect {
    protected EvelutionEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amp) {
        if (!livingEntity.level.isClientSide) {
            double tx = livingEntity.getX();
            double ty = livingEntity.getY();
            double tz = livingEntity.getZ();
        }
        super.applyEffectTick(livingEntity, amp);
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity p_19462_, @Nullable Entity p_19463_, LivingEntity p_19464_, int p_19465_, double p_19466_) {
        super.applyInstantenousEffect(p_19462_, p_19463_, p_19464_, p_19465_, p_19466_);
    }
}
