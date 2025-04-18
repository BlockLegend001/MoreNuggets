package com.blocklegend001.morenuggets.datagen;

import com.blocklegend001.morenuggets.MoreNuggets;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = MoreNuggets.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherDara(GatherDataEvent.Client event) {
        PackOutput packOutput = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        event.addProvider(new ModRecipeProvider.Runner(packOutput, lookupProvider));
        event.addProvider(new ModItemModelProvider(packOutput, MoreNuggets.MODID));
    }
}
