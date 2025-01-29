package net.zihui.csprojmod.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.entity.custom.IronLeeEntity;
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


    public static final RegistryObject<EntityType<IronLeeEntity>> IRON_LEE =
            ENTITY_TYPES.register("iron_lee",
                    () -> EntityType.Builder.of(IronLeeEntity::new, MobCategory.MISC)
                            .sized(1.0f, 1.5f)
                            .build(new ResourceLocation(CSProjMain.MOD_ID, "iron_lee")
                                    .toString()));

<<<<<<< Updated upstream
=======

    public static final RegistryObject<EntityType<IronSlytherEntity>> IRON_SLYTHER =
            ENTITY_TYPES.register("iron_slyther",
                    () -> EntityType.Builder.of(IronSlytherEntity::new, MobCategory.MISC)
                            .sized(1.0f, 1.5f)
                            .build(new ResourceLocation(CSProjMain.MOD_ID, "iron_slyther")
                                    .toString()));

>>>>>>> Stashed changes
    public static void register (IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
