package com.magicmacchiato.redstoneengineer.Core;

import com.magicmacchiato.redstoneengineer.AllItems.ModItems;
import com.magicmacchiato.redstoneengineer.ModBlockEntities;
import com.magicmacchiato.redstoneengineer.ModBlocks;
import com.magicmacchiato.redstoneengineer.ModDataComponents;
import com.magicmacchiato.redstoneengineer.ModCreativeModeTabs;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(RedstoneEngineer.MODID)
public class RedstoneEngineer {
    public static final String MODID = "redstoneengineer";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final NonNullSupplier<Registrate> REGISTRATE = NonNullSupplier.lazy(() -> Registrate.create(MODID));



    public RedstoneEngineer(IEventBus modEventBus, ModContainer modContainer){
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        ModCreativeModeTabs.init(modEventBus);
        ModItems.init();
        ModDataComponents.init(modEventBus);
        ModBlocks.init();
        ModBlockEntities.init();
    }

    private void commonSetup(FMLCommonSetupEvent event){

    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event){
    }

    @EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
    public static class ClientModEvents{

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
        }
    }
}
