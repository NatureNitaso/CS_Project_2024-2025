package net.zihui.zsevomob.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zihui.zsevomob.ZMobEvoMod;

public class ModEffects {

    public static DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ZMobEvoMod.MOD_ID);

    public static final RegistryObject<MobEffect> EVELUTION =
            MOB_EFFECTS.register("eve", () -> new EvelutionEffect(MobEffectCategory.HARMFUL, 16753920));

    public static void register(IEventBus eventBus) { MOB_EFFECTS.register(eventBus);
    }
}
