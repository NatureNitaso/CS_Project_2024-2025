package net.zihui.csprojmod.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.entity.ModEntities;
import net.zihui.csprojmod.entity.custom.*;

@Mod.EventBusSubscriber(modid = CSProjMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    // Sets the attributes for entity when spawned
    // This was the reason why I kept crashing
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.TIGER.get(), TigerEntity.setAttributes());
        event.put(ModEntities.SHIPWRECK_CAPTAIN.get(), ShipwreckCaptainEntity.setAttributes());
        event.put(ModEntities.IRON_LEE.get(), IronLeeEntity.setAttributes());
        event.put(ModEntities.DROWNED_CHAMPION.get(), DrownedChampionEntity.setAttributes());
    }
}
