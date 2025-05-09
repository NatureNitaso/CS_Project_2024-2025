package net.zihui.zsevomob.items.cilent;

import net.minecraft.resources.ResourceLocation;
import net.zihui.zsevomob.ZMobEvoMod;
import net.zihui.zsevomob.items.custom.GolemsFist;
import software.bernie.geckolib.model.GeoModel;

public class GolemsFistModel extends GeoModel<GolemsFist> {
    @Override
    public ResourceLocation getModelResource(GolemsFist animatable) {
        return new ResourceLocation(ZMobEvoMod.MOD_ID, "geo/golems_fist.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GolemsFist animatable) {
        return new ResourceLocation(ZMobEvoMod.MOD_ID, "textures/item/golems_fist.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GolemsFist animatable) {
        return new ResourceLocation(ZMobEvoMod.MOD_ID, "animations/golems_fist.animation.json");
    }
}