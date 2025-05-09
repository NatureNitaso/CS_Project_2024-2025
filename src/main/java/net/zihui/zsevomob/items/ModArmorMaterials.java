package net.zihui.zsevomob.items;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    SLYTHER("slyther", 30, Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
        enumMap.put(ArmorItem.Type.CHESTPLATE, 3);
        enumMap.put(ArmorItem.Type.HELMET, 4);
    }), 16, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.5F, 0.2F, () -> {
        return Ingredient.of(ModItems.SLYTHER_HORN.get());
    });

    public static final StringRepresentable.EnumCodec<ArmorMaterials> CODEC = StringRepresentable.fromEnum(ArmorMaterials::values);
    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266653_) -> {
        p_266653_.put(ArmorItem.Type.CHESTPLATE, 8);
        p_266653_.put(ArmorItem.Type.HELMET, 18);
    });
    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private ModArmorMaterials(String name, int durabilitymult, EnumMap<ArmorItem.Type, Integer> procFunc, int enchantVal, SoundEvent soundEvent, float armorTough, float kbRes, Supplier<Ingredient> repairMat) {
        this.name = name;
        this.durabilityMultiplier = durabilitymult;
        this.protectionFunctionForType = procFunc;
        this.enchantmentValue = enchantVal;
        this.sound = soundEvent;
        this.toughness = armorTough;
        this.knockbackResistance = kbRes;
        this.repairIngredient = new LazyLoadedValue<>(repairMat);
    }

    public int getDurabilityForType(ArmorItem.Type type) {
        return HEALTH_FUNCTION_FOR_TYPE.get(type) * this.durabilityMultiplier;
    }

    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionFunctionForType.get(type);
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    public String getSerializedName() {
        return this.name;
    }
}
