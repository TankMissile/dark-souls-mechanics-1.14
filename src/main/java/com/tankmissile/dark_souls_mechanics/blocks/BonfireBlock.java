package com.tankmissile.dark_souls_mechanics.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IEnviromentBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BonfireBlock extends Block {
    public static final Material ASH = new Material(MaterialColor.SNOW, false, false, true, false, false, false, false, PushReaction.BLOCK);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final VoxelShape ASH_PILE = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 4.0D, 13.0D);

    public BonfireBlock () {
        this(Block.Properties.create(ASH)
                .hardnessAndResistance(50, 2400).harvestLevel(3).harvestTool(ToolType.PICKAXE)
                .lightValue(12));
    }

    public BonfireBlock(Block.Properties props) {
        super(props);
        this.setDefaultState(this.getStateContainer().getBaseState()
                .with(FACING, Direction.NORTH)
                .with(LIT, Boolean.FALSE));
    }

    @Override
    public int getLightValue(BlockState state, IEnviromentBlockReader world, BlockPos pos) {
        return state.get(LIT) ? 15 : 0;
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        AxisAlignedBB bb = new AxisAlignedBB(pos.add(-20, -20, -20), pos.add(20,20,20));
        List<Entity> entities = worldIn.getEntitiesWithinAABB(Entity.class, bb, (entity) -> entity instanceof IMob);

        worldIn.playSound((double) ((float) pos.getX() + 0.5F), (double) ((float) pos.getY() + 0.5F), (double) ((float) pos.getZ() + 0.5F), SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 1f, worldIn.rand.nextFloat() * 0.2f + 0.1F, false);
        worldIn.playSound((double) ((float) pos.getX() + 0.5F), (double) ((float) pos.getY() + 0.5F), (double) ((float) pos.getZ() + 0.5F), SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0F + worldIn.rand.nextFloat(), worldIn.rand.nextFloat() * 0.7F + 0.3F, false);

        for(Entity e : entities) {
            e.remove();
        }

        // Reset player health, food, and effects to the "freshly spawned" state
        player.setHealth(player.getMaxHealth());
        FoodStats foodStats = player.getFoodStats();
        foodStats.setFoodLevel(20);
        foodStats.setFoodSaturationLevel(0);
        player.clearActivePotions();

        if (state.get(LIT) == Boolean.FALSE){
            worldIn.setBlockState(pos, state.with(LIT, Boolean.TRUE));
        }

        return true;
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (stateIn.get(LIT) == true && rand.nextInt(24) == 0) {
            worldIn.playSound((double) ((float) pos.getX() + 0.5F), (double) ((float) pos.getY() + 0.5F), (double) ((float) pos.getZ() + 0.5F), SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState()
                .with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return ASH_PILE;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(LIT);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation){
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror){
        return state.rotate(mirror.toRotation(state.get(FACING)));
    }
}
