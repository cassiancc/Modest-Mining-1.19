package com.baisylia.modestmining.block;

import com.baisylia.modestmining.ModestMining;
import com.baisylia.modestmining.block.custom.ClamBlock;
import com.baisylia.modestmining.block.custom.ForgeBlock;
import com.baisylia.modestmining.block.custom.MillstoneBlock;
import com.baisylia.modestmining.block.entity.custom.ShellBlock;
import com.baisylia.modestmining.item.ModItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModestMining.MOD_ID);
    public static ArrayList<RegistryObject<? extends ItemLike>> BUILDING_BLOCKS = new ArrayList<>();
    public static ArrayList<RegistryObject<? extends ItemLike>> FUNCTIONAL = new ArrayList<>();
    public static ArrayList<RegistryObject<? extends ItemLike>> NATURAL = new ArrayList<>();

    // BLOCKS
    public static final RegistryObject<Block> COKE_BLOCK = registerBlock("coke_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK)), CreativeModeTabs.BUILDING_BLOCKS, true, 64000);

    public static final RegistryObject<Block> ALUMINIUM_BLOCK = registerBlock("aluminium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);
    public static final RegistryObject<Block> RAW_ALUMINIUM_BLOCK = registerBlock("raw_aluminium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);
    public static final RegistryObject<Block> ALUMINIUM_ORE = registerBlock("aluminium_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);
    public static final RegistryObject<Block> DEEPSLATE_ALUMINIUM_ORE = registerBlock("deepslate_aluminium_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_COPPER_ORE)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);
    public static final RegistryObject<Block> LEAD_BLOCK = registerBlock("lead_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);
    public static final RegistryObject<Block> RAW_LEAD_BLOCK = registerBlock("raw_lead_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);
    public static final RegistryObject<Block> LEAD_ORE = registerBlock("lead_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);
    public static final RegistryObject<Block> DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_COPPER_ORE)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);
    public static final RegistryObject<Block> NETHER_LEAD_ORE = registerBlock("nether_lead_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);
    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);
    public static final RegistryObject<Block> RAW_SILVER_BLOCK = registerBlock("raw_silver_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);
    public static final RegistryObject<Block> SILVER_ORE = registerBlock("silver_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);
    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_GOLD_ORE)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);
    public static final RegistryObject<Block> ROSEGOLD_BLOCK = registerBlock("rosegold_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);
    public static final RegistryObject<Block> BRONZE_BLOCK = registerBlock("bronze_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);
    public static final RegistryObject<Block> ELECTRUM_BLOCK = registerBlock("electrum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> PRISMARITE_BLOCK = registerBlock("prismarite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);
    public static final RegistryObject<Block> VALKYRIUM_BLOCK = registerBlock("valkyrium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);
    public static final RegistryObject<Block> METEORITE = registerBlock("meteorite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> FORGE = registerBlock("forge",
            () -> new ForgeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).lightLevel((blockState) -> {
                        if (blockState.getValue(ForgeBlock.LIT)) {
                            return 15;
                        }
                        return 0;
                    })
                    .strength(5.0f, 6.0f).requiresCorrectToolForDrops()), CreativeModeTabs.FUNCTIONAL_BLOCKS, false, 0);


    public static final RegistryObject<Block> MILLSTONE = registerBlock("millstone",
            () -> new MillstoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY)
                    .strength(5.0f, 6.0f).requiresCorrectToolForDrops()), CreativeModeTabs.FUNCTIONAL_BLOCKS, false, 0);

    public static final RegistryObject<Block> COMPACT_AMETHYST_BLOCK = registerBlock("compact_amethyst_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> DIAMOND_SHARD_BLOCK = registerBlock("diamond_shard_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).sound(SoundType.METAL)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> SHELL = registerBlock("shell",
            () -> new ShellBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.COLOR_GRAY)
                    .strength(0.5f, 0.5f)), CreativeModeTabs.NATURAL_BLOCKS, false, 0);

    public static final RegistryObject<Block> CLAM = registerBlock("clam",
            () -> new ClamBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY)
                    .strength(0.8f, 0.8f).sound(SoundType.CORAL_BLOCK).noOcclusion()), CreativeModeTabs.NATURAL_BLOCKS, false, 0);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, ResourceKey<CreativeModeTab> tab, Boolean isFuel, Integer fuelAmount) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, isFuel, fuelAmount);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockNoItem(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, ResourceKey<CreativeModeTab> tab, Boolean isFuel, Integer fuelAmount) {
//        if (tab.equals(CreativeModeTabs.BUILDING_BLOCKS)) {
//            BUILDING_BLOCKS.add(block);
//        }       else  if (tab.equals(CreativeModeTabs.NATURAL_BLOCKS)) {
//            NATURAL.add(block);
//        } else  if (tab.equals(CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
//            FUNCTIONAL.add(block);
//        }
        if (isFuel == false) {
            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                    new Item.Properties()));
        } else {
            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                    new Item.Properties()) {
                @Override
                public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
                    return fuelAmount;
                }
            });
        }
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}