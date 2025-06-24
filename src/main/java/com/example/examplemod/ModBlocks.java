package com.example.examplemod;

import com.example.examplemod.AllBlocks.RotorBlock;
import com.tterrag.registrate.util.entry.BlockEntry;

import static com.example.examplemod.Core.ExampleMod.REGISTRATE;

public class ModBlocks {

    public static final BlockEntry<RotorBlock> ROTOR_BLOCK = REGISTRATE.get()
            .block("rotor_block", RotorBlock::new)
            .properties(properties -> {return properties.strength(1f);})
            .lang("Rotor Block")
            .simpleItem()
            .register();


    public static void init(){}
}
