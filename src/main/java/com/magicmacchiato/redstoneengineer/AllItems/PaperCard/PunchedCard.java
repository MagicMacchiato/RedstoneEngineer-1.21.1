package com.magicmacchiato.redstoneengineer.AllItems.PaperCard;

import com.magicmacchiato.redstoneengineer.ModDataComponents;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import org.jetbrains.annotations.Nullable;

public class PunchedCard extends Item implements MutableDataComponentHolder{
    public PunchedCard(Properties properties) {
        super(properties);
        map.get(ModDataComponents.PAPER_CARD_RECORD_DATA_COMPONENT.get());
    }

    public DataComponentMap map;

    @Override
    public <T> @Nullable T set(DataComponentType<? super T> dataComponentType, @Nullable T t){
        return null;
    }

    @Override
    public <T> @Nullable T remove(DataComponentType<? extends T> dataComponentType){
        return null;
    }

    @Override
    public void applyComponents(DataComponentPatch dataComponentPatch){

    }

    @Override
    public void applyComponents(DataComponentMap dataComponentMap){

    }

    @Override
    public DataComponentMap getComponents(){
        return this.map;
    }
}
