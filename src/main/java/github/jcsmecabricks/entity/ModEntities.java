package github.jcsmecabricks.entity;

import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import github.jcsmecabricks.ColoredCopperLanterns;
import github.jcsmecabricks.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final BlockEntityType<RedCopperLanternBlockEntity> RED_COPPER_LANTERN = register("red_copper_lantern", FabricBlockEntityTypeBuilder.create(RedCopperLanternBlockEntity::new, ModBlocks.RED_COPPER_LANTERN));
    public static final BlockEntityType<YellowCopperLanternBlockEntity> YELLOW_COPPER_LANTERN = register("yellow_copper_lantern", FabricBlockEntityTypeBuilder.create(YellowCopperLanternBlockEntity::new, ModBlocks.YELLOW_COPPER_LANTERN));
    public static final BlockEntityType<GreenCopperLanternBlockEntity> GREEN_COPPER_LANTERN = register("green_copper_lantern", FabricBlockEntityTypeBuilder.create(GreenCopperLanternBlockEntity::new, ModBlocks.GREEN_COPPER_LANTERN));
    public static final BlockEntityType<OrangeCopperLanternBlockEntity> ORANGE_COPPER_LANTERN = register("orange_copper_lantern", FabricBlockEntityTypeBuilder.create(OrangeCopperLanternBlockEntity::new, ModBlocks.ORANGE_COPPER_LANTERN));
    public static final BlockEntityType<LimeCopperLanternBlockEntity> LIME_COPPER_LANTERN = register("lime_copper_lantern", FabricBlockEntityTypeBuilder.create(LimeCopperLanternBlockEntity::new, ModBlocks.LIME_COPPER_LANTERN));
    public static final BlockEntityType<CyanCopperLanternBlockEntity> CYAN_COPPER_LANTERN = register("cyan_copper_lantern", FabricBlockEntityTypeBuilder.create(CyanCopperLanternBlockEntity::new, ModBlocks.CYAN_COPPER_LANTERN));
    public static final BlockEntityType<BlueCopperLanternBlockEntity> BLUE_COPPER_LANTERN = register("blue_copper_lantern", FabricBlockEntityTypeBuilder.create(BlueCopperLanternBlockEntity::new, ModBlocks.BLUE_COPPER_LANTERN));
    public static final BlockEntityType<LightBlueCopperLanternBlockEntity> LIGHT_BLUE_COPPER_LANTERN = register("light_blue_copper_lantern", FabricBlockEntityTypeBuilder.create(LightBlueCopperLanternBlockEntity::new, ModBlocks.LIGHT_BLUE_COPPER_LANTERN));
    public static final BlockEntityType<PurpleCopperLanternBlockEntity> PURPLE_COPPER_LANTERN = register("purple_copper_lantern", FabricBlockEntityTypeBuilder.create(PurpleCopperLanternBlockEntity::new, ModBlocks.PURPLE_COPPER_LANTERN));
    public static final BlockEntityType<MagentaCopperLanternBlockEntity> MAGENTA_COPPER_LANTERN = register("magenta_copper_lantern", FabricBlockEntityTypeBuilder.create(MagentaCopperLanternBlockEntity::new, ModBlocks.MAGENTA_COPPER_LANTERN));
    public static final BlockEntityType<PinkCopperLanternBlockEntity> PINK_COPPER_LANTERN = register("pink_copper_lantern", FabricBlockEntityTypeBuilder.create(PinkCopperLanternBlockEntity::new, ModBlocks.PINK_COPPER_LANTERN));
    public static final BlockEntityType<BrownCopperLanternBlockEntity> BROWN_COPPER_LANTERN = register("brown_copper_lantern", FabricBlockEntityTypeBuilder.create(BrownCopperLanternBlockEntity::new, ModBlocks.BROWN_COPPER_LANTERN));
    public static final BlockEntityType<BlackCopperLanternBlockEntity> BLACK_COPPER_LANTERN = register("black_copper_lantern", FabricBlockEntityTypeBuilder.create(BlackCopperLanternBlockEntity::new, ModBlocks.BLACK_COPPER_LANTERN));
    public static final BlockEntityType<DarkGrayCopperLanternBlockEntity> DARK_GRAY_COPPER_LANTERN = register("dark_gray_copper_lantern", FabricBlockEntityTypeBuilder.create(DarkGrayCopperLanternBlockEntity::new, ModBlocks.DARK_GRAY_COPPER_LANTERN));
    public static final BlockEntityType<LightGrayCopperLanternBlockEntity> LIGHT_GRAY_COPPER_LANTERN = register("light_gray_copper_lantern", FabricBlockEntityTypeBuilder.create(LightGrayCopperLanternBlockEntity::new, ModBlocks.LIGHT_GRAY_COPPER_LANTERN));
    public static final BlockEntityType<WhiteCopperLanternBlockEntity> WHITE_COPPER_LANTERN = register("white_copper_lantern", FabricBlockEntityTypeBuilder.create(WhiteCopperLanternBlockEntity::new, ModBlocks.WHITE_COPPER_LANTERN));
    public static void register() {}

    public static <T extends BlockEntity> BlockEntityType<T> register(String path, FabricBlockEntityTypeBuilder<T> factory) {
        BlockEntityType<T> blockEntityType = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(ColoredCopperLanterns.MOD_ID, path), factory.build());
        PolymerBlockUtils.registerBlockEntity(blockEntityType);

        return blockEntityType;
    }
}