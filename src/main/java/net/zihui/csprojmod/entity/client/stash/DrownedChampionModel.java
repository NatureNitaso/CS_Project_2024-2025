package net.zihui.csprojmod.entity.client.stash;

import net.minecraft.resources.ResourceLocation;
import net.zihui.csprojmod.ZMobEvoMod;
import net.zihui.csprojmod.entity.custom.stash.DrownedChampionEntity;
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
