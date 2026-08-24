package com.baisylia.modestmining.world.feature;

import com.baisylia.modestmining.ModestMining;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> SHELL_PLACED = register("shell_placed");

    public static final ResourceKey<PlacedFeature> CLAM_PLACED = register("clam_placed");

    public static final ResourceKey<PlacedFeature> METEORITE_PLACED = register("meteorite_placed");

    public static final ResourceKey<PlacedFeature> ALUMINIUM_ORE_PLACED = register("aluminium_ore_placed");

    public static final ResourceKey<PlacedFeature> LEAD_ORE_PLACED = register("lead_ore_placed");

    public static final ResourceKey<PlacedFeature> NETHER_LEAD_ORE_PLACED = register("nether_lead_ore_placed");

    public static final ResourceKey<PlacedFeature> SILVER_ORE_PLACED = register("silver_ore_placed");

    public static final ResourceKey<PlacedFeature> SILVER_ORE_EXTRA_PLACED = register("silver_ore_extra_placed");

    public static List<PlacementModifier> orePlacement(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, InSquarePlacement.spread(), heightModifier, BiomeFilter.biome());
    }

    public static List<PlacementModifier> orePlacement(PlacementModifier countModifier, PlacementModifier heightModifier, String configKey) {
        return List.of(ConfigPlacementFilter.of(configKey), countModifier, InSquarePlacement.spread(), heightModifier, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int veinsPerChunk, PlacementModifier heightModifier) {
        return orePlacement(CountPlacement.of(veinsPerChunk), heightModifier);
    }

    public static List<PlacementModifier> commonOrePlacement(int veinsPerChunk, PlacementModifier heightModifier, String configKey) {
        return orePlacement(CountPlacement.of(veinsPerChunk), heightModifier, configKey);
    }

    public static List<PlacementModifier> rareOrePlacement(int rarity, PlacementModifier heightModifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(rarity), heightModifier);
    }

    public static List<PlacementModifier> rareOrePlacement(int rarity, PlacementModifier heightModifier, String configKey) {
        return orePlacement(RarityFilter.onAverageOnceEvery(rarity), heightModifier, configKey);
    }

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> placed = context.lookup(Registries.CONFIGURED_FEATURE);
        context.register(SHELL_PLACED, new PlacedFeature(placed.getOrThrow(ModConfiguredFeatures.SHELL), List.of(RarityFilter.onAverageOnceEvery(25),
                InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
        context.register(CLAM_PLACED, new PlacedFeature(placed.getOrThrow(ModConfiguredFeatures.CLAM), List.of(
                ConfigPlacementFilter.of("generate_clams"),
                RarityFilter.onAverageOnceEvery(5),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                BiomeFilter.biome())));
        context.register(METEORITE_PLACED, new PlacedFeature(placed.getOrThrow(ModConfiguredFeatures.METEORITE), List.of(
                ConfigPlacementFilter.of("generate_meteorites"),
                RarityFilter.onAverageOnceEvery(280),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                BiomeFilter.biome())));
        context.register(ALUMINIUM_ORE_PLACED, new PlacedFeature(placed.getOrThrow(ModConfiguredFeatures.ALUMINIUM_ORE),
                commonOrePlacement(8,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)),
                        "generate_aluminium_ore")));
        context.register(LEAD_ORE_PLACED, new PlacedFeature(placed.getOrThrow(ModConfiguredFeatures.LEAD_ORE),
                commonOrePlacement(6,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-48), VerticalAnchor.absolute(48)),
                        "generate_lead_ore")));
        context.register(NETHER_LEAD_ORE_PLACED, new PlacedFeature(placed.getOrThrow(ModConfiguredFeatures.NETHER_LEAD_ORE),
                commonOrePlacement(10,
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.belowTop(10)),
                        "generate_nether_lead_ore")));
        context.register(SILVER_ORE_PLACED, new PlacedFeature(placed.getOrThrow(ModConfiguredFeatures.SILVER_ORE),
                commonOrePlacement(3,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)),
                        "generate_silver_ore")));
        context.register(SILVER_ORE_EXTRA_PLACED, new PlacedFeature(placed.getOrThrow(ModConfiguredFeatures.SILVER_ORE_EXTRA),
                commonOrePlacement(20,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(192)),
                        "generate_silver_ore")));
    }

    private static ResourceKey<PlacedFeature> register(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ModestMining.MOD_ID, name));
    }
}