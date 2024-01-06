package com.beast.marigolds.world.gen;

import com.beast.marigolds.world.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModFlowerGeneration {
    public static void generateFlowers() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS,
                        BiomeKeys.FLOWER_FOREST,
                        BiomeKeys.SUNFLOWER_PLAINS,
                        BiomeKeys.SNOWY_PLAINS,
                        BiomeKeys.MEADOW,
                        BiomeKeys.FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MARIGOLD_PLACED_KEY);
    }

}
