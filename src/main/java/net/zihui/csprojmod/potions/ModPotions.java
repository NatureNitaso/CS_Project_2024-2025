package net.zihui.csprojmod.potions;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.effects.ModEffects;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, CSProjMain.MOD_ID);

    public static final RegistryObject<Potion> EVE_LOTION =
            POTIONS.register("eve_lotion", () -> new Potion
                    (new MobEffectInstance(ModEffects.EVELUTION.get(), 200, 1)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
