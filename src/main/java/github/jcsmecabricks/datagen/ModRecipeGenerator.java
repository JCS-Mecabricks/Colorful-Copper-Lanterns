package github.jcsmecabricks.datagen;

import github.jcsmecabricks.block.ModBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ModRecipeGenerator extends RecipeProvider {
    private final HolderGetter<Item> itemLookup;

    protected ModRecipeGenerator(HolderLookup.Provider registries, RecipeOutput exporter) {
        super(registries, exporter);
        itemLookup = registries.lookupOrThrow(Registries.ITEM);
    }

    @Override
    public void buildRecipes() {
        lanternRecipe(ModBlocks.RED_COPPER_LANTERN_ITEM, Items.RED_DYE, output);
        lanternRecipe(ModBlocks.YELLOW_COPPER_LANTERN_ITEM, Items.YELLOW_DYE, output);
        lanternRecipe(ModBlocks.GREEN_COPPER_LANTERN_ITEM, Items.GREEN_DYE, output);
        lanternRecipe(ModBlocks.ORANGE_COPPER_LANTERN_ITEM, Items.ORANGE_DYE, output);
        lanternRecipe(ModBlocks.LIME_COPPER_LANTERN_ITEM, Items.LIME_DYE, output);
        lanternRecipe(ModBlocks.CYAN_COPPER_LANTERN_ITEM, Items.CYAN_DYE, output);
        lanternRecipe(ModBlocks.BLUE_COPPER_LANTERN_ITEM, Items.BLUE_DYE, output);
        lanternRecipe(ModBlocks.LIGHT_BLUE_COPPER_LANTERN_ITEM, Items.LIGHT_BLUE_DYE, output);
        lanternRecipe(ModBlocks.PURPLE_COPPER_LANTERN_ITEM, Items.PURPLE_DYE, output);
        lanternRecipe(ModBlocks.MAGENTA_COPPER_LANTERN_ITEM, Items.MAGENTA_DYE, output);
        lanternRecipe(ModBlocks.PINK_COPPER_LANTERN_ITEM, Items.PINK_DYE, output);
        lanternRecipe(ModBlocks.BROWN_COPPER_LANTERN_ITEM, Items.BROWN_DYE, output);
        lanternRecipe(ModBlocks.BLACK_COPPER_LANTERN_ITEM, Items.BLACK_DYE, output);
        lanternRecipe(ModBlocks.DARK_GRAY_COPPER_LANTERN_ITEM, Items.GRAY_DYE, output);
        lanternRecipe(ModBlocks.LIGHT_GRAY_COPPER_LANTERN_ITEM, Items.LIGHT_GRAY_DYE, output);
        lanternRecipe(ModBlocks.WHITE_COPPER_LANTERN_ITEM, Items.WHITE_DYE, output);
    }

    private void lanternRecipe(Item item, Item ingredient, RecipeOutput exporter) {
        shapeless(RecipeCategory.DECORATIONS, item, 1)
                .requires(ingredient)
                .requires(Items.COPPER_LANTERN.unaffected())
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(exporter);
    }
}