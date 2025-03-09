package com.blocklegend001.morenuggets;

import com.blocklegend001.morenuggets.items.ModItemGroups;
import com.blocklegend001.morenuggets.items.ModItems;
import net.fabricmc.api.ModInitializer;

public class MoreNuggets implements ModInitializer {
    public static final String MOD_ID = "morenuggets";

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();
    }
}
