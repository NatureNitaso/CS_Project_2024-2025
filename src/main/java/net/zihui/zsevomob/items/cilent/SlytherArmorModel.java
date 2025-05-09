package net.zihui.zsevomob.items.cilent;

import net.minecraft.resources.ResourceLocation;
import net.zihui.zsevomob.ZMobEvoMod;
import net.zihui.zsevomob.items.custom.SlytherArmorItem;
import software.bernie.geckolib.model.GeoModel;

import java.util.zip.ZipEntry;

public class SlytherArmorModel extends GeoModel<SlytherArmorItem> {
    @Override
    public ResourceLocation getModelResource(SlytherArmorItem animatable) {
        return new ResourceLocation(ZMobEvoMod.MOD_ID, "geo/slyther_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SlytherArmorItem animatable) {
        return new ResourceLocation(ZMobEvoMod.MOD_ID, "textures/armor/slyther_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SlytherArmorItem animatable) {
        return new ResourceLocation(ZMobEvoMod.MOD_ID, "animations/slyther_armor.animation.json");
    }
}
