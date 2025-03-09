package com.blocklegend001.morenuggets.datagen;

import com.blocklegend001.morenuggets.MoreNuggets;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import static com.blocklegend001.morenuggets.items.ModItems.NUGGETS;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput fabricDataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> wrapperLookupCompletableFuture) {
        super(fabricDataOutput, wrapperLookupCompletableFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                MATERIAL_TO_NUGGET.forEach((material, nugget) -> addNuggetRecipes(material, nugget.get(), exporter, this));
                addSmeltingRecipes(exporter);
            }
        };
    }

    private static final Map<Item, Supplier<Item>> MATERIAL_TO_NUGGET = Map.of(
            Items.REDSTONE, () -> NUGGETS.get("redstone"),
            Items.CHARCOAL, () -> NUGGETS.get("charcoal"),
            Items.COAL, () -> NUGGETS.get("coal"),
            Items.DIAMOND, () -> NUGGETS.get("diamond"),
            Items.NETHERITE_INGOT, () -> NUGGETS.get("netherite"),
            Items.EMERALD, () -> NUGGETS.get("emerald"),
            Items.LAPIS_LAZULI, () -> NUGGETS.get("lapis"),
            Items.COPPER_INGOT, () -> NUGGETS.get("copper")
    );

    private void addNuggetRecipes(Item material, Item nugget, RecipeExporter recipeOutput, RecipeGenerator recipeGenerator) {
        Identifier materialId = Registries.ITEM.getId(material);
        Identifier nuggetId = Registries.ITEM.getId(nugget);

        recipeGenerator.createShapeless(RecipeCategory.MISC, nugget, 9)
                .input(material)
                .criterion("has_" + materialId.getPath(), InventoryChangedCriterion.Conditions.items(material))
                .offerTo(recipeOutput, String.valueOf(Identifier.of(MoreNuggets.MOD_ID, nuggetId.getPath() + "_from_" + materialId.getPath())));

        recipeGenerator.createShaped(RecipeCategory.MISC, material)
                .pattern("NNN").pattern("NNN").pattern("NNN")
                .input('N', nugget)
                .criterion("has_" + nuggetId.getPath(), InventoryChangedCriterion.Conditions.items(nugget))
                .offerTo(recipeOutput, String.valueOf(Identifier.of(MoreNuggets.MOD_ID, materialId.getPath() + "_from_" + nuggetId.getPath())));
    }

    private void addSmeltingRecipes(RecipeExporter recipeOutput) {
        Map<Item, Set<Item>> nuggetToItems = Map.of(
                (NUGGETS.get("diamond").asItem()), Set.of(Items.DIAMOND_HELMET, Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS, Items.DIAMOND_BOOTS,
                        Items.DIAMOND_SWORD, Items.DIAMOND_AXE, Items.DIAMOND_HOE, Items.DIAMOND_PICKAXE, Items.DIAMOND_SHOVEL),
                (NUGGETS.get("netherite").asItem()), Set.of(Items.NETHERITE_HELMET, Items.NETHERITE_CHESTPLATE, Items.NETHERITE_LEGGINGS, Items.NETHERITE_BOOTS,
                        Items.NETHERITE_SWORD, Items.NETHERITE_AXE, Items.NETHERITE_HOE, Items.NETHERITE_PICKAXE, Items.NETHERITE_SHOVEL));

        nuggetToItems.forEach((nugget, items) -> items.forEach(item -> {
            Identifier itemId = Registries.ITEM.getId(item);
            Identifier nuggetId = Registries.ITEM.getId(nugget);

            CookingRecipeJsonBuilder.create(Ingredient.ofItems(item), RecipeCategory.MISC, nugget, 1.0f, 100, RecipeSerializer.SMELTING, SmeltingRecipe::new)
                    .criterion("has_" + itemId.getPath(), InventoryChangedCriterion.Conditions.items(item))
                    .offerTo(recipeOutput, String.valueOf(Identifier.of(MoreNuggets.MOD_ID, itemId.getPath() + "_to_" + nuggetId.getPath())));
        }));
    }

    @Override
    public String getName() {
        return "MoreNuggets Recipes";
    }
}
