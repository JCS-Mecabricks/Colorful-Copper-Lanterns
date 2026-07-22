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
        lanternRecipe(ModBlocks.RED_COPPER_LANTERN_ITEM, Items.DYE.red(), output);
        lanternRecipe(ModBlocks.YELLOW_COPPER_LANTERN_ITEM, Items.DYE.yellow(), output);
        lanternRecipe(ModBlocks.GREEN_COPPER_LANTERN_ITEM, Items.DYE.green(), output);
        lanternRecipe(ModBlocks.ORANGE_COPPER_LANTERN_ITEM, Items.DYE.orange(), output);
        lanternRecipe(ModBlocks.LIME_COPPER_LANTERN_ITEM, Items.DYE.lime(), output);
        lanternRecipe(ModBlocks.CYAN_COPPER_LANTERN_ITEM, Items.DYE.cyan(), output);
        lanternRecipe(ModBlocks.BLUE_COPPER_LANTERN_ITEM, Items.DYE.blue(), output);
        lanternRecipe(ModBlocks.LIGHT_BLUE_COPPER_LANTERN_ITEM, Items.DYE.lightBlue(), output);
        lanternRecipe(ModBlocks.PURPLE_COPPER_LANTERN_ITEM, Items.DYE.purple(), output);
        lanternRecipe(ModBlocks.MAGENTA_COPPER_LANTERN_ITEM, Items.DYE.magenta(), output);
        lanternRecipe(ModBlocks.PINK_COPPER_LANTERN_ITEM, Items.DYE.pink(), output);
        lanternRecipe(ModBlocks.BROWN_COPPER_LANTERN_ITEM, Items.DYE.brown(), output);
        lanternRecipe(ModBlocks.BLACK_COPPER_LANTERN_ITEM, Items.DYE.black(), output);
        lanternRecipe(ModBlocks.DARK_GRAY_COPPER_LANTERN_ITEM, Items.DYE.gray(), output);
        lanternRecipe(ModBlocks.LIGHT_GRAY_COPPER_LANTERN_ITEM, Items.DYE.lightGray(), output);
        lanternRecipe(ModBlocks.WHITE_COPPER_LANTERN_ITEM, Items.DYE.white(), output);
    }

    private void lanternRecipe(Item item, Item ingredient, RecipeOutput exporter) {
        shapeless(RecipeCategory.DECORATIONS, item, 1)
                .requires(ingredient)
                .requires(Items.COPPER_LANTERN.waxed().unaffected())
                .requires(Items.COPPER_LANTERN.weathering().unaffected())
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(exporter);
    }
}