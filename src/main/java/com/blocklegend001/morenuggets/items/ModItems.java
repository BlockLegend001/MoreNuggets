package com.blocklegend001.morenuggets.items;

import com.blocklegend001.morenuggets.MoreNuggets;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.Map;
import java.util.function.Function;

public class ModItems {

    public static final Map<String, Item> NUGGETS = Map.of(
            "redstone", registerItem("redstone_nugget", Item::new),

            "charcoal", registerItem("charcoal_nugget", Item::new),

            "coal", registerItem("coal_nugget", Item::new),

            "diamond", registerItem("diamond_nugget", Item::new),

            "netherite", registerItem("netherite_nugget", Item::new),

            "emerald", registerItem("emerald_nugget", Item::new),

            "lapis", registerItem("lapis_nugget", Item::new),

            "copper", registerItem("copper_nugget", Item::new)
    );

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MoreNuggets.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreNuggets.MOD_ID, name)))));
    }

    public static void registerModItems() {
    }
}
