package com.blocklegend001.morenuggets.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;

import static com.blocklegend001.morenuggets.items.ModItems.NUGGETS;

public class ModItemModelProvider extends ModelProvider {
    public ModItemModelProvider(PackOutput packOutput, String modId) {
        super(packOutput, modId);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        NUGGETS.values().forEach(itemModel -> this.itemModel(itemModels, itemModel.get()));
    }

    public void itemModel(ItemModelGenerators itemModels, Item item)
    {
        itemModels.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
    }
}
