package com.blocklegend001.morenuggets.items;

import com.blocklegend001.morenuggets.MoreNuggets;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ModItems {

    public static final Map<String, Item> NUGGETS = Map.of(
            "redstone", registerItem("redstone_nugget", new Item(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreNuggets.MOD_ID, "redstone_nugget"))))),

            "charcoal", registerItem("charcoal_nugget", new Item(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreNuggets.MOD_ID, "charcoal_nugget"))))),

            "coal", registerItem("coal_nugget", new Item(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreNuggets.MOD_ID, "coal_nugget"))))),

            "diamond", registerItem("diamond_nugget", new Item(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreNuggets.MOD_ID, "diamond_nugget"))))),

            "netherite", registerItem("netherite_nugget", new Item(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreNuggets.MOD_ID, "netherite_nugget"))))),

            "emerald", registerItem("emerald_nugget", new Item(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreNuggets.MOD_ID, "emerald_nugget"))))),

            "lapis", registerItem("lapis_nugget", new Item(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreNuggets.MOD_ID, "lapis_nugget"))))),

            "copper", registerItem("copper_nugget", new Item(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreNuggets.MOD_ID, "copper_nugget")))))
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MoreNuggets.MOD_ID, name), item);
    }

    public static void registerModItems() {
    }
}
