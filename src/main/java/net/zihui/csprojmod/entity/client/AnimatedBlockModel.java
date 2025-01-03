package net.zihui.csprojmod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.entity.custom.AnimatedBlockEntity;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedBlockModel extends GeoModel<AnimatedBlockEntity> {
    @Override
    public ResourceLocation getModelResource(AnimatedBlockEntity animatedBlockEntity) {
        return new ResourceLocation(CSProjMain.MOD_ID, "geo/animated_block.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedBlockEntity animatedBlockEntity) {
        return new ResourceLocation(CSProjMain.MOD_ID, "textures/block/animated_block.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedBlockEntity animatedBlockEntity) {
        return new ResourceLocation(CSProjMain.MOD_ID, "animations/animated_block.animation.json");
    }
}
