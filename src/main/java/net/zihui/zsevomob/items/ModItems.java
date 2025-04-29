package net.zihui.zsevomob.items;


// This is where we register all of our items into the game

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zihui.zsevomob.ZMobEvoMod;
import net.zihui.zsevomob.blocks.ModBlocks;
import net.zihui.zsevomob.entity.ModEntities;
import net.zihui.zsevomob.items.custom.AnimatedBlockItem;
import net.zihui.zsevomob.items.custom.CustomThrowableItem;
import net.zihui.zsevomob.items.custom.GolemsFist;

public class ModItems {
    // Sets up register for deferred register method
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ZMobEvoMod.MOD_ID);


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

    public static final RegistryObject<Item> ANIMATED_BLOCK_ITEM = ITEMS.register("animated_block",
            () -> new AnimatedBlockItem(ModBlocks.ANIMATED_BLOCK.get(), new Item.Properties())) ;

    public static final RegistryObject<Item> TIGER_SPAWN_EGG = ITEMS.register("tiger_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.TIGER, 0xD57E36, 0x1D0D00,
                    new Item.Properties()));

    public static final RegistryObject<Item> IRON_SLYTHER_SPAWN_EGG = ITEMS.register("iron_slyther_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.IRON_SLYTHER, 0x8B8B8B, 0X6F563B,
                    new Item.Properties()));

    public static final RegistryObject<Item> EVE_LOTION = ITEMS.register("eve_lotion", () ->
            new CustomThrowableItem(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> GOLEMS_FIST = ITEMS.register("golems_fist",
            () -> new GolemsFist(5, 1.2f));

    // Registers all items in the Deferred Register to the Forge directory
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
