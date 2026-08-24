package com.baisylia.modestmining.item;

import com.baisylia.modestmining.ModestMining;
import com.baisylia.modestmining.entity.ModEntityTypes;
import com.baisylia.modestmining.item.custom.tools.ChiselItem;
import com.baisylia.modestmining.item.custom.tools.ModArmorItem;
import com.baisylia.modestmining.item.custom.weapons.HammerItem;
import com.baisylia.modestmining.item.custom.weapons.JavelinItem;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModestMining.MOD_ID);

    // Materials
    public static final RegistryObject<Item> COKE = register("coke", () -> new Item(new Item.Properties()) {
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 6400;
        }
    }, CreativeModeTabs.INGREDIENTS);

    public static final RegistryObject<Item> COAL_CHUNK = register("coal_chunk", () -> new Item(new Item.Properties()) {
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200;
        }
    }, CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> CHARCOAL_CHUNK = register("charcoal_chunk", () -> new Item(new Item.Properties()) {
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 200;
        }
    }, CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> COKE_CHUNK = register("coke_chunk", () -> new Item(new Item.Properties()) {
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return 800;
        }
    }, CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> COPPER_NUGGET = register("copper_nugget", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> DIAMOND_SHARD = register("diamond_shard", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> ALUMINIUM_INGOT = register("aluminium_ingot", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> ALUMINIUM_NUGGET = register("aluminium_nugget", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> RAW_ALUMINIUM = register("raw_aluminium", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);

    public static final RegistryObject<Item> ALUMINIUM_DUST = register("aluminium_dust", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> LEAD_INGOT = register("lead_ingot", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> LEAD_NUGGET = register("lead_nugget", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> RAW_LEAD = register("raw_lead", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> LEAD_DUST = register("lead_dust", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> SILVER_INGOT = register("silver_ingot", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> SILVER_NUGGET = register("silver_nugget", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> RAW_SILVER = register("raw_silver", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> SILVER_DUST = register("silver_dust", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> STEEL_INGOT = register("steel_ingot", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> STEEL_NUGGET = register("steel_nugget", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> ROSEGOLD_INGOT = register("rosegold_ingot", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> ROSEGOLD_NUGGET = register("rosegold_nugget", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> BRONZE_INGOT = register("bronze_ingot", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> BRONZE_NUGGET = register("bronze_nugget", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> ELECTRUM_INGOT = register("electrum_ingot", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> ELECTRUM_NUGGET = register("electrum_nugget", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> PRISMARITE_INGOT = register("prismarite_ingot", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> PRISMARITE_NUGGET = register("prismarite_nugget", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> VALKYRIUM_INGOT = register("valkyrium_ingot", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> VALKYRIUM_NUGGET = register("valkyrium_nugget", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> COPPER_SCREW = register("copper_screw", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> PEARL = register("pearl", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> FLESH = register("flesh", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> AMETHYST = register("amethyst", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> DIAMOND_PLATING = register("diamond_plating", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> DIAMOND_PIECE = register("diamond_piece", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> COPPER_DUST = register("copper_dust", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> GOLD_DUST = register("gold_dust", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> IRON_DUST = register("iron_dust", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> DEBRIS_DUST = register("debris_dust", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> METEORIC_DUST = register("meteoric_dust", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final RegistryObject<Item> METEORIC_SCRAP = register("meteoric_scrap", () -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);

    // TOOLS
    public static final RegistryObject<Item> CHISEL = register("chisel", () -> new ChiselItem(0f, 0f, ModTiers.COPPER,
            new Item.Properties().durability(450)), CreativeModeTabs.TOOLS_AND_UTILITIES);

    // Flint
    public static final RegistryObject<Item> FLINT_BLADE = register("flint_blade", () -> new SwordItem(ModTiers.FLINT, 1, -3,
            new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> FLINT_HATCHET = register("flint_hatchet", () -> new AxeItem(ModTiers.FLINT, 3.0f, -3,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> FLINT_MATTOCK = register("flint_mattock", () -> new PickaxeItem(ModTiers.FLINT, 0, -3,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> FLINT_SPADE = register("flint_spade", () -> new ShovelItem(ModTiers.FLINT, 0, -3,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> FLINT_HOE = register("flint_hoe", () -> new HoeItem(ModTiers.FLINT, -1, -3,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);

    // Bronze
    public static final RegistryObject<Item> BRONZE_SWORD = register("bronze_sword", () -> new SwordItem(ModTiers.BRONZE, 3, -2.4f,
            new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> BRONZE_AXE = register("bronze_axe", () -> new AxeItem(ModTiers.BRONZE, 6.0f, -3.1f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> BRONZE_PICKAXE = register("bronze_pickaxe", () -> new PickaxeItem(ModTiers.BRONZE, 1, -2.8f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> BRONZE_SHOVEL = register("bronze_shovel", () -> new ShovelItem(ModTiers.BRONZE, 1.5f, -3f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> BRONZE_HOE = register("bronze_hoe", () -> new HoeItem(ModTiers.BRONZE, -1, -2f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);

    public static final RegistryObject<Item> BRONZE_HELMET = register("bronze_helmet", () -> new ModArmorItem(ModArmourMaterials.BRONZE, EquipmentSlot.HEAD,
            new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> BRONZE_CHESTPLATE = register("bronze_chestplate", () -> new ModArmorItem(ModArmourMaterials.BRONZE, EquipmentSlot.CHEST,
            new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> BRONZE_LEGGINGS = register("bronze_leggings", () -> new ModArmorItem(ModArmourMaterials.BRONZE, EquipmentSlot.LEGS,
            new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> BRONZE_BOOTS = register("bronze_boots", () -> new ModArmorItem(ModArmourMaterials.BRONZE, EquipmentSlot.FEET,
            new Item.Properties()), CreativeModeTabs.COMBAT);

    // Steel
    public static final RegistryObject<Item> STEEL_SWORD = register("steel_sword", () -> new SwordItem(ModTiers.STEEL, 3, -2.4f,
            new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> STEEL_AXE = register("steel_axe", () -> new AxeItem(ModTiers.STEEL, 5.5f, -3f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> STEEL_PICKAXE = register("steel_pickaxe", () -> new PickaxeItem(ModTiers.STEEL, 1, -2.8f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> STEEL_SHOVEL = register("steel_shovel", () -> new ShovelItem(ModTiers.STEEL, 1.5f, -3f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> STEEL_HOE = register("steel_hoe", () -> new HoeItem(ModTiers.STEEL, -2, 0f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);

    public static final RegistryObject<Item> STEEL_HELMET = register("steel_helmet", () -> new ModArmorItem(ModArmourMaterials.STEEL, EquipmentSlot.HEAD,
            new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> STEEL_CHESTPLATE = register("steel_chestplate", () -> new ModArmorItem(ModArmourMaterials.STEEL, EquipmentSlot.CHEST,
            new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> STEEL_LEGGINGS = register("steel_leggings", () -> new ModArmorItem(ModArmourMaterials.STEEL, EquipmentSlot.LEGS,
            new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> STEEL_BOOTS = register("steel_boots", () -> new ModArmorItem(ModArmourMaterials.STEEL, EquipmentSlot.FEET,
            new Item.Properties()), CreativeModeTabs.COMBAT);

    // Prismarite
    public static final RegistryObject<Item> PRISMARITE_SWORD = register("prismarite_sword", () -> new SwordItem(ModTiers.PRISMARITE, 3, -2.4f,
            new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> PRISMARITE_AXE = register("prismarite_axe", () -> new AxeItem(ModTiers.PRISMARITE, 5f, -3f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> PRISMARITE_PICKAXE = register("prismarite_pickaxe", () -> new PickaxeItem(ModTiers.PRISMARITE, 1, -2.8f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> PRISMARITE_SHOVEL = register("prismarite_shovel", () -> new ShovelItem(ModTiers.PRISMARITE, 1.5f, -3f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> PRISMARITE_HOE = register("prismarite_hoe", () -> new HoeItem(ModTiers.PRISMARITE, -4, 0f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);

    public static final RegistryObject<Item> PRISMARITE_HELMET = register("prismarite_helmet", () -> new ModArmorItem(ModArmourMaterials.PRISMARITE, EquipmentSlot.HEAD,
            new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> PRISMARITE_CHESTPLATE = register("prismarite_chestplate", () -> new ModArmorItem(ModArmourMaterials.PRISMARITE, EquipmentSlot.CHEST,
            new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> PRISMARITE_LEGGINGS = register("prismarite_leggings", () -> new ModArmorItem(ModArmourMaterials.PRISMARITE, EquipmentSlot.LEGS,
            new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> PRISMARITE_BOOTS = register("prismarite_boots", () -> new ModArmorItem(ModArmourMaterials.PRISMARITE, EquipmentSlot.FEET,
            new Item.Properties()), CreativeModeTabs.COMBAT);

    // Valkyrium
    public static final RegistryObject<Item> VALKYRIUM_SWORD = register("valkyrium_sword", () -> new SwordItem(ModTiers.VALKYRIUM, 3, -2.4f,
            new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> VALKYRIUM_AXE = register("valkyrium_axe", () -> new AxeItem(ModTiers.VALKYRIUM, 5f, -3f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> VALKYRIUM_PICKAXE = register("valkyrium_pickaxe", () -> new PickaxeItem(ModTiers.VALKYRIUM, 1, -2.8f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> VALKYRIUM_SHOVEL = register("valkyrium_shovel", () -> new ShovelItem(ModTiers.VALKYRIUM, 1.5f, -3f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> VALKYRIUM_HOE = register("valkyrium_hoe", () -> new HoeItem(ModTiers.VALKYRIUM, -4, 0f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> VALKYRIUM_HELMET = register("valkyrium_helmet", () -> new ModArmorItem(ModArmourMaterials.VALKYRIUM, EquipmentSlot.HEAD,
            new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> VALKYRIUM_CHESTPLATE = register("valkyrium_chestplate", () -> new ModArmorItem(ModArmourMaterials.VALKYRIUM, EquipmentSlot.CHEST,
            new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> VALKYRIUM_LEGGINGS = register("valkyrium_leggings", () -> new ModArmorItem(ModArmourMaterials.VALKYRIUM, EquipmentSlot.LEGS,
            new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> VALKYRIUM_BOOTS = register("valkyrium_boots", () -> new ModArmorItem(ModArmourMaterials.VALKYRIUM, EquipmentSlot.FEET,
            new Item.Properties()), CreativeModeTabs.COMBAT);

    // Hammers
    public static final RegistryObject<Item> FLINT_HAMMER = register("flint_hammer", () -> new HammerItem(ModTiers.FLINT, 7, -3.4f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> WOODEN_HAMMER = register("wooden_hammer", () -> new HammerItem(Tiers.WOOD, 7, -3.4f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> STONE_HAMMER = register("stone_hammer", () -> new HammerItem(Tiers.STONE, 7, -3.4f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> BRONZE_HAMMER = register("bronze_hammer", () -> new HammerItem(ModTiers.BRONZE, 7, -3.4f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> IRON_HAMMER = register("iron_hammer", () -> new HammerItem(Tiers.IRON, 7, -3.4f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> STEEL_HAMMER = register("steel_hammer", () -> new HammerItem(ModTiers.STEEL, 7, -3.4f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> GOLDEN_HAMMER = register("golden_hammer", () -> new HammerItem(Tiers.GOLD, 7, -3.3f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> DIAMOND_HAMMER = register("diamond_hammer", () -> new HammerItem(Tiers.DIAMOND, 7, -3.2f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> NETHERITE_HAMMER = register("netherite_hammer", () -> new HammerItem(Tiers.NETHERITE, 7, -3.2f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> PRISMARITE_HAMMER = register("prismarite_hammer", () -> new HammerItem(ModTiers.PRISMARITE, 7, -3.2f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final RegistryObject<Item> VALKYRIUM_HAMMER = register("valkyrium_hammer", () -> new HammerItem(ModTiers.VALKYRIUM, 7, -3.2f,
            new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);

    // Javelins
    public static final RegistryObject<Item> FLINT_JAVELIN = register("flint_javelin", () -> new JavelinItem(ModTiers.FLINT, 2.0F, -2.9F, 1.5F,
            new Item.Properties().durability(ModTiers.FLINT.getUses())), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> WOODEN_JAVELIN = register("wooden_javelin", () -> new JavelinItem(Tiers.WOOD, 2.0F, -2.9F, 1.5F,
            new Item.Properties().durability(Tiers.WOOD.getUses())), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> STONE_JAVELIN = register("stone_javelin", () -> new JavelinItem(Tiers.STONE, 2.0F, -2.9F, 1.5F,
            new Item.Properties().durability(Tiers.STONE.getUses())), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> BRONZE_JAVELIN = register("bronze_javelin", () -> new JavelinItem(ModTiers.BRONZE, 2.0F, -2.9F, 1.5F,
            new Item.Properties().durability(ModTiers.BRONZE.getUses())), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> GOLDEN_JAVELIN = register("golden_javelin", () -> new JavelinItem(Tiers.GOLD, 2.0F, -2.9F, 1.5F,
            new Item.Properties().durability(Tiers.GOLD.getUses())), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> IRON_JAVELIN = register("iron_javelin", () -> new JavelinItem(Tiers.IRON, 2.0F, -2.8F, 1.5F,
            new Item.Properties().durability(Tiers.IRON.getUses())), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> STEEL_JAVELIN = register("steel_javelin", () -> new JavelinItem(ModTiers.STEEL, 2.0F, -2.8F, 1.5F,
            new Item.Properties().durability(ModTiers.STEEL.getUses())), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> DIAMOND_JAVELIN = register("diamond_javelin", () -> new JavelinItem(Tiers.DIAMOND, 2.0F, -2.7F, 1.5F,
            new Item.Properties().durability(Tiers.DIAMOND.getUses())), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> NETHERITE_JAVELIN = register("netherite_javelin", () -> new JavelinItem(Tiers.NETHERITE, 2.0F, -2.7F, 1.5F,
            new Item.Properties().durability(Tiers.NETHERITE.getUses()).fireResistant()), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> PRISMARITE_JAVELIN = register("prismarite_javelin", () -> new JavelinItem(ModTiers.PRISMARITE, 2.0F, -2.7F, 1.5F,
            new Item.Properties().durability(ModTiers.PRISMARITE.getUses())), CreativeModeTabs.COMBAT);
    public static final RegistryObject<Item> VALKYRIUM_JAVELIN = register("valkyrium_javelin", () -> new JavelinItem(ModTiers.VALKYRIUM, 2.0F, -2.7F, 1.5F,
            new Item.Properties().durability(ModTiers.VALKYRIUM.getUses())), CreativeModeTabs.COMBAT);

    private static RegistryObject<Item> register(String name, Supplier<Item> item, ResourceKey<CreativeModeTab> tab) {
//        if (tab.equals(CreativeModeTabs.COMBAT)) {
//            COMBAT.add(item);
//        }       else  if (tab.equals(CreativeModeTabs.INGREDIENTS)) {
//            INGREDIENTS.add(item);
//        } else  if (tab.equals(CreativeModeTabs.TOOLS_AND_UTILITIES)) {
//            TOOLS.add(item);
//        }
        return ITEMS.register(name, item);
    }
    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
