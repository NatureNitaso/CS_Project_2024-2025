package net.zihui.csprojmod.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.entity.custom.TigerEntity;
import net.zihui.csprojmod.entity.custom.ShipwreckCaptainEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CSProjMain.MOD_ID);

    public static final RegistryObject<EntityType<TigerEntity>> TIGER =
            ENTITY_TYPES.register("tiger",
                    () -> EntityType.Builder.of(TigerEntity::new, MobCategory.CREATURE)
                            .sized(1.5f, 1.75f)
                            .build(new ResourceLocation(CSProjMain.MOD_ID, "tiger").toString()));

    public static final RegistryObject<EntityType<ShipwreckCaptainEntity>> SHIPWRECK_CAPTAIN =
            ENTITY_TYPES.register("shipwreck_captain",
                    () -> EntityType.Builder.of(ShipwreckCaptainEntity::new, MobCategory.MONSTER)
                            .sized(1.0f, 1.25f)
                            .build(new ResourceLocation(CSProjMain.MOD_ID, "shipwreck_captain")
                                    .toString()));
    public static void register (IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
