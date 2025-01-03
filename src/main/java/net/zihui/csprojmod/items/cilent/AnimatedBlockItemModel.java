package net.zihui.csprojmod.items.cilent;

import net.minecraft.resources.ResourceLocation;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.items.custom.AnimatedBlockItem;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedBlockItemModel extends GeoModel<AnimatedBlockItem> {
    @Override
    public ResourceLocation getModelResource(AnimatedBlockItem animatedBlockItem) {
        return new ResourceLocation(CSProjMain.MOD_ID, "geo/animated_block.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedBlockItem animatedBlockItem) {
        return new ResourceLocation(CSProjMain.MOD_ID, "textures/block/animated_block.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedBlockItem animatedBlockItem) {
        return new ResourceLocation(CSProjMain.MOD_ID, "animations/animated_block.animation.json");
    }
}
