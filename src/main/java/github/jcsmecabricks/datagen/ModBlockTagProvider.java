package github.jcsmecabricks.datagen;

import github.jcsmecabricks.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RED_COPPER_LANTERN)
                .add(ModBlocks.YELLOW_COPPER_LANTERN)
                .add(ModBlocks.GREEN_COPPER_LANTERN)
                .add(ModBlocks.ORANGE_COPPER_LANTERN)
                .add(ModBlocks.LIME_COPPER_LANTERN)
                .add(ModBlocks.CYAN_COPPER_LANTERN)
                .add(ModBlocks.BLUE_COPPER_LANTERN)
                .add(ModBlocks.LIGHT_BLUE_COPPER_LANTERN)
                .add(ModBlocks.PURPLE_COPPER_LANTERN)
                .add(ModBlocks.MAGENTA_COPPER_LANTERN)
                .add(ModBlocks.PINK_COPPER_LANTERN)
                .add(ModBlocks.BROWN_COPPER_LANTERN)
                .add(ModBlocks.BLACK_COPPER_LANTERN)
                .add(ModBlocks.DARK_GRAY_COPPER_LANTERN)
                .add(ModBlocks.LIGHT_GRAY_COPPER_LANTERN)
                .add(ModBlocks.WHITE_COPPER_LANTERN);
    }
}