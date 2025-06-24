package com.example.examplemod.AllItems;


import com.tterrag.registrate.util.entry.ItemEntry;

import static com.example.examplemod.Core.ExampleMod.REGISTRATE;

public class ModItems{

    public static final ItemEntry<PaperCard> PAPER_CARD = REGISTRATE.get()
            .item("paper_card", PaperCard::new)
            .lang("Paper card")
            .register();


    public static void init(){}
}
