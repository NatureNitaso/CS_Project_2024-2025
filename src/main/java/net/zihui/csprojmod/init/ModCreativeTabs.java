package net.zihui.csprojmod.init;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.items.ModItems;

// Initiates a new Minecraft tab that store items from this mod
@Mod.EventBusSubscriber(modid = CSProjMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModCreativeTabs {

    public static CreativeModeTab CSPROJ_MOD;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        CSPROJ_MOD = event.registerCreativeModeTab(new ResourceLocation(CSProjMain.MOD_ID, "csprojmod_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.CRACK.get()))
                        .title(Component.translatable("creativemodetab.csprojmod_tab")));
    }
}



