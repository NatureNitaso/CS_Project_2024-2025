package net.zihui.csprojmod.entity.client.stash;

import net.minecraft.resources.ResourceLocation;
import net.zihui.csprojmod.ZMobEvoMod;
import net.zihui.csprojmod.entity.custom.stash.AnimatedBlockEntity;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedBlockModel extends GeoModel<AnimatedBlockEntity> {
    @Override
    public ResourceLocation getModelResource(AnimatedBlockEntity animatedBlockEntity) {
        return new ResourceLocation(ZMobEvoMod.MOD_ID, "geo/animated_block.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedBlockEntity animatedBlockEntity) {
        return new ResourceLocation(ZMobEvoMod.MOD_ID, "textures/block/animated_block.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedBlockEntity animatedBlockEntity) {
        return new ResourceLocation(ZMobEvoMod.MOD_ID, "animations/animated_block.animation.json");
    }
}
