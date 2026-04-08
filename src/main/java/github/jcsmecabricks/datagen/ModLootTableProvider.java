package github.jcsmecabricks.datagen;

import github.jcsmecabricks.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }
    @Override
    public void generate() {
        dropSelf(ModBlocks.RED_COPPER_LANTERN);
        dropSelf(ModBlocks.YELLOW_COPPER_LANTERN);
        dropSelf(ModBlocks.GREEN_COPPER_LANTERN);
        dropSelf(ModBlocks.ORANGE_COPPER_LANTERN);
        dropSelf(ModBlocks.LIME_COPPER_LANTERN);
        dropSelf(ModBlocks.CYAN_COPPER_LANTERN);
        dropSelf(ModBlocks.BLUE_COPPER_LANTERN);
        dropSelf(ModBlocks.LIGHT_BLUE_COPPER_LANTERN);
        dropSelf(ModBlocks.PURPLE_COPPER_LANTERN);
        dropSelf(ModBlocks.MAGENTA_COPPER_LANTERN);
        dropSelf(ModBlocks.PINK_COPPER_LANTERN);
        dropSelf(ModBlocks.BROWN_COPPER_LANTERN);
        dropSelf(ModBlocks.BLACK_COPPER_LANTERN);
        dropSelf(ModBlocks.DARK_GRAY_COPPER_LANTERN);
        dropSelf(ModBlocks.LIGHT_GRAY_COPPER_LANTERN);
        dropSelf(ModBlocks.WHITE_COPPER_LANTERN);
    }
}