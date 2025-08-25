package com.ncpbails.modestmining.world.feature;

import com.ncpbails.modestmining.ModestMining;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {

    //public static final RegistryObject<PlacedFeature> OCEANIC_REMAINS_PLACED = PLACED_FEATURES.register("oceanic_remains_placed",
    //        () -> new PlacedFeature(ModConfiguredFeatures.OCEANIC_REMAINS.getHolder().get(),
    //                commonOrePlacement(7, // VeinsPerChunk
    //                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final PlacedFeature SHELL_PLACED = new PlacedFeature(Holder.direct(ModConfiguredFeatures.SHELL), List.of(RarityFilter.onAverageOnceEvery(25),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    //public static final RegistryObject<PlacedFeature> ROCKS_PLACED = PLACED_FEATURES.register("rocks_placed",
    //        () -> new PlacedFeature(ModConfiguredFeatures.ROCKS.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(25),
    //                InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));


    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        context.register(registerKey("shell_placed"), SHELL_PLACED);
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ModestMining.MOD_ID, name));
    }
}
