package net.zihui.csprojmod.entity.client.stash;

import net.minecraft.resources.ResourceLocation;
import net.zihui.csprojmod.ZMobEvoMod;
import net.zihui.csprojmod.entity.custom.stash.ShipwreckCaptainEntity;
import software.bernie.geckolib.model.GeoModel;

public class ShipwreckCaptainModel extends GeoModel<ShipwreckCaptainEntity> {
    @Override
    public ResourceLocation getModelResource(ShipwreckCaptainEntity shipwreckCaptainEntity) {
            return new ResourceLocation(ZMobEvoMod.MOD_ID, "geo/shipwreck_captain.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ShipwreckCaptainEntity shipwreckCaptainEntity) {
        return new ResourceLocation(ZMobEvoMod.MOD_ID, "textures/entity/shipwreck_captain.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ShipwreckCaptainEntity shipwreckCaptainEntity) {
        return new ResourceLocation(ZMobEvoMod.MOD_ID, "animations/shipwreck_captain.animation.json");
    }
}
