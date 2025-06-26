package com.magicmacchiato.redstoneengineer;

import com.magicmacchiato.redstoneengineer.Core.RedstoneEngineer;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RedstoneEngineer.MODID);

    public static final Supplier<CreativeModeTab> MAIN_TAB = TABS.register(RedstoneEngineer.MODID,
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("Redstone Engineer"))
                    .icon(() -> new ItemStack(Items.REDSTONE))
                    .build());

    public static void init(IEventBus modEventBus){
        TABS.register(modEventBus);
    }
}
