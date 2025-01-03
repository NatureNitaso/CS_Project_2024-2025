package net.zihui.csprojmod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.entity.custom.IronLeeEntity;
import software.bernie.geckolib.model.GeoModel;

public class IronLeeModel extends GeoModel<IronLeeEntity> {
    @Override
    public ResourceLocation getModelResource(IronLeeEntity ironLeeEntity) {
        return new ResourceLocation(CSProjMain.MOD_ID, "geo/iron_lee.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IronLeeEntity ironLeeEntity) {
        return new ResourceLocation(CSProjMain.MOD_ID, "texture/entity/iron_lee.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IronLeeEntity ironLeeEntity) {
        return new ResourceLocation(CSProjMain.MOD_ID, "animations/iron_lee.animation.json");
    }
}
