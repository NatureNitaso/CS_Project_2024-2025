package net.zihui.csprojmod;

// imports up here //
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.zihui.csprojmod.blocks.ModBlocks;
import net.zihui.csprojmod.entity.ModBlockEntities;
import net.zihui.csprojmod.entity.ModEntities;
import net.zihui.csprojmod.entity.client.*;
import net.zihui.csprojmod.init.ModCreativeTabs;
import net.zihui.csprojmod.items.ModItems;
import org.slf4j.Logger;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib.GeckoLib;

@Mod(CSProjMain.MOD_ID)
public class CSProjMain {

    public static final String MOD_ID = "csprojmod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CSProjMain() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);


        // Calls to ModItems to register the items within there
        ModItems.ITEMS.register(modEventBus);
        // Calls to ModBlocks to register the blocks made there
        ModBlocks.BLOCKS.register(modEventBus);
        //Why I was having errors before winter break:
        ModEntities.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);


    }

    private void setup(final FMLCommonSetupEvent event) {

    }
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.TIGER.get(), TigerRenderer::new);
            EntityRenderers.register(ModEntities.IRON_LEE.get(), IronLeeRenderer::new);
            EntityRenderers.register(ModEntities.SHIPWRECK_CAPTAIN.get(), ShipwreckCaptainRenderer::new);
            BlockEntityRenderers.register(ModBlockEntities.ANIMATED_BLOCK_ENTITY.get(), AnimatedBlockRenderer::new);
            EntityRenderers.register(ModEntities.DROWNED_CHAMPION.get(), DrownedChampionRenderer::new);
        }
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModCreativeTabs.CSPROJ_MOD) {
            event.accept(ModItems.CRACK);
            event.accept(ModItems.TESTOBJ);
            event.accept(ModItems.ANIMATED_BLOCK_ITEM);
            event.accept(ModItems.TIGER_SPAWN_EGG);



        }
    }
}