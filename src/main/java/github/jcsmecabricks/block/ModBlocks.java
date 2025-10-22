package github.jcsmecabricks.block;

import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import github.jcsmecabricks.ColoredCopperLanterns;
import github.jcsmecabricks.block.lantern.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static github.jcsmecabricks.ColoredCopperLanterns.MOD_ID;

public class ModBlocks {
    public static final Block RED_COPPER_LANTERN = registerBlock("red_copper_lantern", RedCopperLantern::new, Block.Settings.copy(Blocks.COPPER_LANTERNS.getAll().get(1)));
    public static final Block YELLOW_COPPER_LANTERN = registerBlock("yellow_copper_lantern", YellowCopperLantern::new, Block.Settings.copy(Blocks.COPPER_LANTERNS.getAll().get(1)));
    public static final Block GREEN_COPPER_LANTERN = registerBlock("green_copper_lantern", GreenCopperLantern::new, Block.Settings.copy(Blocks.COPPER_LANTERNS.getAll().get(1)));
    public static final Block ORANGE_COPPER_LANTERN = registerBlock("orange_copper_lantern", OrangeCopperLantern::new, Block.Settings.copy(Blocks.COPPER_LANTERNS.getAll().get(1)));
    public static final Block LIME_COPPER_LANTERN = registerBlock("lime_copper_lantern", LimeCopperLantern::new, Block.Settings.copy(Blocks.COPPER_LANTERNS.getAll().get(1)));
    public static final Block CYAN_COPPER_LANTERN = registerBlock("cyan_copper_lantern", CyanCopperLantern::new, Block.Settings.copy(Blocks.COPPER_LANTERNS.getAll().get(1)));
    public static final Block BLUE_COPPER_LANTERN = registerBlock("blue_copper_lantern", BlueCopperLantern::new, Block.Settings.copy(Blocks.COPPER_LANTERNS.getAll().get(1)));
    public static final Block LIGHT_BLUE_COPPER_LANTERN = registerBlock("light_blue_copper_lantern", LightBlueCopperLantern::new, Block.Settings.copy(Blocks.COPPER_LANTERNS.getAll().get(1)));
    public static final Block PURPLE_COPPER_LANTERN = registerBlock("purple_copper_lantern", PurpleCopperLantern::new, Block.Settings.copy(Blocks.COPPER_LANTERNS.getAll().get(1)));
    public static final Block MAGENTA_COPPER_LANTERN = registerBlock("magenta_copper_lantern", MagentaCopperLantern::new, Block.Settings.copy(Blocks.COPPER_LANTERNS.getAll().get(1)));
    public static final Block PINK_COPPER_LANTERN = registerBlock("pink_copper_lantern", PinkCopperLantern::new, Block.Settings.copy(Blocks.COPPER_LANTERNS.getAll().get(1)));
    public static final Block BROWN_COPPER_LANTERN = registerBlock("brown_copper_lantern", BrownCopperLantern::new, Block.Settings.copy(Blocks.COPPER_LANTERNS.getAll().get(1)));
    public static final Block BLACK_COPPER_LANTERN = registerBlock("black_copper_lantern", BlackCopperLantern::new, Block.Settings.copy(Blocks.COPPER_LANTERNS.getAll().get(1)));
    public static final Block DARK_GRAY_COPPER_LANTERN = registerBlock("dark_gray_copper_lantern", DarkGrayCopperLantern::new, Block.Settings.copy(Blocks.COPPER_LANTERNS.getAll().get(1)));
    public static final Block LIGHT_GRAY_COPPER_LANTERN = registerBlock("light_gray_copper_lantern", LightGrayCopperLantern::new, Block.Settings.copy(Blocks.COPPER_LANTERNS.getAll().get(1)));
    public static final Block WHITE_COPPER_LANTERN = registerBlock("white_copper_lantern", WhiteCopperLantern::new, Block.Settings.copy(Blocks.COPPER_LANTERNS.getAll().get(1)));

    public static final BlockItem RED_COPPER_LANTERN_ITEM = registerBlockItem("red_copper_lantern", settings -> new TexturedPolyBlockItem(RED_COPPER_LANTERN, settings), new Item.Settings());
    public static final BlockItem YELLOW_COPPER_LANTERN_ITEM = registerBlockItem("yellow_copper_lantern", settings -> new TexturedPolyBlockItem(YELLOW_COPPER_LANTERN, settings), new Item.Settings());
    public static final BlockItem GREEN_COPPER_LANTERN_ITEM = registerBlockItem("green_copper_lantern", settings -> new TexturedPolyBlockItem(GREEN_COPPER_LANTERN, settings), new Item.Settings());
    public static final BlockItem ORANGE_COPPER_LANTERN_ITEM = registerBlockItem("orange_copper_lantern", settings -> new TexturedPolyBlockItem(ORANGE_COPPER_LANTERN, settings), new Item.Settings());
    public static final BlockItem LIME_COPPER_LANTERN_ITEM = registerBlockItem("lime_copper_lantern", settings -> new TexturedPolyBlockItem(LIME_COPPER_LANTERN, settings), new Item.Settings());
    public static final BlockItem CYAN_COPPER_LANTERN_ITEM = registerBlockItem("cyan_copper_lantern", settings -> new TexturedPolyBlockItem(CYAN_COPPER_LANTERN, settings), new Item.Settings());
    public static final BlockItem BLUE_COPPER_LANTERN_ITEM = registerBlockItem("blue_copper_lantern", settings -> new TexturedPolyBlockItem(BLUE_COPPER_LANTERN, settings), new Item.Settings());
    public static final BlockItem LIGHT_BLUE_COPPER_LANTERN_ITEM = registerBlockItem("light_blue_copper_lantern", settings -> new TexturedPolyBlockItem(LIGHT_BLUE_COPPER_LANTERN, settings), new Item.Settings());
    public static final BlockItem PURPLE_COPPER_LANTERN_ITEM = registerBlockItem("purple_copper_lantern", settings -> new TexturedPolyBlockItem(PURPLE_COPPER_LANTERN, settings), new Item.Settings());
    public static final BlockItem MAGENTA_COPPER_LANTERN_ITEM = registerBlockItem("magenta_copper_lantern", settings -> new TexturedPolyBlockItem(MAGENTA_COPPER_LANTERN, settings), new Item.Settings());
    public static final BlockItem PINK_COPPER_LANTERN_ITEM = registerBlockItem("pink_copper_lantern", settings -> new TexturedPolyBlockItem(PINK_COPPER_LANTERN, settings), new Item.Settings());
    public static final BlockItem BROWN_COPPER_LANTERN_ITEM = registerBlockItem("brown_copper_lantern", settings -> new TexturedPolyBlockItem(BROWN_COPPER_LANTERN, settings), new Item.Settings());
    public static final BlockItem BLACK_COPPER_LANTERN_ITEM = registerBlockItem("black_copper_lantern", settings -> new TexturedPolyBlockItem(BLACK_COPPER_LANTERN, settings), new Item.Settings());
    public static final BlockItem DARK_GRAY_COPPER_LANTERN_ITEM = registerBlockItem("dark_gray_copper_lantern", settings -> new TexturedPolyBlockItem(DARK_GRAY_COPPER_LANTERN, settings), new Item.Settings());
    public static final BlockItem LIGHT_GRAY_COPPER_LANTERN_ITEM = registerBlockItem("light_gray_copper_lantern", settings -> new TexturedPolyBlockItem(LIGHT_GRAY_COPPER_LANTERN, settings), new Item.Settings());
    public static final BlockItem WHITE_COPPER_LANTERN_ITEM = registerBlockItem("white_copper_lantern", settings -> new TexturedPolyBlockItem(WHITE_COPPER_LANTERN, settings), new Item.Settings());

    public static void registerBlocks() {
        ItemGroup.Builder builder = PolymerItemGroupUtils.builder();
        builder.icon(() -> new ItemStack(ModBlocks.RED_COPPER_LANTERN_ITEM, 1));
        builder.displayName(Text.literal("Colorful Copper Lanterns"));
        builder.entries((displayContext, entries) -> {
            entries.add(RED_COPPER_LANTERN);
            entries.add(ORANGE_COPPER_LANTERN);
            entries.add(YELLOW_COPPER_LANTERN);
            entries.add(LIME_COPPER_LANTERN);
            entries.add(GREEN_COPPER_LANTERN);
            entries.add(CYAN_COPPER_LANTERN);
            entries.add(LIGHT_BLUE_COPPER_LANTERN);
            entries.add(BLUE_COPPER_LANTERN);
            entries.add(PURPLE_COPPER_LANTERN);
            entries.add(MAGENTA_COPPER_LANTERN);
            entries.add(PINK_COPPER_LANTERN);
            entries.add(BROWN_COPPER_LANTERN);
            entries.add(BLACK_COPPER_LANTERN);
            entries.add(DARK_GRAY_COPPER_LANTERN);
            entries.add(LIGHT_GRAY_COPPER_LANTERN);
            entries.add(WHITE_COPPER_LANTERN);
        });
        ItemGroup polymerGroup = builder.build();
        PolymerItemGroupUtils.registerPolymerItemGroup(Identifier.of(MOD_ID, "blocks"), polymerGroup);
    }

    public static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings){
        var key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ColoredCopperLanterns.MOD_ID, name));
        Block block = factory.apply(settings.registryKey(key));

        return Registry.register(Registries.BLOCK, key, block);
    }

    public static BlockItem registerBlockItem(String name, Function<Item.Settings, BlockItem> factory, Item.Settings settings){
        var key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ColoredCopperLanterns.MOD_ID, name));
        BlockItem item = factory.apply(settings.registryKey(key).useBlockPrefixedTranslationKey());

        return Registry.register(Registries.ITEM, key, item);
    }
}