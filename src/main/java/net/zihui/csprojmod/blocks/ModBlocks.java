//package net.zihui.csprojmod.blocks;
//
//
//import net.minecraft.world.entity.decoration.ItemFrame;
//import net.minecraft.world.item.BlockItem;
//import net.minecraft.world.item.CreativeModeTab;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.block.state.BlockBehaviour;
//import net.minecraft.world.level.block.state.properties.BlockStateProperties;
//import net.minecraft.world.level.material.Material;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
//import net.zihui.csprojmod.CSProjMain;
//import net.zihui.csprojmod.blocks.custom.SummonPedestal;
//import net.zihui.csprojmod.init.ModCreativeTab;
//import net.zihui.csprojmod.items.ModItems;
//
//import java.awt.*;
//import java.util.Properties;
//import java.util.function.Supplier;
//
//import static net.zihui.csprojmod.init.ModCreativeTab.TAB_MODDED;
//
//public class ModBlocks {
//    // Makes the Deferred Registery to store the Modded blocks from my mod
//    public static final DeferredRegister<Block> BLOCKS =
//            DeferredRegister.create(ForgeRegistries.BLOCKS, CSProjMain.MOD_ID);
//
//    public static final RegistryObject<Block> SUMMON_PEDESTAL = registerBlock("summon_pedestal",
//            () -> new SummonPedestal(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), TAB_MODDED);
//
//
//
//    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, ModCreativeTab tab) {
//        RegistryObject<T> toReturn = BLOCKS.register(name, block);
//        registerBlockItem(name, toReturn, tab);
//        return toReturn;
//    }
//
//    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
//                                                                            ModCreativeTab tab) {
//        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
//    }
//
//    public static void register(IEventBus eventBus) {
//        BLOCKS.register(eventBus);
//    }
//}