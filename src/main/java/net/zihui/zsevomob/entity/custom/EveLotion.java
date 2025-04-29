package net.zihui.zsevomob.entity.custom;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.zihui.zsevomob.effects.ModEffects;
import net.zihui.zsevomob.entity.ModEntities;
import net.zihui.zsevomob.items.ModItems;
import org.jetbrains.annotations.NotNull;

public class EveLotion extends ThrowableItemProjectile {


    public EveLotion(EntityType<? extends ThrowableItemProjectile> entity, Level level) {
        super(entity, level);
    }

    public EveLotion(EntityType<? extends ThrowableItemProjectile> type, LivingEntity living, Level level) {
        super(type, living, level);
    }



    @Override
    protected Item getDefaultItem() {
        return ModItems.EVE_LOTION.get();
    }

//    @Override
//    public Packet<ClientGamePacketListener> getAddEntityPacket() {
//        return super.getAddEntityPacket();
//    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        Entity entity = result.getEntity();

        // Checks to see if entity is an instance of livingEntity
        if (entity instanceof LivingEntity livingEntity) {
            // Puts "Eve" effect onto the mob for 10 seconds
            livingEntity.addEffect(new MobEffectInstance(ModEffects.EVELUTION.get(), 20 * 10, 0));
        }
        // Removes the projectile entity
        this.discard();
    }
}
