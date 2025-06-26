package com.magicmacchiato.redstoneengineer.AllBlocks.BlockEntities;

import com.magicmacchiato.redstoneengineer.AllItems.ModItems;
import com.magicmacchiato.redstoneengineer.ModBlockEntities;
import com.tterrag.registrate.builders.BlockEntityBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class RotorBlockEntity extends BlockEntity{

    public RotorBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.ROTOR_BLOCK_TILE.get(), pos, blockState);
    }


    private ItemStack CARD = ItemStack.EMPTY;

    //Add a (punched) card to the rotor
    public void addCard(ItemStack itemIn){
        if(!this.CARD.isEmpty() || !itemIn.is(ModItems.PAPER_CARD.asItem())) return;
        else{
            this.CARD = itemIn;
        }
    }







    public static BlockEntityBuilder.BlockEntityFactory<RotorBlockEntity> create(){
        return new BlockEntityBuilder.BlockEntityFactory<RotorBlockEntity>(){
            @Override
            public RotorBlockEntity create(BlockEntityType<RotorBlockEntity> type, BlockPos pos, BlockState state) {
                return new RotorBlockEntity(pos, state);
            }
        };
    }
}
