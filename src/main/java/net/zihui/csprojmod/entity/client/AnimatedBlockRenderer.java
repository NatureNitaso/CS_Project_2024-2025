package net.zihui.csprojmod.entity.client;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zihui.csprojmod.entity.custom.AnimatedBlockEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class AnimatedBlockRenderer extends GeoBlockRenderer<AnimatedBlockEntity> {
    public AnimatedBlockRenderer(BlockEntityRendererProvider.Context context) {
        super(new AnimatedBlockModel());
    }
}
