package net.zihui.csprojmod.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.zihui.csprojmod.entity.custom.AnimatedBlockEntity;
import org.jetbrains.annotations.Nullable;

public class AnimatedBlock extends BaseEntityBlock {
    public AnimatedBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AnimatedBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state){
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }
}
