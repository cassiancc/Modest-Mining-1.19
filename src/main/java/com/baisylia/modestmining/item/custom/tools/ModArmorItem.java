package com.baisylia.modestmining.item.custom.tools;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class ModArmorItem extends ArmorItem {
    public ModArmorItem(ArmorMaterial material, Type slot, Properties settings) {
        super(material, slot, settings);
    }

    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties settings) {
        super(material, getType(slot), settings);
    }

    static Type getType(EquipmentSlot slot) {
		return switch (slot) {
			case FEET -> Type.BOOTS;
			case LEGS -> Type.LEGGINGS;
			case CHEST -> Type.CHESTPLATE;
			case HEAD -> Type.HELMET;
			default -> null;
		};
    }
}
