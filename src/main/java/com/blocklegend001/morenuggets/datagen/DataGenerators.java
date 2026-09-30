package com.blocklegend001.morenuggets.datagen;

import com.blocklegend001.morenuggets.MoreNuggets;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = MoreNuggets.MODID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherDara(GatherDataEvent.Client event) {
        var builder = new RegistrySetBuilder()
                .add(ModRecipeProvider.create());
        event.createReloadableRegistryObjects(builder);
        event.createProvider(ModItemModelProvider::new);
    }
}