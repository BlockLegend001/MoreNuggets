package com.blocklegend001.morenuggets.items;

import com.blocklegend001.morenuggets.MoreNuggets;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ModItems {

    public static final Map<String, Item> NUGGETS = Map.of(
            "redstone", registerItem("redstone_nugget", new Item(new Item.Settings())),
            "charcoal", registerItem("charcoal_nugget", new Item(new Item.Settings())),
            "coal", registerItem("coal_nugget", new Item(new Item.Settings())),
            "diamond", registerItem("diamond_nugget", new Item(new Item.Settings())),
            "netherite", registerItem("netherite_nugget", new Item(new Item.Settings())),
            "emerald", registerItem("emerald_nugget", new Item(new Item.Settings())),
            "lapis", registerItem("lapis_nugget", new Item(new Item.Settings())),
            "copper", registerItem("copper_nugget", new Item(new Item.Settings()))
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MoreNuggets.MOD_ID, name), item);
    }

    public static void registerModItems() {
    }
}
