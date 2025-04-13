package net.zihui.csprojmod.event;

import com.sun.jna.platform.dnd.DropHandler;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.entity.ModEntities;
import net.zihui.csprojmod.entity.custom.*;
import net.zihui.csprojmod.entity.custom.stash.DrownedChampionEntity;
import net.zihui.csprojmod.entity.custom.stash.ShipwreckCaptainEntity;

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
        event.put(ModEntities.IRON_SLYTHER.get(), IronSlytherEntity.setAttributes());
    }
}
