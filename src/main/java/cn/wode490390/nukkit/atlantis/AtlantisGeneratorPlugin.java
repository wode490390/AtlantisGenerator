package cn.wode490390.nukkit.atlantis;

import cn.nukkit.level.generator.Generator;
import cn.nukkit.plugin.PluginBase;
import cn.wode490390.nukkit.atlantis.generator.AtlantisGenerator;
import cn.wode490390.nukkit.atlantis.generator.AtlantisOldGenerator;
import cn.wode490390.nukkit.atlantisgenerator.MetricsLite;

public class AtlantisGeneratorPlugin extends PluginBase {

    private static final String CONFIG_SEA_LEVEL = "sea-level";
    private static final String CONFIG_BIOME = "biome";

    private static AtlantisGeneratorPlugin instance;

    public static AtlantisGeneratorPlugin getInstance() {
        return instance;
    }

    public int seaLevel;
    public boolean biome;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        String t = CONFIG_BIOME;
        try {
            this.biome = this.getConfig().getBoolean(t);
        } catch (Exception e) {
            this.biome = true;
            this.logLoadException(t);
        }
        t = CONFIG_SEA_LEVEL;
        try {
            this.seaLevel = this.getConfig().getInt(t);
        } catch (Exception e) {
            this.seaLevel = 255;
            this.logLoadException(t);
        }
        if (this.seaLevel > 255) {
            this.seaLevel = 255;
        } else if (this.seaLevel < 1) {
            this.seaLevel = 1;
        }
        Generator.addGenerator(AtlantisGenerator.class, "normal", Generator.TYPE_INFINITE);
        Generator.addGenerator(AtlantisGenerator.class, "default", Generator.TYPE_INFINITE);
        Generator.addGenerator(AtlantisOldGenerator.class, "old", Generator.TYPE_OLD);
        new MetricsLite(this);
    }

    private void logLoadException(String node) {
        this.getLogger().alert("An error occurred while reading the configuration '" + node + "'. Use the default value.");
    }
}
