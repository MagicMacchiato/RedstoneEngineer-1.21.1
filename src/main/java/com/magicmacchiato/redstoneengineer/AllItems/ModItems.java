package com.magicmacchiato.redstoneengineer.AllItems;


import com.magicmacchiato.redstoneengineer.AllItems.PaperCard.PaperCard;
import com.magicmacchiato.redstoneengineer.AllItems.PaperCard.PaperCardRecord;
import com.magicmacchiato.redstoneengineer.AllItems.PaperCard.PunchedCard;
import com.magicmacchiato.redstoneengineer.ModDataComponents;
import com.tterrag.registrate.util.entry.ItemEntry;

import java.util.List;

import static com.magicmacchiato.redstoneengineer.Core.RedstoneEngineer.REGISTRATE;

public class ModItems{

    public static final ItemEntry<PaperCard> PAPER_CARD = REGISTRATE.get()
            .item("paper_card", PaperCard::new)
            .lang("Paper card")
            .register();

    public static final ItemEntry<PunchedCard> PUNCHED_CARD = REGISTRATE.get()
            .item("punched_card", PunchedCard::new)
            .properties(properties -> properties.component(ModDataComponents.PAPER_CARD_RECORD_DATA_COMPONENT.get(), new PaperCardRecord(
                    List.of(false),
                    List.of("")
            )))
            .lang("Punched card")
            .register();


    public static void init(){}
}
