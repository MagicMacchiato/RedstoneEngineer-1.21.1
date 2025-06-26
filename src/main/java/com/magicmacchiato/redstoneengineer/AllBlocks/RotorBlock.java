package com.magicmacchiato.redstoneengineer.AllBlocks;

import com.magicmacchiato.redstoneengineer.AllBlocks.BlockEntities.RotorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
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

    // instrument types and its index (hard code) map
    // Note pitch listed from 0-24 (25 members); formula = 2^((pitch - 12)/12); Math.pow(2.0, (pitch - 12)/12)
    public enum INSTR_INDEX{BASS, BELL, CHIME, FLUTE, GUITAR, HARP, HAT, PLING, SNARE, XYLOPHONE, IRON_XYLOPHONE, COW_BELL, DIDFERIDOO, BIT, BANJO}
    private static final SoundEvent[] INSTR_SOUND = {SoundEvents.NOTE_BLOCK_BASEDRUM.value(),
            SoundEvents.NOTE_BLOCK_BASS.value(),
            SoundEvents.NOTE_BLOCK_BELL.value(),
            SoundEvents.NOTE_BLOCK_CHIME.value(),
            SoundEvents.NOTE_BLOCK_FLUTE.value(),
            SoundEvents.NOTE_BLOCK_GUITAR.value(),
            SoundEvents.NOTE_BLOCK_HARP.value(),
            SoundEvents.NOTE_BLOCK_HAT.value(),
            SoundEvents.NOTE_BLOCK_PLING.value(),
            SoundEvents.NOTE_BLOCK_SNARE.value(),
            SoundEvents.NOTE_BLOCK_XYLOPHONE.value(),
            SoundEvents.NOTE_BLOCK_IRON_XYLOPHONE.value(),
            SoundEvents.NOTE_BLOCK_COW_BELL.value(),
            SoundEvents.NOTE_BLOCK_DIDGERIDOO.value(),
            SoundEvents.NOTE_BLOCK_BIT.value(),
            SoundEvents.NOTE_BLOCK_BANJO.value()};







    //set block to face opposite of the player (placer)
    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        Direction direction = placer.getDirection().getOpposite();
        level.setBlock(pos, state.setValue(FACING, direction), 0);
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
