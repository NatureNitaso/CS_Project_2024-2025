package net.zihui.zsevomob.items.cilent;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.zihui.zsevomob.ZMobEvoMod;
import net.zihui.zsevomob.items.custom.GolemsFist;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GolemsFistRenderer extends GeoItemRenderer<GolemsFist> {
    public GolemsFistRenderer() {
        super(new GolemsFistModel());
    }

    @Override
    public ResourceLocation getTextureLocation(GolemsFist animatable) {
        return new ResourceLocation(ZMobEvoMod.MOD_ID, "textures/item/golems_fist.png");
    }
}
