package github.jcsmecabricks.datagen;

import github.jcsmecabricks.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.RED_COPPER_LANTERN))
                .add(ModBlocks.getRK(ModBlocks.YELLOW_COPPER_LANTERN))
                .add(ModBlocks.getRK(ModBlocks.GREEN_COPPER_LANTERN))
                .add(ModBlocks.getRK(ModBlocks.ORANGE_COPPER_LANTERN))
                .add(ModBlocks.getRK(ModBlocks.LIME_COPPER_LANTERN))
                .add(ModBlocks.getRK(ModBlocks.CYAN_COPPER_LANTERN))
                .add(ModBlocks.getRK(ModBlocks.BLUE_COPPER_LANTERN))
                .add(ModBlocks.getRK(ModBlocks.LIGHT_BLUE_COPPER_LANTERN))
                .add(ModBlocks.getRK(ModBlocks.PURPLE_COPPER_LANTERN))
                .add(ModBlocks.getRK(ModBlocks.MAGENTA_COPPER_LANTERN))
                .add(ModBlocks.getRK(ModBlocks.PINK_COPPER_LANTERN))
                .add(ModBlocks.getRK(ModBlocks.BROWN_COPPER_LANTERN))
                .add(ModBlocks.getRK(ModBlocks.BLACK_COPPER_LANTERN))
                .add(ModBlocks.getRK(ModBlocks.DARK_GRAY_COPPER_LANTERN))
                .add(ModBlocks.getRK(ModBlocks.LIGHT_GRAY_COPPER_LANTERN))
                .add(ModBlocks.getRK(ModBlocks.WHITE_COPPER_LANTERN));
    }
}