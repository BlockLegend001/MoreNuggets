package com.blocklegend001.morenuggets.datagen;

import com.blocklegend001.morenuggets.MoreNuggets;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import static com.blocklegend001.morenuggets.items.ModItems.NUGGETS;

public class ModRecipeProvider extends RecipeProvider {
    private static final Map<Item, Supplier<Item>> MATERIAL_TO_NUGGET = Map.of(
            Items.REDSTONE, () -> NUGGETS.get("redstone").get(),
            Items.CHARCOAL, () -> NUGGETS.get("charcoal").get(),
            Items.COAL, () -> NUGGETS.get("coal").get(),
            Items.DIAMOND, () -> NUGGETS.get("diamond").get(),
            Items.NETHERITE_INGOT, () -> NUGGETS.get("netherite").get(),
            Items.EMERALD, () -> NUGGETS.get("emerald").get(),
            Items.LAPIS_LAZULI, () -> NUGGETS.get("lapis").get(),
            Items.COPPER_INGOT, () -> NUGGETS.get("copper").get()
    );

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        MATERIAL_TO_NUGGET.forEach((material, nuggetSupplier) -> addNuggetRecipes(material, nuggetSupplier.get(), recipeOutput));

        addSmeltingRecipes(recipeOutput);
    }

    private void addNuggetRecipes(Item material, Item nugget, RecipeOutput recipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, nugget, 9)
                .requires(material)
                .unlockedBy("has_" + Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(material)).getPath(), has(material))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreNuggets.MOD_ID, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(nugget)).getPath() + "_from_" + Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(material)).getPath()));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, material)
                .pattern("NNN").pattern("NNN").pattern("NNN")
                .define('N', nugget)
                .unlockedBy("has_" + Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(nugget)).getPath(), has(nugget))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreNuggets.MOD_ID, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(material)).getPath() + "_from_" + Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(nugget)).getPath()));
    }

    private void addSmeltingRecipes(RecipeOutput recipeOutput) {
        Map<Item, Set<Item>> nuggetToItems = Map.of(
                NUGGETS.get("diamond").get(), Set.of(Items.DIAMOND_HELMET, Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS, Items.DIAMOND_BOOTS,
                        Items.DIAMOND_SWORD, Items.DIAMOND_AXE, Items.DIAMOND_HOE, Items.DIAMOND_PICKAXE, Items.DIAMOND_SHOVEL),
                NUGGETS.get("netherite").get(), Set.of(Items.NETHERITE_HELMET, Items.NETHERITE_CHESTPLATE, Items.NETHERITE_LEGGINGS, Items.NETHERITE_BOOTS,
                        Items.NETHERITE_SWORD, Items.NETHERITE_AXE, Items.NETHERITE_HOE, Items.NETHERITE_PICKAXE, Items.NETHERITE_SHOVEL));

        nuggetToItems.forEach((nugget, items) -> items.forEach(item -> SimpleCookingRecipeBuilder.smelting(Ingredient.of(item), RecipeCategory.MISC, nugget, 1.0f, 100)
                .unlockedBy("has_" + Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath(), has(item))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MoreNuggets.MOD_ID, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath() + "_to_" + Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(nugget)).getPath()))));
    }
}