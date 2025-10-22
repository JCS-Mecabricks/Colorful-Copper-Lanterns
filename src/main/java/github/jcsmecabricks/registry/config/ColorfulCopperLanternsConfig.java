package github.jcsmecabricks.registry.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ColorfulCopperLanternsConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File CONFIG_FILE = new File("config/colored_copper_lanterns_config.json");

    public boolean PolyDecorationsLanterns = true;

    private static ColorfulCopperLanternsConfig INSTANCE;

    public static ColorfulCopperLanternsConfig get() {
        if (INSTANCE == null) {
            load();
        }
        return INSTANCE;
    }

    public static void load() {
        try {
            if (!CONFIG_FILE.exists()) {
                ColorfulCopperLanternsConfig def = new ColorfulCopperLanternsConfig();
                save(def);
                INSTANCE = def;
            } else {
                try (FileReader reader = new FileReader(CONFIG_FILE)) {
                    INSTANCE = GSON.fromJson(reader, ColorfulCopperLanternsConfig.class);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            INSTANCE = new ColorfulCopperLanternsConfig();
        }
    }

    public static void save(ColorfulCopperLanternsConfig config) {
        try {
            CONFIG_FILE.getParentFile().mkdirs();
            try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
                GSON.toJson(config, writer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
