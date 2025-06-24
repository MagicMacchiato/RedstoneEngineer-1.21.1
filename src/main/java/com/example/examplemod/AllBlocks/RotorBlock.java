package com.example.examplemod.AllBlocks;

import com.example.examplemod.AllBlocks.BlockEntities.RotorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.Nullable;

public class RotorBlock extends Block implements EntityBlock{

    public static final DirectionProperty FACING = DirectionProperty.create("rotor_facing");

    public RotorBlock(Properties properties){
        super(properties);
        //register default block state
        registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH));
    }


    //create block state definition
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    // Block entity factory
    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new RotorBlockEntity(pos, state);
    }
}
