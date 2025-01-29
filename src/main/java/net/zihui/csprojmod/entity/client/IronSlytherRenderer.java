package net.zihui.csprojmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.entity.custom.IronSlytherEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class IronSlytherRenderer extends GeoEntityRenderer<IronSlytherEntity> {
    public IronSlytherRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new IronSlytherModel());
    }

    @Override
    public ResourceLocation getTextureLocation(IronSlytherEntity animatable) {
        return new ResourceLocation(CSProjMain.MOD_ID, "textures/entity/iron_slyther.png");
    }

    @Override
    public void render(IronSlytherEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
