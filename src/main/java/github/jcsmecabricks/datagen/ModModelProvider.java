package github.jcsmecabricks.datagen;

import github.jcsmecabricks.block.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModBlocks.RED_COPPER_LANTERN_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.YELLOW_COPPER_LANTERN_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.GREEN_COPPER_LANTERN_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.ORANGE_COPPER_LANTERN_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.LIME_COPPER_LANTERN_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.CYAN_COPPER_LANTERN_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.BLUE_COPPER_LANTERN_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.LIGHT_BLUE_COPPER_LANTERN_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.PURPLE_COPPER_LANTERN_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.MAGENTA_COPPER_LANTERN_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.PINK_COPPER_LANTERN_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.BROWN_COPPER_LANTERN_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.BLACK_COPPER_LANTERN_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.DARK_GRAY_COPPER_LANTERN_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.LIGHT_GRAY_COPPER_LANTERN_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.WHITE_COPPER_LANTERN_ITEM, Models.GENERATED);
    }
}