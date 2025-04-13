//package net.zihui.csprojmod.datagen;
//
//import net.minecraft.core.HolderLookup;
//import net.minecraft.data.PackOutput;
//import net.minecraft.data.loot.EntityLootSubProvider;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.flag.FeatureFlagSet;
//import net.minecraft.world.flag.FeatureFlags;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.level.storage.loot.LootPool;
//import net.minecraft.world.level.storage.loot.LootTable;
//import net.minecraft.world.level.storage.loot.entries.LootItem;
//import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
//import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
//import net.minecraftforge.common.data.ExistingFileHelper;
//import net.minecraftforge.registries.RegistryObject;
//import net.zihui.csprojmod.CSProjMain;
//import net.zihui.csprojmod.entity.ModEntities;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Set;
//import java.util.concurrent.CompletableFuture;
//import java.util.stream.Stream;
//
//import static org.openjdk.nashorn.internal.objects.NativeSymbol.iterator;
//
//public class ModMobLootTables extends EntityLootSubProvider {
//    public ModMobLootTables(PackOutput output) {
//        super(FeatureFlagSet.);
//    }
//
//
//    @Override
//    public void generate() {
//        registerMobDrop(ModEntities.IRON_SLYTHER.get(), Items.IRON_BLOCK, 0, 9);
//    }
//
//    private void registerMobDrop(EntityType<?> type, Item drop, float min, float max) {
//        int drops = (int) (min + max)/2;
//        this.add(type, LootTable.lootTable()
//                .withPool(LootPool.lootPool()
//                        .setRolls(ConstantValue.exactly(1))
//                        .add(LootItem.lootTableItem(drop)
//                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(drops))
//                                )
//                        )
//                )
//        );
//    }
//
//    @Override
//    protected Stream<EntityType<?>> getKnownEntityTypes() {
//    }
//}
//
