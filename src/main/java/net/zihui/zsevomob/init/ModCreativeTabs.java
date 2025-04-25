package net.zihui.zsevomob.init;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.zihui.zsevomob.ZMobEvoMod;
import net.zihui.zsevomob.items.ModItems;

// Initiates a new Minecraft tab that store items from this mod
@Mod.EventBusSubscriber(modid = ZMobEvoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModCreativeTabs {

    public static CreativeModeTab ZSEVOMOB_MOD;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        ZSEVOMOB_MOD = event.registerCreativeModeTab(new ResourceLocation(ZMobEvoMod.MOD_ID, "zsevomob_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.CRACK.get()))
                        .title(Component.translatable("creativemodetab.zsevomob_tab")));
    }
}



