package com.blocklegend001.morenuggets.datagen;

import com.blocklegend001.morenuggets.MoreNuggets;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Recipe;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;


import static com.blocklegend001.morenuggets.items.ModItems.NUGGETS;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {
        return new RecipeProvider(recipes, advancements) {
            @Override
            public void buildRecipes() {
                MATERIAL_TO_NUGGET.forEach((material, nugget) -> addNuggetRecipes(material, nugget.get(), output, this));
                addSmeltingRecipes(output, this);
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

    private void addNuggetRecipes(Item material, Item nugget, RecipeOutput recipeOutput, RecipeProvider recipeGenerator) {
        Identifier materialId = BuiltInRegistries.ITEM.getKey(material);
        Identifier nuggetId = BuiltInRegistries.ITEM.getKey(nugget);

        recipeGenerator.shapeless(RecipeCategory.MISC, nugget, 9)
                .requires(material)
                .unlockedBy("has_" + materialId.getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(material))
                .save(recipeOutput, String.valueOf(Identifier.fromNamespaceAndPath(MoreNuggets.MOD_ID, nuggetId.getPath() + "_from_" + materialId.getPath())));

        recipeGenerator.shaped(RecipeCategory.MISC, material)
                .pattern("NNN").pattern("NNN").pattern("NNN")
                .define('N', nugget)
                .unlockedBy("has_" + nuggetId.getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(nugget))
                .save(recipeOutput, String.valueOf(Identifier.fromNamespaceAndPath(MoreNuggets.MOD_ID, materialId.getPath() + "_from_" + nuggetId.getPath())));
    }

    private void addSmeltingRecipes(RecipeOutput recipeOutput, RecipeProvider recipeProvider) {
        Map<Item, Set<Item>> nuggetToItems = Map.of(
                (NUGGETS.get("diamond").asItem()), Set.of(Items.DIAMOND_HELMET, Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS, Items.DIAMOND_BOOTS,
                        Items.DIAMOND_SWORD, Items.DIAMOND_AXE, Items.DIAMOND_HOE, Items.DIAMOND_PICKAXE, Items.DIAMOND_SHOVEL),
                (NUGGETS.get("netherite").asItem()), Set.of(Items.NETHERITE_HELMET, Items.NETHERITE_CHESTPLATE, Items.NETHERITE_LEGGINGS, Items.NETHERITE_BOOTS,
                        Items.NETHERITE_SWORD, Items.NETHERITE_AXE, Items.NETHERITE_HOE, Items.NETHERITE_PICKAXE, Items.NETHERITE_SHOVEL));

        nuggetToItems.forEach((nugget, items) -> items.forEach(item -> {
            Identifier itemId   = BuiltInRegistries.ITEM.getKey(item);
            Identifier nuggetId = BuiltInRegistries.ITEM.getKey(nugget);

            recipeProvider.oreSmelting(
                    List.of(item),
                    RecipeCategory.MISC,
                    CookingBookCategory.MISC,
                    nugget,
                    1.0f,
                    100,
                    MoreNuggets.MOD_ID + ":" + itemId.getPath() + "_to_" + nuggetId.getPath()
            );
        }));
    }

    @Override
    public String getName() {
        return "MoreNuggets Recipes";
    }
}
