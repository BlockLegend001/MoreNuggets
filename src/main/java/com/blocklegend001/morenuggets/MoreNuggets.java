package com.blocklegend001.morenuggets;

import com.blocklegend001.morenuggets.items.ModCreativeModeTabs;
import com.blocklegend001.morenuggets.items.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MoreNuggets.MOD_ID)
public class MoreNuggets {

    public static final String MOD_ID = "morenuggets";

    public MoreNuggets(FMLJavaModLoadingContext context) {
        var modGroupBus = context.getModBusGroup();
        ModItems.ITEMS.register(modGroupBus);
        ModCreativeModeTabs.register(modGroupBus);
    }
}