package net.zihui.csprojmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.entity.custom.IronLeeEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class IronLeeRenderer extends GeoEntityRenderer<IronLeeEntity> {
    public IronLeeRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new IronLeeModel());
    }

    @Override
    public ResourceLocation getTextureLocation(IronLeeEntity animatable) {
        return new ResourceLocation(CSProjMain.MOD_ID, "textures/entity/iron_lee.png");
    }

    @Override
    public void render(IronLeeEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
