package net.zihui.zsevomob.items.custom;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.zihui.zsevomob.entity.goal.interfaces.SpecialAbility;
import net.zihui.zsevomob.items.cilent.SlytherArmorRenderer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

import java.util.function.Consumer;

public class SlytherArmorItem extends ArmorItem implements GeoItem, SpecialAbility {

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public SlytherArmorItem(ArmorMaterial armorMaterial, Type armorType, Properties props) {
        super(armorMaterial, armorType, props);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0,
                this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> animatedBlockEntityAnimationState) {
        animatedBlockEntityAnimationState.setAnimation(RawAnimation.begin().then("idle",
                Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private GeoArmorRenderer<SlytherArmorItem> renderer;

            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                                                                   EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null)
                    this.renderer = new SlytherArmorRenderer();
                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return renderer;
            }
        });
    }

    public static boolean isWearingArmor(LivingEntity entity, Item armorItem) {

    }
}
