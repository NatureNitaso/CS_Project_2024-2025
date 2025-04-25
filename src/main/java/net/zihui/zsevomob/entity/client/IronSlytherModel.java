package net.zihui.zsevomob.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.zihui.zsevomob.ZMobEvoMod;
import net.zihui.zsevomob.entity.custom.IronSlytherEntity;
import software.bernie.geckolib.model.GeoModel;

public class IronSlytherModel extends GeoModel<IronSlytherEntity> {
    @Override
    public ResourceLocation getModelResource(IronSlytherEntity animatable) {
        return new ResourceLocation(ZMobEvoMod.MOD_ID,
                "geo/iron_slyther.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IronSlytherEntity animatable) {
        return new ResourceLocation(ZMobEvoMod.MOD_ID,
                "textures/entity/iron_slyther.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IronSlytherEntity animatable) {
        return new ResourceLocation(ZMobEvoMod.MOD_ID,
                "animations/iron_slyther.animation.json");
    }
}
