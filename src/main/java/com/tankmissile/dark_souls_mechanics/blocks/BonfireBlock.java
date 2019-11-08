package com.tankmissile.dark_souls_mechanics.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class BonfireBlock extends Block {
    protected static final VoxelShape ASH_PILE = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 4.0D, 13.0D);

    public boolean isFullCube(){
        return false;
    }

    public BonfireBlock () {
        super(Block.Properties.create(Material.EARTH)
                .hardnessAndResistance(50, 2400).harvestLevel(3).harvestTool(ToolType.PICKAXE)
                .lightValue(5));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return ASH_PILE;
    }

    @Override
    public VoxelShape getRenderShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return ASH_PILE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return ASH_PILE;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

}
