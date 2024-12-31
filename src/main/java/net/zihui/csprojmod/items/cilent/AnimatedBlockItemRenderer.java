package net.zihui.csprojmod.items.cilent;

import net.zihui.csprojmod.blocks.entity.AnimatedBlock;
import net.zihui.csprojmod.items.custom.AnimatedBlockItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AnimatedBlockItemRenderer extends GeoItemRenderer<AnimatedBlockItem> {
    public AnimatedBlockItemRenderer() {
        super(new AnimatedBlockItemModel());
    }
}
