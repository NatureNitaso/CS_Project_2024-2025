package net.zihui.csprojmod.effects;

import net.minecraft.advancements.critereon.MobEffectsPredicate;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zihui.csprojmod.CSProjMain;

public class ModEffects {

    public static DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CSProjMain.MOD_ID);

    public static final RegistryObject<MobEffect> EVELUTION =
            MOB_EFFECTS.register("eve", () -> new EvelutionEffect(MobEffectCategory.HARMFUL, 16753920));

    public static void register(IEventBus eventBus) { MOB_EFFECTS.register(eventBus);
    }
}
