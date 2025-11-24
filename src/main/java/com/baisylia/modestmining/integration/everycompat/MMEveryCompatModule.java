package com.baisylia.modestmining.integration.everycompat;

import net.mehvahdjukaar.every_compat.EveryCompat;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.moonlight.api.set.BlockType;
import net.mehvahdjukaar.moonlight.api.set.wood.VanillaWoodTypes;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodTypeRegistry;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

public class MMEveryCompatModule extends SimpleModule {
    public final SimpleEntrySet<WoodType, Block>
            pillar,
            boards, boardSlab, boardStairs, boardWall,
            tiles, tileSlab, tileStairs, tileWall,
            carved, carvedSlab, carvedStairs, carvedWall,
    chiseled_planks;
    public MMEveryCompatModule(String modId) {
        super(modId, "mm", EveryCompat.MOD_ID);

        // pillar
        pillar = SimpleEntrySet.builder(WoodType.class, "pillar",
                getModBlock("oak_pillar"), () -> VanillaWoodTypes.OAK,
                w -> new RotatedPillarBlock(Utils.copyPropertySafe(w.log)){
                    @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                    @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
                })
            .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
            .defaultRecipe()
            .addTexture(modRes("block/oak_pillar_side"))
            .addTexture(modRes("block/oak_pillar_top"))
            .setTabKey(CreativeModeTabs.BUILDING_BLOCKS)
            .build();
        this.addEntry(pillar);

        //boards
        boards = SimpleEntrySet.builder(WoodType.class, "boards",
                    getModBlock("oak_boards"), () -> VanillaWoodTypes.OAK,
                    w -> new Block(Utils.copyPropertySafe(w.planks)){
                        @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                        @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                        @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
                    })
            .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
            .defaultRecipe()
            .addTexture(modRes("block/oak_boards"))
            .setTabKey(CreativeModeTabs.BUILDING_BLOCKS)
            .build();
        this.addEntry(boards);

        boardSlab = SimpleEntrySet.builder(WoodType.class, "board_slab",
                    getModBlock("oak_board_slab"), () -> VanillaWoodTypes.OAK,
                    w -> new SlabBlock(Utils.copyPropertySafe(w.planks)){
                        @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                        @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                        @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
                    })
            .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
            .addTag(BlockTags.WOODEN_SLABS, Registries.BLOCK)
            .defaultRecipe()
            .addTexture(modRes("block/oak_boards"))
            .setTabKey(CreativeModeTabs.BUILDING_BLOCKS)
            .build();
        this.addEntry(boardSlab);

        boardStairs = SimpleEntrySet.builder(WoodType.class, "board_stairs",
                    getModBlock("oak_board_stairs"), () -> VanillaWoodTypes.OAK,
                    w -> new StairBlock(w.planks.defaultBlockState(), Utils.copyPropertySafe(w.planks)){
                        @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                        @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                        @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
                    })
            .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
            .addTag(BlockTags.WOODEN_STAIRS, Registries.BLOCK)
            .defaultRecipe()
            .addTexture(modRes("block/oak_boards"))
            .setTabKey(CreativeModeTabs.BUILDING_BLOCKS)
            .build();
        this.addEntry(boardStairs);

        boardWall = SimpleEntrySet.builder(WoodType.class, "board_wall",
                    getModBlock("oak_board_wall"), () -> VanillaWoodTypes.OAK,
                    w -> new WallBlock(Utils.copyPropertySafe(w.planks)){
                        @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                        @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                        @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
                    })
            .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
            .addTag(BlockTags.WALLS, Registries.BLOCK)
            .defaultRecipe()
            .addTexture(modRes("block/oak_boards"))
            .setTabKey(CreativeModeTabs.BUILDING_BLOCKS)
            .build();
        this.addEntry(boardWall);

        //tiles

        tiles = SimpleEntrySet.builder(WoodType.class, "tiles",
                    getModBlock("oak_tiles"), () -> VanillaWoodTypes.OAK,
                    w -> new Block(Utils.copyPropertySafe(w.planks)){
                        @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                        @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                        @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
                    })
            .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
            .addTag(BlockTags.WOODEN_SLABS, Registries.BLOCK)
            .defaultRecipe()
            .addTexture(modRes("block/oak_tiles"))
            .setTabKey(CreativeModeTabs.BUILDING_BLOCKS)
            .build();
        this.addEntry(tiles);

        tileSlab = SimpleEntrySet.builder(WoodType.class, "tile_slab",
                getModBlock("oak_tile_slab"), () -> VanillaWoodTypes.OAK,
                w -> new SlabBlock(Utils.copyPropertySafe(w.planks)){
                    @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                    @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
                })
            .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
            .addTag(BlockTags.WOODEN_SLABS, Registries.BLOCK)
            .defaultRecipe()
            .addTexture(modRes("block/oak_tiles"))
            .setTabKey(CreativeModeTabs.BUILDING_BLOCKS)
            .build();
        this.addEntry(tileSlab);

        tileStairs = SimpleEntrySet.builder(WoodType.class, "tile_stairs",
                    getModBlock("oak_tile_stairs"), () -> VanillaWoodTypes.OAK,
                    w -> new StairBlock(w.planks.defaultBlockState(), Utils.copyPropertySafe(w.planks)){
                        @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                        @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                        @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
                    })
            .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
            .addTag(BlockTags.WOODEN_STAIRS, Registries.BLOCK)
            .defaultRecipe()
            .addTexture(modRes("block/oak_tiles"))
            .setTabKey(CreativeModeTabs.BUILDING_BLOCKS)
            .build();
        this.addEntry(tileStairs);

        tileWall = SimpleEntrySet.builder(WoodType.class, "tile_wall",
                    getModBlock("oak_tile_wall"), () -> VanillaWoodTypes.OAK,
                    w -> new WallBlock(Utils.copyPropertySafe(w.planks)){
                        @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                        @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                        @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
                    })
            .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
            .addTag(BlockTags.WALLS, Registries.BLOCK)
            .defaultRecipe()
            .addTexture(modRes("block/oak_tiles"))
            .setTabKey(CreativeModeTabs.BUILDING_BLOCKS)
            .build();
        this.addEntry(tileWall);

        //carved

        carved = SimpleEntrySet.builder(WoodType.class, "planks", "carved",
                        getModBlock("carved_oak_planks"), () -> VanillaWoodTypes.OAK,
                        w -> new Block(Utils.copyPropertySafe(w.planks)){
                            @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                            @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                            @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
                        })
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(BlockTags.WOODEN_SLABS, Registries.BLOCK)
                .defaultRecipe()
                .addTexture(modRes("block/carved_oak_planks"))
                .setTabKey(CreativeModeTabs.BUILDING_BLOCKS)
                .build();
        this.addEntry(carved);

        carvedSlab = SimpleEntrySet.builder(WoodType.class, "carved_plank_slab",
                        getModBlock("oak_carved_plank_slab"), () -> VanillaWoodTypes.OAK,
                        w -> new SlabBlock(Utils.copyPropertySafe(w.planks)){
                            @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                            @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                            @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
                        })
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(BlockTags.WOODEN_SLABS, Registries.BLOCK)
                .defaultRecipe()
                .addTexture(modRes("block/carved_oak_planks"))
                .setTabKey(CreativeModeTabs.BUILDING_BLOCKS)
                .build();
        this.addEntry(carvedSlab);

        carvedStairs = SimpleEntrySet.builder(WoodType.class, "carved_plank_stairs",
                        getModBlock("oak_carved_plank_stairs"), () -> VanillaWoodTypes.OAK,
                        w -> new StairBlock(w.planks.defaultBlockState(), Utils.copyPropertySafe(w.planks)){
                            @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                            @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                            @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
                        })
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(BlockTags.WOODEN_STAIRS, Registries.BLOCK)
                .defaultRecipe()
                .addTexture(modRes("block/carved_oak_planks"))
                .setTabKey(CreativeModeTabs.BUILDING_BLOCKS)
                .build();
        this.addEntry(carvedStairs);

        carvedWall = SimpleEntrySet.builder(WoodType.class, "carved_plank_wall",
                        getModBlock("oak_carved_plank_wall"), () -> VanillaWoodTypes.OAK,
                        w -> new WallBlock(Utils.copyPropertySafe(w.planks)){
                            @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                            @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                            @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
                        })
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(BlockTags.WALLS, Registries.BLOCK)
                .defaultRecipe()
                .addTexture(modRes("block/carved_oak_planks"))
                .setTabKey(CreativeModeTabs.BUILDING_BLOCKS)
                .build();
        this.addEntry(carvedWall);

        //chiseled
        chiseled_planks = SimpleEntrySet.builder(WoodType.class, "planks","chiseled",
                    getModBlock("chiseled_oak_planks"), () -> VanillaWoodTypes.OAK,
                    w -> new Block(Utils.copyPropertySafe(w.planks)){
                        @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                        @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                        @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
                    })
            .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
            .defaultRecipe()
            .addTexture(modRes("block/chiseled_oak_planks"))
            .setTabKey(CreativeModeTabs.BUILDING_BLOCKS)
            .build();
        this.addEntry(chiseled_planks);
    }

    @Override
    public boolean isEntryAlreadyRegistered(String entrySetId, String blockId, BlockType blockType, Registry<?> registry) {

        if (blockType instanceof WoodType wt) {
            if
            (blockId.contains("boards") && !blockType.isVanilla()) return false;
        }

        return super.isEntryAlreadyRegistered(entrySetId, blockId, blockType, registry);
    }
}
