package com.baisylia.modestmining.block;

import com.baisylia.modestmining.ModestMining;
import com.baisylia.modestmining.block.custom.ChiselableBlock;
import com.baisylia.modestmining.block.custom.ForgeBlock;
import com.baisylia.modestmining.block.entity.custom.ShellBlock;
import com.baisylia.modestmining.item.ModItems;
import com.baisylia.modestmining.sounds.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModestMining.MOD_ID);
    public static ArrayList<RegistryObject<? extends Block>> BUILDING_BLOCKS = new ArrayList<>();
    public static ArrayList<RegistryObject<? extends Block>> FUNCTIONAL = new ArrayList<>();
    public static ArrayList<RegistryObject<? extends Block>> NATURAL = new ArrayList<>();

    //BLOCKS
    public static final RegistryObject<Block> COKE_BLOCK = registerBlock("coke_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK)), CreativeModeTabs.BUILDING_BLOCKS, true, 64000);

    //public static final RegistryObject<Block> COAL_POWDER_BLOCK = registerBlock("coal_powder_block",
    //        () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.SAND)), CreativeModeTabs.BUILDING_BLOCKS, true, 24000);

    //public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
    //        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);

    //public static final RegistryObject<Block> ROSEGOLD_BLOCK = registerBlock("rosegold_block",
    //        () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> PRISMARITE_BLOCK = registerBlock("prismarite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);


    public static final RegistryObject<Block> FORGE = registerBlock("forge",
            () -> new ForgeBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).lightLevel((blockState)->{
                if (blockState.getValue(ForgeBlock.LIT)) {
                    return 15;
                }
                return 0;
            })
            .strength(5.0f, 6.0f).requiresCorrectToolForDrops()), CreativeModeTabs.FUNCTIONAL_BLOCKS, false, 0);

    public static final RegistryObject<Block> COMPACT_AMETHYST_BLOCK = registerBlock("compact_amethyst_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);

    //public static final RegistryObject<Block> OCEANIC_REMAINS = registerBlock("oceanic_remains",
    //        () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> DIAMOND_SHARD_BLOCK = registerBlock("diamond_shard_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).sound(SoundType.METAL)), CreativeModeTabs.BUILDING_BLOCKS, false, 0);


    public static final RegistryObject<Block> SUSPICIOUS_DIRT = registerBlock("suspicious_dirt",
            () -> new BrushableBlock(Blocks.DIRT, BlockBehaviour.Properties.copy(Blocks.DIRT).noOcclusion(), SoundEvents.BRUSH_GENERIC, SoundEvents.BRUSH_GENERIC), CreativeModeTabs.BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> SUSPICIOUS_STONE = registerBlock("suspicious_stone",
            () -> new ChiselableBlock(Blocks.STONE, BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion(), ModSounds.CHISEL_GENERIC.get(), ModSounds.CHISEL_GENERIC.get()), CreativeModeTabs.BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> SHELL = registerBlock("shell",
            () -> new ShellBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.COLOR_GRAY)
                    .strength(0.5f, 0.5f)), CreativeModeTabs.NATURAL_BLOCKS, false, 0);


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
        if (tab.equals(CreativeModeTabs.BUILDING_BLOCKS)) {
            BUILDING_BLOCKS.add(block);
        }       else  if (tab.equals(CreativeModeTabs.NATURAL_BLOCKS)) {
            NATURAL.add(block);
        } else  if (tab.equals(CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
            FUNCTIONAL.add(block);
        }
        if(isFuel == false) {
            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                    new Item.Properties()));
        } else {
            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                    new Item.Properties()){
                @Override public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {return fuelAmount;}});
        }
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}