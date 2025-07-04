package com.blocklegend001.morenuggets.items;

import com.blocklegend001.morenuggets.MoreNuggets;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

import static com.blocklegend001.morenuggets.items.ModItems.NUGGETS;

public class ModItemGroups {
    private static final Supplier<ItemStack> NETHER_NUGGR_SUPPLIER = () -> NUGGETS.get("netherite").getDefaultStack();


    public static final ItemGroup MORENUGGETS_TAB = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MoreNuggets.MOD_ID, "morenuggets"),
            FabricItemGroup.builder().icon(() -> new ItemStack(NETHER_NUGGR_SUPPLIER.get().getItem()))
                    .displayName(Text.translatable("creativetab.morenuggets"))
                    .entries(((parameters, output) -> {
                        NUGGETS.values().forEach(nugget -> output.add(nugget.getDefaultStack()));

                    })).build());
    public static void registerItemGroups() {
    }
}
