package com.blocklegend001.morenuggets.items;

import com.blocklegend001.morenuggets.MoreNuggets;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

import static com.blocklegend001.morenuggets.items.ModItems.NUGGETS;

public class ModItemGroups {
    private static final Supplier<ItemStack> NETHER_NUGGET_SUPPLIER = () -> NUGGETS.get("netherite").getDefaultInstance();

    public static final CreativeModeTab MORENUGGETS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(MoreNuggets.MOD_ID, "morenuggets"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(NETHER_NUGGET_SUPPLIER.get().getItem()))
                    .title(Component.translatable("creativetab.morenuggets"))
                    .displayItems((parameters, output) -> {
                        NUGGETS.values().forEach(nugget -> output.accept(nugget.getDefaultInstance()));
                    }).build());

    public static void registerItemGroups() {
    }
}
