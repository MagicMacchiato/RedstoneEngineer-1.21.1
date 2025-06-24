package com.example.examplemod.Core;

import com.example.examplemod.AllItems.ModItems;
import com.example.examplemod.ModBlockEntities;
import com.example.examplemod.ModBlocks;
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

@Mod(ExampleMod.MODID)
public class ExampleMod{
    public static final String MODID = "examplemod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final NonNullSupplier<Registrate> REGISTRATE = NonNullSupplier.lazy(() -> Registrate.create(MODID));



    public ExampleMod(IEventBus modEventBus, ModContainer modContainer){
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        ModBlocks.init();
        ModItems.init();
        ModBlockEntities.init();
    }

    private void commonSetup(FMLCommonSetupEvent event){

    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event){
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents{

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
        }
    }
}
