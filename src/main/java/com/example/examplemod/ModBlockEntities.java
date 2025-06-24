package com.example.examplemod;


import com.example.examplemod.AllBlocks.BlockEntities.RotorBlockEntity;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

import static com.example.examplemod.Core.ExampleMod.REGISTRATE;

public class ModBlockEntities{

    public static final BlockEntityEntry<RotorBlockEntity> ROTOR_BLOCK_TILE = REGISTRATE.get()
            .blockEntity("rotor_block_entity", RotorBlockEntity.create())
            .validBlock(ModBlocks.ROTOR_BLOCK)
            .register();



    public static void init(){}
}
