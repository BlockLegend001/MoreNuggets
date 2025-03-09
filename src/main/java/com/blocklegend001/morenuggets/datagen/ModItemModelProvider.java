package com.blocklegend001.morenuggets.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

import static com.blocklegend001.morenuggets.items.ModItems.NUGGETS;

public class ModItemModelProvider extends FabricModelProvider {
    public ModItemModelProvider(FabricDataOutput fabricDataOutput) {
        super(fabricDataOutput);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        NUGGETS.values().forEach(nugget ->
                itemModelGenerator.register(nugget.asItem(), Models.GENERATED)
        );
    }
}
