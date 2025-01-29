package net.zihui.csprojmod.datagen;

import com.mojang.brigadier.LiteralMessage;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.zihui.csprojmod.CSProjMain;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CSProjMain.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
<<<<<<< Updated upstream
=======
        withExistingParent(ModItems.TIGER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.IRON_LEE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.IRON_SLYTHER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

>>>>>>> Stashed changes

    }

    private ItemModelBuilder simpleItem (RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                 new ResourceLocation("item/generated")).texture("layer0",
                 new ResourceLocation(CSProjMain.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(CSProjMain.MOD_ID, "item/" + item.getId().getPath()));
    }
}
