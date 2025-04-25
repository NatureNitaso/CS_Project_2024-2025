package net.zihui.zsevomob.entity.client.stash;

import net.minecraft.resources.ResourceLocation;
import net.zihui.zsevomob.ZMobEvoMod;
import net.zihui.zsevomob.entity.custom.stash.DrownedChampionEntity;
import software.bernie.geckolib.model.GeoModel;

public class DrownedChampionModel extends GeoModel<DrownedChampionEntity> {
    @Override
    public ResourceLocation getModelResource(DrownedChampionEntity drownedChampionEntity) {
        return new ResourceLocation(ZMobEvoMod.MOD_ID, "geo/drowned_champion.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DrownedChampionEntity drownedChampionEntity) {
        return new ResourceLocation(ZMobEvoMod.MOD_ID, "textures/entity/drowned_champion.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DrownedChampionEntity drownedChampionEntity) {
        return new ResourceLocation(ZMobEvoMod.MOD_ID, "animations/drowned_champion.animation.json");
    }
}
