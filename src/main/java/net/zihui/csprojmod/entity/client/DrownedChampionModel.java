package net.zihui.csprojmod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.entity.custom.DrownedChampionEntity;
import software.bernie.geckolib.model.GeoModel;

public class DrownedChampionModel extends GeoModel<DrownedChampionEntity> {
    @Override
    public ResourceLocation getModelResource(DrownedChampionEntity drownedChampionEntity) {
        return new ResourceLocation(CSProjMain.MOD_ID, "geo/drowned_champion.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DrownedChampionEntity drownedChampionEntity) {
        return new ResourceLocation(CSProjMain.MOD_ID, "textures/entity/drowned_champion.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DrownedChampionEntity drownedChampionEntity) {
        return new ResourceLocation(CSProjMain.MOD_ID, "animations/drowned_champion.animation.json");
    }
}
