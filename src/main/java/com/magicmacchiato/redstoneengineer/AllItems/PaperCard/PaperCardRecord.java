package com.magicmacchiato.redstoneengineer.AllItems.PaperCard;


import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.List;

public record PaperCardRecord(List<Boolean> tables, List<String> strStream){
    public static final int tableRows = 25;
    public static final int tableCols = 32;
    public static final int LabelsRows = tableRows;
    public static final int LabelCols = tableCols;
    public static final int strLen = 16;


    public static class RecordCodec{
        public static final Codec<PaperCardRecord> PAPER_CARD_CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        Codec.list(Codec.BOOL, 0, tableCols * tableRows).fieldOf("bool_table").forGetter(PaperCardRecord::tables),
                        Codec.list(Codec.STRING, 0, LabelsRows * LabelsRows).fieldOf("str_stream").forGetter(PaperCardRecord::strStream)
                ).apply(instance, PaperCardRecord::new));

        public static final StreamCodec<ByteBuf, PaperCardRecord> PAPER_CARD_STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.BOOL.apply(ByteBufCodecs.list(tableCols * tableRows)), PaperCardRecord::tables,
                ByteBufCodecs.STRING_UTF8.apply(ByteBufCodecs.list(LabelsRows * LabelCols)), PaperCardRecord::strStream, PaperCardRecord::new
        );
    }
}



