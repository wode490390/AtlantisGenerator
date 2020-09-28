package cn.wode490390.nukkit.atlantisgen;

import cn.nukkit.level.generator.Generator;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.wode490390.nukkit.atlantisgen.generator.AtlantisGenerator;
import cn.wode490390.nukkit.atlantisgen.generator.AtlantisOldGenerator;
import cn.wode490390.nukkit.atlantisgen.util.MetricsLite;

public class AtlantisGeneratorPlugin extends PluginBase {

    private static AtlantisGeneratorPlugin instance;

    public int seaLevel = 128;
    public boolean biome = true;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        try {
            new MetricsLite(this, 4840);
        } catch (Throwable ignore) {

        }
        this.saveDefaultConfig();
        Config config = this.getConfig();

        String key = "biome";
        try {
            this.biome = config.getBoolean(key, this.biome);
        } catch (Exception e) {
            this.logLoadException(key, e);
        }

        key = "sea-level";
        try {
            this.seaLevel = config.getInt(key, this.seaLevel);
        } catch (Exception e) {
            this.logLoadException(key, e);
        }
        if (this.seaLevel > 255) {
            this.seaLevel = 255;
        } else if (this.seaLevel < 1) {
            this.seaLevel = 1;
        }

        boolean old = true;
        key = "old";
        try {
            old = config.getBoolean(key, old);
        } catch (Exception e) {
            this.logLoadException(key, e);
        }

        Generator.addGenerator(AtlantisGenerator.class, "normal", Generator.TYPE_INFINITE);
        Generator.addGenerator(AtlantisGenerator.class, "default", Generator.TYPE_INFINITE);
        if (old) {
            Generator.addGenerator(AtlantisOldGenerator.class, "old", Generator.TYPE_OLD);
        }
    }

    private void logLoadException(String key, Throwable t) {
        this.getLogger().alert("An error occurred while reading the configuration '" + key + "'. Use the default value.");
    }

    public static AtlantisGeneratorPlugin getInstance() {
        return instance;
    }
}
