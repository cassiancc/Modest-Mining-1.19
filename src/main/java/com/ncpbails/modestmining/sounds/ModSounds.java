package com.ncpbails.modestmining.sounds;

import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.ncpbails.modestmining.ModestMining.MOD_ID;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MOD_ID);

    public static final RegistryObject<SoundEvent> FORGE_CRACKLE = SOUND_EVENTS.register("oven_crackle",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MOD_ID, "block.forge.crackle")));
    public static final RegistryObject<SoundEvent> CHISEL_GENERIC = SOUND_EVENTS.register("chisel_generic",  ()-> SoundEvent.createVariableRangeEvent(new ResourceLocation(MOD_ID, "item.chisel.chiseling.generic")));

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}