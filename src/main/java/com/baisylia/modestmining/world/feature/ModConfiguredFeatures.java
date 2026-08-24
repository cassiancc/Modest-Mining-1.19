package com.baisylia.modestmining.world.feature;

import com.baisylia.modestmining.ModestMining;
import com.baisylia.modestmining.block.ModBlocks;
import com.google.common.base.Suppliers;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    static final RuleTest STONE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    static final RuleTest DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    static final RuleTest NETHERRACK = new BlockMatchTest(Blocks.NETHERRACK);

    public static final ResourceKey<ConfiguredFeature<?, ?>> SHELL = register("shell");

    public static final ResourceKey<ConfiguredFeature<?, ?>> CLAM = register("clam");

    public static final ResourceKey<ConfiguredFeature<?, ?>> METEORITE = register("meteorite");

    public static final Supplier<List<OreConfiguration.TargetBlockState>> ALUMINIUM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocks.ALUMINIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ALUMINIUM_ORE.get().defaultBlockState())));

    public static final ResourceKey<ConfiguredFeature<?, ?>> ALUMINIUM_ORE = register("aluminium_ore");

    public static final Supplier<List<OreConfiguration.TargetBlockState>> LEAD_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocks.LEAD_ORE.get().defaultBlockState()),
            OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_LEAD_ORE.get().defaultBlockState())));

    public static final ResourceKey<ConfiguredFeature<?, ?>> LEAD_ORE = register("lead_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_LEAD_ORE = register("nether_lead_ore");

    public static final Supplier<List<OreConfiguration.TargetBlockState>> SILVER_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocks.SILVER_ORE.get().defaultBlockState()),
            OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState())));

    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_ORE = register("silver_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_ORE_EXTRA = register("silver_ore_extra");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        context.register(SHELL, new ConfiguredFeature<>(Feature.FLOWER,
                new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SHELL.get()))))));
        context.register(CLAM, new ConfiguredFeature<>(ModFeatures.CLAM_FEATURE.get(), FeatureConfiguration.NONE));
        context.register(METEORITE, new ConfiguredFeature<>(ModFeatures.METEORITE_FEATURE.get(), FeatureConfiguration.NONE));
        context.register(ALUMINIUM_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ALUMINIUM_ORES.get(), 9)));
        context.register(LEAD_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(LEAD_ORES.get(), 8)));
        context.register(NETHER_LEAD_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHERRACK,
                ModBlocks.NETHER_LEAD_ORE.get().defaultBlockState(), 10)));
        context.register(SILVER_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SILVER_ORES.get(), 9, 0.5F)));
        context.register(SILVER_ORE_EXTRA,  new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SILVER_ORES.get(), 9, 0.0F)));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> register(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ModestMining.MOD_ID, name));
    }
}
