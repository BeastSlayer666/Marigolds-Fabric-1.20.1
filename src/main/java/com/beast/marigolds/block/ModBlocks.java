package com.beast.marigolds.block;

import com.beast.marigolds.Marigolds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;

public class ModBlocks {
    public static final Block MARIGOLD = registerBlock("marigold",
            new FlowerBlock(StatusEffects.GLOWING, 10,
                    FabricBlockSettings.copyOf(Blocks.CORNFLOWER).nonOpaque().noCollision()));
    public static final Block POTTED_MARIGOLD = Registry.register(Registries.BLOCK, new Identifier(Marigolds.MOD_ID, "potted_marigold"),
            new FlowerPotBlock(MARIGOLD, FabricBlockSettings.copyOf(Blocks.POTTED_CORNFLOWER).nonOpaque()));

    public static void addItemToNatureTab(FabricItemGroupEntries entries) {
        entries.add(MARIGOLD);
    }

    public static void registerBlockProperties() {
        CompostingChanceRegistry.INSTANCE.add(MARIGOLD, 0.65F);

        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();
        instance.add(ModBlocks.MARIGOLD, 100, 60);
    }

    public static void registerVillagerTrades(){
        TradeOfferHelper.registerWanderingTraderOffers(1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(ModBlocks.MARIGOLD.asItem(), 1),
                            12, 0, 0)));
                });
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Marigolds.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(Marigolds.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        Marigolds.LOGGER.info("Registering ModBlocks for " + Marigolds.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModBlocks::addItemToNatureTab);
    }
}
