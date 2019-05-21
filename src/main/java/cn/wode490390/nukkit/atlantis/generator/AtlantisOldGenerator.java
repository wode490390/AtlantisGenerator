package cn.wode490390.nukkit.atlantis.generator;

import cn.nukkit.level.biome.EnumBiome;
import cn.nukkit.level.format.generic.BaseFullChunk;
import java.util.Map;

public class AtlantisOldGenerator extends AtlantisGenerator {

    public AtlantisOldGenerator() {
        super();
    }

    public AtlantisOldGenerator(Map<String, Object> options) {
        super();
    }

    @Override
    public int getId() {
        return TYPE_OLD;
    }

    @Override
    public String getName() {
        return "atlantis_old";
    }

    @Override
    public void generateChunk(int chunkX, int chunkZ) {
        if (this.validChunk(chunkX, chunkZ)) {
            super.generateChunk(chunkX, chunkZ);
        } else {
            BaseFullChunk chunk = this.level.getChunk(chunkX, chunkZ);
            for (int x = 0; x < 16; ++x) {
                for (int z = 0; z < 16; ++z) {
                    for (int y = 0; y < 256; ++y) {
                        chunk.setBlock(x, y, z, INVISIBLE_BEDROCK);
                    }
                    chunk.setBiome(x, z, EnumBiome.OCEAN.biome);
                }
            }
        }
    }

    @Override
    public void populateChunk(int chunkX, int chunkZ) {
        if (this.validChunk(chunkX, chunkZ)) {
            super.populateChunk(chunkX, chunkZ);
        }
    }

    private boolean validChunk(int chunkX, int chunkZ) {
        return chunkX >= 0 && chunkX < 0xf && chunkZ >= 0 && chunkZ < 0xf;
    }
}
