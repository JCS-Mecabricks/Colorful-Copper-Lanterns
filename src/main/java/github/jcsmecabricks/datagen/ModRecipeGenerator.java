package github.jcsmecabricks.datagen;

import github.jcsmecabricks.block.ModBlocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

public class ModRecipeGenerator extends RecipeGenerator {
    private final RegistryEntryLookup<Item> itemLookup;

    protected ModRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        super(registries, exporter);
        itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
    }

    @Override
    public void generate() {
        lanternRecipe(ModBlocks.RED_COPPER_LANTERN_ITEM, Items.RED_DYE, exporter);
        lanternRecipe(ModBlocks.YELLOW_COPPER_LANTERN_ITEM, Items.YELLOW_DYE, exporter);
        lanternRecipe(ModBlocks.GREEN_COPPER_LANTERN_ITEM, Items.GREEN_DYE, exporter);
        lanternRecipe(ModBlocks.ORANGE_COPPER_LANTERN_ITEM, Items.ORANGE_DYE, exporter);
        lanternRecipe(ModBlocks.LIME_COPPER_LANTERN_ITEM, Items.LIME_DYE, exporter);
        lanternRecipe(ModBlocks.CYAN_COPPER_LANTERN_ITEM, Items.CYAN_DYE, exporter);
        lanternRecipe(ModBlocks.BLUE_COPPER_LANTERN_ITEM, Items.BLUE_DYE, exporter);
        lanternRecipe(ModBlocks.LIGHT_BLUE_COPPER_LANTERN_ITEM, Items.LIGHT_BLUE_DYE, exporter);
        lanternRecipe(ModBlocks.PURPLE_COPPER_LANTERN_ITEM, Items.PURPLE_DYE, exporter);
        lanternRecipe(ModBlocks.MAGENTA_COPPER_LANTERN_ITEM, Items.MAGENTA_DYE, exporter);
        lanternRecipe(ModBlocks.PINK_COPPER_LANTERN_ITEM, Items.PINK_DYE, exporter);
        lanternRecipe(ModBlocks.BROWN_COPPER_LANTERN_ITEM, Items.BROWN_DYE, exporter);
        lanternRecipe(ModBlocks.BLACK_COPPER_LANTERN_ITEM, Items.BLACK_DYE, exporter);
        lanternRecipe(ModBlocks.DARK_GRAY_COPPER_LANTERN_ITEM, Items.GRAY_DYE, exporter);
        lanternRecipe(ModBlocks.LIGHT_GRAY_COPPER_LANTERN_ITEM, Items.LIGHT_GRAY_DYE, exporter);
        lanternRecipe(ModBlocks.WHITE_COPPER_LANTERN_ITEM, Items.WHITE_DYE, exporter);
    }

    private void lanternRecipe(Item item, Item ingredient, RecipeExporter exporter) {
        createShapeless(RecipeCategory.DECORATIONS, item, 1)
                .input(ingredient)
                .input(Items.COPPER_LANTERNS.unaffected())
                .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                .offerTo(exporter);
    }
}