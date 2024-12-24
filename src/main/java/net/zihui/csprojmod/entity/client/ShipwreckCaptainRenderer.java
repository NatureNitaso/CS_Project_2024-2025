package net.zihui.csprojmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.entity.custom.ShipwreckCaptainEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ShipwreckCaptainRenderer extends GeoEntityRenderer<ShipwreckCaptainEntity> {
    public ShipwreckCaptainRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ShipwreckCaptainModel());
    }

    @Override
    public ResourceLocation getTextureLocation(ShipwreckCaptainEntity animatable) {
        return new ResourceLocation(CSProjMain.MOD_ID, "textures/entity/shipwreck_captain.png");
    }

    @Override
    public void render(ShipwreckCaptainEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
