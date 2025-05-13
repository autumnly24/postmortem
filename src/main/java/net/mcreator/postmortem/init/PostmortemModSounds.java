
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.postmortem.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.postmortem.PostmortemMod;

public class PostmortemModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, PostmortemMod.MODID);
	public static final RegistryObject<SoundEvent> ARE_YOU_SURE = REGISTRY.register("are_you_sure", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("postmortem", "are_you_sure")));
	public static final RegistryObject<SoundEvent> OMNI = REGISTRY.register("omni", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("postmortem", "omni")));
}
