package com.magicmacchiato.redstoneengineer;

import com.magicmacchiato.redstoneengineer.AllItems.PaperCard.PaperCardRecord;
import com.magicmacchiato.redstoneengineer.Core.RedstoneEngineer;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModDataComponents {

    public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, RedstoneEngineer.MODID);

    public static final Supplier<DataComponentType<PaperCardRecord>> PAPER_CARD_RECORD_DATA_COMPONENT = DATA_COMPONENTS.registerComponentType("paper_card_components",
            builder -> builder
                    .persistent(PaperCardRecord.RecordCodec.PAPER_CARD_CODEC)
                    .networkSynchronized(PaperCardRecord.RecordCodec.PAPER_CARD_STREAM_CODEC));


    public static void init(IEventBus modEventBus){
        DATA_COMPONENTS.register(modEventBus);
    }
}
