package net.zihui.csprojmod.entity.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.zihui.csprojmod.effects.ModEffects;
import net.zihui.csprojmod.entity.ModEntities;

public class CustomThrowableEntity extends ThrowableItemProjectile {
    public CustomThrowableEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        if (entity instanceof LivingEntity living) {
            living.addEffect(new MobEffectInstance(ModEffects.EVELUTION.get(), 200, 0));
        }
        this.discard();
    }
}
