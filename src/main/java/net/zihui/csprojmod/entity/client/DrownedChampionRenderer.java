package net.zihui.csprojmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.entity.custom.DrownedChampionEntity;
import net.zihui.csprojmod.entity.custom.ShipwreckCaptainEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DrownedChampionRenderer extends GeoEntityRenderer<DrownedChampionEntity> {
    public DrownedChampionRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DrownedChampionModel());
    }

    @Override
    public ResourceLocation getTextureLocation(DrownedChampionEntity animatable) {
        return new ResourceLocation(CSProjMain.MOD_ID, "textures/entity/drowned_champion.png");
    }

    @Override
    public void render(DrownedChampionEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
