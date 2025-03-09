package com.blocklegend001.morenuggets.items;

import com.blocklegend001.morenuggets.MoreNuggets;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.blocklegend001.morenuggets.items.ModItems.NUGGETS;

public class ModCreativeModeTabs {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoreNuggets.MODID);

    private static final Supplier<ItemStack> NETHER_NUGGR_SUPPLIER = () -> NUGGETS.get("netherite").get().getDefaultInstance();

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MORENUGGETS_TAB = CREATIVE_MODE_TABS.register("morenuggets", () ->
            CreativeModeTab.builder().icon(NETHER_NUGGR_SUPPLIER)
                    .title(Component.translatable("creativetab.morenuggets"))
                    .displayItems(((parameters, output) -> NUGGETS.values().forEach(nugget -> output.accept(nugget.get()))))
                    .build());

    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
