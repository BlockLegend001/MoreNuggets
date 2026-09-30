package com.blocklegend001.morenuggets.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

import static com.blocklegend001.morenuggets.items.ModItems.NUGGETS;

public class ModItemModelProvider extends FabricModelProvider {
    public ModItemModelProvider(FabricPackOutput fabricDataOutput) {
        super(fabricDataOutput);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        NUGGETS.values().forEach(nugget ->
                itemModelGenerator.generateFlatItem(nugget.asItem(), ModelTemplates.FLAT_ITEM)
        );
    }
}
