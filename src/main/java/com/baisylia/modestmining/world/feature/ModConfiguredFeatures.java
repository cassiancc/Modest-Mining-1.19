package com.baisylia.modestmining.world.feature;

import com.baisylia.modestmining.ModestMining;
import com.baisylia.modestmining.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModConfiguredFeatures {

    //public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_OCEANIC_REMAINS = Suppliers.memoize(() -> List.of(
            //OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.OCEANIC_REMAINS.get().defaultBlockState()),
            //OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.OCEANIC_REMAINS.get().defaultBlockState())));

    //public static final RegistryObject<ConfiguredFeature<?, ?>> OCEANIC_REMAINS = CONFIGURED_FEATURES.register("oceanic_remains",
    //        () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_OCEANIC_REMAINS.get(),4)));

    public static final ConfiguredFeature<RandomPatchConfiguration, Feature<RandomPatchConfiguration>> SHELL =
            new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SHELL.get())))));
    //public static final RegistryObject<ConfiguredFeature<?, ?>> ROCKS = CONFIGURED_FEATURES.register("rocks",
    //        () -> new ConfiguredFeature<>(Feature.FLOWER,
    //                new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
    //                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SHELL.get()))))));

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        context.register(registerKey("shell"), SHELL);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ModestMining.MOD_ID, name));
    }
}
