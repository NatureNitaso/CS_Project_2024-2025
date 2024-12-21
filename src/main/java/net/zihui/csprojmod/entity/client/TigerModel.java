package net.zihui.csprojmod.entity.client;

import net.minecraft.client.model.EntityModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.entity.custom.TigerEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class TigerModel extends GeoModel<TigerEntity> {
    @Override
    public ResourceLocation getModelResource(TigerEntity tigerEntity) {
        return new ResourceLocation(CSProjMain.MOD_ID, "geo/tiger.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TigerEntity tigerEntity) {
        return new ResourceLocation(CSProjMain.MOD_ID, "textures/entity/tiger.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TigerEntity tigerEntity) {
        return new ResourceLocation(CSProjMain.MOD_ID, "animations/tiger.animation.json");
    }

    @Override
    public void setCustomAnimations (TigerEntity animations, long instanceId, AnimationState<TigerEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData data = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            // Sets head's x pos
            head.setRotX(data.headPitch() * Mth.DEG_TO_RAD);
            // Sets head's y pos
            head.setRotY(data.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
