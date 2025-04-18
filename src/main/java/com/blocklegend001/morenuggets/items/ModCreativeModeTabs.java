package com.blocklegend001.morenuggets.items;

import com.blocklegend001.morenuggets.MoreNuggets;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.blocklegend001.morenuggets.items.ModItems.NUGGETS;

public class ModCreativeModeTabs {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoreNuggets.MOD_ID);

    private static final Supplier<ItemStack> NETHERITE_NUGGET_SUPPLIER = () -> NUGGETS.get("netherite").get().getDefaultInstance();

    public static final RegistryObject<CreativeModeTab> MORENUGGETS_TAB = CREATIVE_MODE_TABS.register("morenuggets", () ->
            CreativeModeTab.builder().icon(NETHERITE_NUGGET_SUPPLIER)
                    .title(Component.translatable("creativetab.morenuggets"))
                    .displayItems((parameters, output) -> NUGGETS.values().forEach(nugget -> output.accept(nugget.get())))
                    .build());

    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
