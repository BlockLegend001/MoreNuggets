package com.blocklegend001.morenuggets.datagen;

import com.blocklegend001.morenuggets.MoreNuggets;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import static com.blocklegend001.morenuggets.items.ModItems.NUGGETS;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, MoreNuggets.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        NUGGETS.values().forEach(this::simpleItem);
    }

    private ItemModelBuilder simpleItem(DeferredHolder<Item, Item> item) {
        return withExistingParent(item.getId().getPath(), ResourceLocation.withDefaultNamespace("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(MoreNuggets.MODID, "item/" + item.getId().getPath()));
    }
}
