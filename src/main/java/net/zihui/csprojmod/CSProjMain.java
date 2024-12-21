package net.zihui.csprojmod;

// imports up here //
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.zihui.csprojmod.entity.ModEntities;
import net.zihui.csprojmod.entity.client.TigerRenderer;
import net.zihui.csprojmod.init.ModCreativeTabs;
import net.zihui.csprojmod.items.ModItems;
import org.slf4j.Logger;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CSProjMain.MOD_ID)
public class CSProjMain {

    public static final String MOD_ID = "csprojmod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CSProjMain() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);


        // Calls to ModItems to register the items within there
        ModItems.ITEMS.register(modEventBus);
        // Calls to ModBlocks to register the blocks made there
//        ModBlocks.BLOCKS.register(modEventBus);
        //Why I was having errors before winter break:
        ModEntities.register(modEventBus);
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

        }
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModCreativeTabs.CSPROJ_MOD) {
            event.accept(ModItems.CRACK);
            event.accept(ModItems.TESTOBJ);


        }
    }
}