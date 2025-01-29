package net.zihui.csprojmod.items;


// This is where we register all of our items into the game

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.blocks.ModBlocks;
<<<<<<< Updated upstream
import net.zihui.csprojmod.init.ModCreativeTabs;
import net.zihui.csprojmod.items.custom.AnimatedBlockItem;
=======
import net.zihui.csprojmod.entity.ModEntities;
>>>>>>> Stashed changes

public class ModItems {
    // Sets up register for deferred register method
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CSProjMain.MOD_ID);


    // Register first item
    public static final RegistryObject<Item> TESTOBJ = ITEMS.register("testobj",
            () -> new Item(new Item.Properties()));

    // Registers food, then adds food values onto the item
    public static final RegistryObject<Item> CRACK = ITEMS.register("crack",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(10)
                            .saturationMod(1).effect
                                    (() -> new MobEffectInstance
                                            (MobEffects.DAMAGE_BOOST, 1200, 3), 1F).
                            effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 1500, 2),1F).
                            effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1500, 3),1F).build()))); // Initiates the process of making this item




    public static final RegistryObject<Item> IRON_LEE_SPAWN_EGG = ITEMS.register("iron_lee_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.IRON_LEE, 0xD2BCAA, 0x658932,
                    new Item.Properties()));

    public static final RegistryObject<Item> IRON_SLYTHER_SPAWN_EGG = ITEMS.register("iron_slyther_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.IRON_SLYTHER, 0xD2BCAA, 0x837432,
                    new Item.Properties()));

    // Registers all items in the Deferred Register to the Forge directory
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
