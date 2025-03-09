package com.blocklegend001.morenuggets.items;

import com.blocklegend001.morenuggets.MoreNuggets;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreNuggets.MOD_ID);

    public static final Map<String, RegistryObject<Item>> NUGGETS = Map.of(
            "redstone", ITEMS.register("redstone_nugget", () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreNuggets.MOD_ID, "redstone_nugget"))))),
            "charcoal", ITEMS.register("charcoal_nugget", () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreNuggets.MOD_ID, "charcoal_nugget"))))),
            "coal", ITEMS.register("coal_nugget", () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreNuggets.MOD_ID, "coal_nugget"))))),
            "diamond", ITEMS.register("diamond_nugget", () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreNuggets.MOD_ID, "diamond_nugget"))))),
            "netherite", ITEMS.register("netherite_nugget", () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreNuggets.MOD_ID, "netherite_nugget"))))),
            "emerald", ITEMS.register("emerald_nugget", () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreNuggets.MOD_ID, "emerald_nugget"))))),
            "lapis", ITEMS.register("lapis_nugget", () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreNuggets.MOD_ID, "lapis_nugget"))))),
            "copper", ITEMS.register("copper_nugget", () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreNuggets.MOD_ID, "copper_nugget")))))
    );

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
