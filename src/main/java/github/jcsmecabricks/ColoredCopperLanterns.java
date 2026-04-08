package github.jcsmecabricks;

import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import eu.pb4.polymer.resourcepack.extras.api.ResourcePackExtras;
import github.jcsmecabricks.block.ModBlocks;
import github.jcsmecabricks.block.lantern.*;
import github.jcsmecabricks.entity.ModEntities;
import github.jcsmecabricks.registry.config.ColorfulCopperLanternsConfig;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
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

        if (PolymerResourcePackUtils.addModAssets(MOD_ID)) {
            ResourcePackExtras.forDefault().addBridgedModelsFolder(id("block"), id("item"), id("sgui"));
            LOGGER.info("Colorful Copper CopperLanterns 1.21.10-1.0");
        } else {
            LOGGER.error("Failed to add mod assets for " + MOD_ID);
        }
        PolymerResourcePackUtils.markAsRequired();
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}