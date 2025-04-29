package net.zihui.zsevomob.entity.client.stash;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zihui.zsevomob.entity.custom.AnimatedBlockEntity;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class AnimatedBlockRenderer extends GeoBlockRenderer<AnimatedBlockEntity> {
    public AnimatedBlockRenderer(BlockEntityRendererProvider.Context context) {
        super(new AnimatedBlockModel());
    }
}
