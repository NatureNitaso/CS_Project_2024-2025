package net.zihui.csprojmod.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class SummonPedestal extends BaseEntityBlock {
    public Items summons;
    public ItemStack stored;
    public ItemStack itemHeld;
    public Entity storedEntity;

    public SummonPedestal(Block.Properties properties) {
        super(properties);
        stored = ItemStack.EMPTY;
        itemHeld = ItemStack.EMPTY;
//        storedEntity = (Entity) Entity.NULL;
    }


    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        itemHeld = player.getItemInHand(hand); // grabs item that's in the players hand upon interaction

        // Checks to see if this behavior is on the client or server side
        if (!level.isClientSide() && stored == ItemStack.EMPTY) {
            if (itemHeld.getItem() == Items.HEART_OF_THE_SEA) {
                itemHeld.split(1);
                setStoredItem(itemHeld.getTag(), player, hand);
                return InteractionResult.SUCCESS;
            } else {
                itemHeld.split(1);
                setStoredItem(itemHeld.getTag(), player, hand);
                return InteractionResult.SUCCESS;
            }
        } else {
            returnStoredItem(level, player, pos);
            return InteractionResult.SUCCESS;
        }
    }

    // Method to storeItem
    public void setStoredItem(CompoundTag tag, Player player, InteractionHand hand) {
        stored = itemHeld;
        stored.save(tag);
//        storedEntity = item.getEntityRepresentation();
    }

    // Method that drops the item at the block pos in the world
    public void returnStoredItem(Level level, Player player, BlockPos pos) {
        if (!level.isClientSide && stored != ItemStack.EMPTY) {
//            level.addFreshEntity();
            level.addFreshEntity(Objects.requireNonNull(stored.getItem().createEntity(level, player, stored)));
            stored = ItemStack.EMPTY;
//            storedEntity = (Entity) Entity.NULL;
        }
    }

    // Method checks player inventory before giving item
    public int inInventory(Player player, ItemStack item) {
        int count = 0;




        return count;
    }


    // Method for itemStored

//    public ItemStack manageStoredItem(BlockPos pos, Level level, BlockState state, Player player, InteractionHand hand) {
//        boolean isStoredEmpty = (stored == ItemStack.EMPTY); // Checks to see if stored == empty
//        boolean isHandEmpty = (player.getItemInHand(hand) != ItemStack.EMPTY); // Checks to see if hand is empty
//    }



    /* BLOCK ENTITY */

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }
}


    // Block Entity BELOW
//    @Override
//    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
//        return null;
//    }
