package net.zihui.zsevomob.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import net.zihui.zsevomob.ZMobEvoMod;
import net.zihui.zsevomob.items.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EVE_LOTION.get())
                .pattern("ABC")
                .pattern("EDE")
                .pattern("WBA")
                .define('A', Items.MAGMA_BLOCK)
                .define('B', Items.GOLD_BLOCK)
                .define('C', Items.COPPER_BLOCK)
                .define('D', Items.DRAGON_BREATH)
                .define('E', Items.REDSTONE_BLOCK)
                .define('W', Items.WAXED_COPPER_BLOCK)
                .unlockedBy("has_dragon_breath", has(Items.DRAGON_BREATH))
                .save(recipeConsumer);

    }
}
