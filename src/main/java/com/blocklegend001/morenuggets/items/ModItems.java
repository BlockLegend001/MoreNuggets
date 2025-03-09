package com.blocklegend001.morenuggets.items;

import com.blocklegend001.morenuggets.MoreNuggets;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Map;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MoreNuggets.MODID);

    public static final Map<String, DeferredHolder<Item, Item>> NUGGETS = Map.of(
            "redstone", ITEMS.register("redstone_nugget", () -> new Item(new Item.Properties())),
            "charcoal", ITEMS.register("charcoal_nugget", () -> new Item(new Item.Properties())),
            "coal", ITEMS.register("coal_nugget", () -> new Item(new Item.Properties())),
            "diamond", ITEMS.register("diamond_nugget", () -> new Item(new Item.Properties())),
            "netherite", ITEMS.register("netherite_nugget", () -> new Item(new Item.Properties())),
            "emerald", ITEMS.register("emerald_nugget", () -> new Item(new Item.Properties())),
            "lapis", ITEMS.register("lapis_nugget", () -> new Item(new Item.Properties())),
            "copper", ITEMS.register("copper_nugget", () -> new Item(new Item.Properties()))
    );

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
