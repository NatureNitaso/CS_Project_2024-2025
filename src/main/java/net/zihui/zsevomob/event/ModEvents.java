package net.zihui.zsevomob.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.zihui.zsevomob.ZMobEvoMod;
import net.zihui.zsevomob.entity.ModEntities;
import net.zihui.zsevomob.entity.custom.*;
import net.zihui.zsevomob.entity.custom.stash.DrownedChampionEntity;
import net.zihui.zsevomob.entity.custom.stash.ShipwreckCaptainEntity;

@Mod.EventBusSubscriber(modid = ZMobEvoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    // Sets the attributes for entity when spawned
    // This was the reason why I kept crashing
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.TIGER.get(), TigerEntity.setAttributes());
        event.put(ModEntities.SHIPWRECK_CAPTAIN.get(), ShipwreckCaptainEntity.setAttributes());
        event.put(ModEntities.IRON_LEE.get(), IronLeeEntity.setAttributes());
        event.put(ModEntities.DROWNED_CHAMPION.get(), DrownedChampionEntity.setAttributes());
        event.put(ModEntities.IRON_SLYTHER.get(), IronSlytherEntity.setAttributes());;
    }
}
