package github.jcsmecabricks;

import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import eu.pb4.polymer.resourcepack.extras.api.ResourcePackExtras;
import github.jcsmecabricks.block.ModBlocks;
import github.jcsmecabricks.block.lantern.*;
import github.jcsmecabricks.entity.ModEntities;
import github.jcsmecabricks.registry.config.ColorfulCopperLanternsConfig;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Credit to the Colorful CopperLanterns mod for code usage.
public class ColoredCopperLanterns implements ModInitializer {
	public static final String MOD_ID = "colored-copper-lanterns";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModEntities.register();
        ModBlocks.registerBlocks();
		LOGGER.info("Hello Fabric world!");
        ColorfulCopperLanternsConfig.load();

        initModels();
        if (PolymerResourcePackUtils.addModAssets(MOD_ID)) {
            ResourcePackExtras.forDefault().addBridgedModelsFolder(id("block"), id("item"), id("sgui"));
            LOGGER.info("Colorful Copper CopperLanterns 1.21.10-1.0");
        } else {
            LOGGER.error("Failed to add mod assets for " + MOD_ID);
        }
        PolymerResourcePackUtils.markAsRequired();
    }

    public void initModels(){
        RedCopperLantern.Model.HANGING_MODEL.isEmpty();
        RedCopperLantern.Model.STANDING_MODEL.isEmpty();

        YellowCopperLantern.Model.HANGING_MODEL.isEmpty();
        YellowCopperLantern.Model.STANDING_MODEL.isEmpty();

        GreenCopperLantern.Model.HANGING_MODEL.isEmpty();
        GreenCopperLantern.Model.STANDING_MODEL.isEmpty();

        OrangeCopperLantern.Model.HANGING_MODEL.isEmpty();
        OrangeCopperLantern.Model.STANDING_MODEL.isEmpty();

        LimeCopperLantern.Model.HANGING_MODEL.isEmpty();
        LimeCopperLantern.Model.STANDING_MODEL.isEmpty();

        CyanCopperLantern.Model.HANGING_MODEL.isEmpty();
        CyanCopperLantern.Model.STANDING_MODEL.isEmpty();

        BlueCopperLantern.Model.HANGING_MODEL.isEmpty();
        BlueCopperLantern.Model.STANDING_MODEL.isEmpty();

        LightBlueCopperLantern.Model.HANGING_MODEL.isEmpty();
        LightBlueCopperLantern.Model.STANDING_MODEL.isEmpty();

        PurpleCopperLantern.Model.HANGING_MODEL.isEmpty();
        PurpleCopperLantern.Model.STANDING_MODEL.isEmpty();

        MagentaCopperLantern.Model.HANGING_MODEL.isEmpty();
        MagentaCopperLantern.Model.STANDING_MODEL.isEmpty();

        PinkCopperLantern.Model.HANGING_MODEL.isEmpty();
        PinkCopperLantern.Model.STANDING_MODEL.isEmpty();

        BrownCopperLantern.Model.HANGING_MODEL.isEmpty();
        BrownCopperLantern.Model.STANDING_MODEL.isEmpty();

        BlackCopperLantern.Model.HANGING_MODEL.isEmpty();
        BlackCopperLantern.Model.STANDING_MODEL.isEmpty();

        DarkGrayCopperLantern.Model.HANGING_MODEL.isEmpty();
        DarkGrayCopperLantern.Model.STANDING_MODEL.isEmpty();

        LightGrayCopperLantern.Model.HANGING_MODEL.isEmpty();
        LightGrayCopperLantern.Model.STANDING_MODEL.isEmpty();

        WhiteCopperLantern.Model.HANGING_MODEL.isEmpty();
        WhiteCopperLantern.Model.STANDING_MODEL.isEmpty();
    }

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}