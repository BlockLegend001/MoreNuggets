package com.blocklegend001.morenuggets;

import com.blocklegend001.morenuggets.items.ModCreativeModeTabs;
import com.blocklegend001.morenuggets.items.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MoreNuggets.MOD_ID)
public class MoreNuggets {

    public static final String MOD_ID = "morenuggets";

    public MoreNuggets() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}