package com.beast.marigolds;

import com.beast.marigolds.block.ModBlocks;
import com.beast.marigolds.world.gen.ModFlowerGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Marigolds implements ModInitializer {
	public static final String MOD_ID = "marigolds";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModBlocks.registerBlockProperties();
		ModBlocks.registerVillagerTrades();

		ModFlowerGeneration.generateFlowers();
	}
}