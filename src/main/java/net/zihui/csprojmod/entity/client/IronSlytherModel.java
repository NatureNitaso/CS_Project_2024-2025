package net.zihui.csprojmod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.entity.custom.IronSlytherEntity;
import software.bernie.geckolib.model.GeoModel;

public class IronSlytherModel extends GeoModel<IronSlytherEntity> {
    @Override
    public ResourceLocation getModelResource(IronSlytherEntity animatable) {
        return new ResourceLocation(CSProjMain.MOD_ID, "geo/iron_slyther.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IronSlytherEntity animatable) {
        return new ResourceLocation(CSProjMain.MOD_ID, "textures/entity/iron_slyther.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IronSlytherEntity animatable) {
        return new ResourceLocation(CSProjMain.MOD_ID, "animations/iron_slyther.animation.json");
    }
}
