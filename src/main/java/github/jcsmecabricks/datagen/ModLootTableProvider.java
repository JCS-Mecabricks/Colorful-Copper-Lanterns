package github.jcsmecabricks.datagen;

import github.jcsmecabricks.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }
    @Override
    public void generate() {
        addDrop(ModBlocks.RED_COPPER_LANTERN);
        addDrop(ModBlocks.YELLOW_COPPER_LANTERN);
        addDrop(ModBlocks.GREEN_COPPER_LANTERN);
        addDrop(ModBlocks.ORANGE_COPPER_LANTERN);
        addDrop(ModBlocks.LIME_COPPER_LANTERN);
        addDrop(ModBlocks.CYAN_COPPER_LANTERN);
        addDrop(ModBlocks.BLUE_COPPER_LANTERN);
        addDrop(ModBlocks.LIGHT_BLUE_COPPER_LANTERN);
        addDrop(ModBlocks.PURPLE_COPPER_LANTERN);
        addDrop(ModBlocks.MAGENTA_COPPER_LANTERN);
        addDrop(ModBlocks.PINK_COPPER_LANTERN);
        addDrop(ModBlocks.BROWN_COPPER_LANTERN);
        addDrop(ModBlocks.BLACK_COPPER_LANTERN);
        addDrop(ModBlocks.DARK_GRAY_COPPER_LANTERN);
        addDrop(ModBlocks.LIGHT_GRAY_COPPER_LANTERN);
        addDrop(ModBlocks.WHITE_COPPER_LANTERN);
    }
}