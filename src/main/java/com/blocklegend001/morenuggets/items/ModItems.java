package com.blocklegend001.morenuggets.items;

import com.blocklegend001.morenuggets.MoreNuggets;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Map;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MoreNuggets.MODID);

    public static final Map<String, DeferredHolder<Item, Item>> NUGGETS = Map.of(
            "redstone", ITEMS.register("redstone_nugget", () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreNuggets.MODID, "redstone_nugget"))))),
            "charcoal", ITEMS.register("charcoal_nugget", () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreNuggets.MODID, "charcoal_nugget"))))),
            "coal", ITEMS.register("coal_nugget", () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreNuggets.MODID, "coal_nugget"))))),
            "diamond", ITEMS.register("diamond_nugget", () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreNuggets.MODID, "diamond_nugget"))))),
            "netherite", ITEMS.register("netherite_nugget", () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreNuggets.MODID, "netherite_nugget"))))),
            "emerald", ITEMS.register("emerald_nugget", () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreNuggets.MODID, "emerald_nugget"))))),
            "lapis", ITEMS.register("lapis_nugget", () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreNuggets.MODID, "lapis_nugget"))))),
            "copper", ITEMS.register("copper_nugget", () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreNuggets.MODID, "copper_nugget")))))
    );

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
