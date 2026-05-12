package com.baisylia.modestmining;

import com.baisylia.modestmining.block.client.ChiselableBlockEntityRenderer;
import com.baisylia.modestmining.recipe.ModRecipeCategories;
import com.mojang.logging.LogUtils;
import com.baisylia.modestmining.block.ModBlocks;
import com.baisylia.modestmining.block.entity.ModBlockEntities;
import com.baisylia.modestmining.effect.ModEffects;
import com.baisylia.modestmining.entity.ModEntityTypes;
import com.baisylia.modestmining.entity.client.ClamRenderer;
import com.baisylia.modestmining.item.ModItems;
import com.baisylia.modestmining.recipe.ModRecipes;
import com.baisylia.modestmining.screen.ForgeScreen;
import com.baisylia.modestmining.screen.ModMenuTypes;
import com.baisylia.modestmining.sounds.ModSounds;
import com.baisylia.modestmining.world.feature.ModConfiguredFeatures;
import com.baisylia.modestmining.world.feature.ModPlacedFeatures;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.loading.DatagenModLoader;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forgespi.locating.IModFile;
import net.minecraftforge.resource.PathPackResources;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

import java.io.IOException;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ModestMining.MOD_ID)
public class ModestMining
{
    public static final String MOD_ID = "modestmining";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final RecipeBookType FORGING_RECIPE_BOOK_TYPE = RecipeBookType.create("FORGING");

    public ModestMining()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::addPackFinders);
        eventBus.addListener(this::creativeTabSetup);

        ModEffects.register(eventBus);
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModMenuTypes.register(eventBus);
        ModRecipes.register(eventBus);
        ModEntityTypes.register(eventBus);
        GeckoLib.initialize();
        ModSounds.SOUND_EVENTS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        SpawnPlacements.register(ModEntityTypes.CLAM.get(),
                SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR,
                WaterAnimal::checkMobSpawnRules);
    }

    private void creativeTabSetup(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(CreativeModeTabs.INGREDIENTS)) {
            event.accept(ModItems.COKE);
            event.accept(ModItems.COAL_CHUNK);
            event.accept(ModItems.CHARCOAL_CHUNK);
            event.accept(ModItems.COKE_CHUNK);
            event.accept(ModItems.COPPER_NUGGET);
            event.accept(ModItems.DIAMOND_SHARD);
            event.accept(ModItems.PRISMARITE_NUGGET);
            event.accept(ModItems.COPPER_SCREW);
//            event.accept(ModItems.SHELL);
            event.accept(ModItems.PEARL);
            event.accept(ModItems.FLESH);
            event.accept(ModItems.AMETHYST);
            event.accept(ModItems.COPPER_DUST);
            event.accept(ModItems.GOLD_DUST);
            event.accept(ModItems.IRON_DUST);
            event.accept(ModItems.DEBRIS_DUST);

        }
        else if (event.getTabKey().equals(CreativeModeTabs.SPAWN_EGGS)) {
            event.accept(ModItems.CLAM_SPAWN_EGG);
        }
        else if (event.getTabKey().equals(CreativeModeTabs.TOOLS_AND_UTILITIES)) {
            event.accept(ModItems.CHISEL);
            event.accept(ModItems.PRISMARITE_SWORD);
            event.accept(ModItems.PRISMARITE_AXE);
            event.accept(ModItems.PRISMARITE_PICKAXE);
            event.accept(ModItems.PRISMARITE_SHOVEL);
            event.accept(ModItems.PRISMARITE_HOE);
            event.accept(ModItems.PRISMARITE_HELMET);
            event.accept(ModItems.PRISMARITE_CHESTPLATE);
            event.accept(ModItems.PRISMARITE_LEGGINGS);
            event.accept(ModItems.PRISMARITE_BOOTS);
            event.accept(ModItems.WOODEN_HAMMER);
            event.accept(ModItems.STONE_HAMMER);
            event.accept(ModItems.IRON_HAMMER);
//            event.accept(ModItems.STEEL_HAMMER);
            event.accept(ModItems.GOLDEN_HAMMER);

        }
        else if (event.getTabKey().equals(CreativeModeTabs.COMBAT)) {
            event.accept(ModItems.PRISMARITE_SWORD);
            event.accept(ModItems.PRISMARITE_HELMET);
            event.accept(ModItems.PRISMARITE_CHESTPLATE);
            event.accept(ModItems.PRISMARITE_LEGGINGS);
            event.accept(ModItems.PRISMARITE_BOOTS);
            event.accept(ModItems.WOODEN_GLAIVE);
            event.accept(ModItems.STONE_GLAIVE);
            event.accept(ModItems.IRON_GLAIVE);
            event.accept(ModItems.GOLDEN_GLAIVE);
            event.accept(ModItems.DIAMOND_GLAIVE);
            event.accept(ModItems.NETHERITE_GLAIVE);
            event.accept(ModItems.PRISMARITE_GLAIVE);
            event.accept(ModItems.WOODEN_KATANA);
            event.accept(ModItems.STONE_KATANA);
            event.accept(ModItems.GOLDEN_KATANA);
            event.accept(ModItems.IRON_KATANA);
            event.accept(ModItems.DIAMOND_KATANA);
            event.accept(ModItems.NETHERITE_KATANA);
            event.accept(ModItems.PRISMARITE_KATANA);
            event.accept(ModItems.WOODEN_MACE);
            event.accept(ModItems.STONE_MACE);
            event.accept(ModItems.GOLDEN_MACE);
            event.accept(ModItems.IRON_MACE);
            event.accept(ModItems.DIAMOND_MACE);
            event.accept(ModItems.NETHERITE_MACE);
            event.accept(ModItems.PRISMARITE_MACE);
        } else if (event.getTabKey().equals(CreativeModeTabs.NATURAL_BLOCKS)) {
            ModBlocks.NATURAL.forEach((block)->event.accept(block.get()));
        } else if (event.getTabKey().equals(CreativeModeTabs.BUILDING_BLOCKS)) {
            ModBlocks.BUILDING_BLOCKS.forEach((block)->event.accept(block.get()));
        }  else if (event.getTabKey().equals(CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
            ModBlocks.FUNCTIONAL.forEach((block)->event.accept(block.get()));
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    public void addPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            registerBuiltinResourcePack(event, Component.literal("Modest Mining Materials"), "modestmining_materials");
        }
    }

    private static void registerBuiltinResourcePack(AddPackFindersEvent event, MutableComponent name, String folder) {
        event.addRepositorySource((consumer) -> {
            ResourceLocation res = new ResourceLocation(ModestMining.MOD_ID, folder);
            IModFile file = ModList.get().getModFileById(ModestMining.MOD_ID).getFile();
            try (PathPackResources pack = new PathPackResources(
                    res.toString(),
                    true,
                    file.findResource("resourcepacks/" + folder))) {
                consumer.accept(Pack.create(
                        res.toString(),
                        name,
                        false,
                        (p)-> pack,
                        new Pack.Info(Component.literal("Updated textures for the vanilla metals and tools"), 9, FeatureFlagSet.of()),
                        PackType.CLIENT_RESOURCES,
                        Pack.Position.TOP,
                        false,
                        PackSource.BUILT_IN
                        ));

            }
        });
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
		@SubscribeEvent
		public static void onRegisterRecipeBookCategories(RegisterRecipeBookCategoriesEvent event) {
			ModRecipeCategories.init(event);
		}

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            MenuScreens.register(ModMenuTypes.FORGE_MENU.get(), ForgeScreen::new);
        }

        @SubscribeEvent
        public static void onEntityRenderers(EntityRenderersEvent.RegisterRenderers event)
        {
            event.registerEntityRenderer(ModEntityTypes.CLAM.get(), ClamRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.CHISELABLE_BLOCK_ENTITY.get(), ChiselableBlockEntityRenderer::new);
        }
    }
}
