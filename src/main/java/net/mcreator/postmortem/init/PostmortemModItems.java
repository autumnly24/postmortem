
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.postmortem.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.postmortem.item.TotemOfRebirthItem;
import net.mcreator.postmortem.item.RefleshingAppleItem;
import net.mcreator.postmortem.item.ImmortalityContractItem;
import net.mcreator.postmortem.item.CrackedTotemOfRebirthItem;
import net.mcreator.postmortem.item.CleansedDiamondItem;
import net.mcreator.postmortem.item.AreYouSureItem;
import net.mcreator.postmortem.item.AncientDaggerItem;
import net.mcreator.postmortem.PostmortemMod;

public class PostmortemModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, PostmortemMod.MODID);
	public static final RegistryObject<Item> IMMORTALITY_CONTRACT = REGISTRY.register("immortality_contract", () -> new ImmortalityContractItem());
	public static final RegistryObject<Item> ARE_YOU_SURE = REGISTRY.register("are_you_sure", () -> new AreYouSureItem());
	public static final RegistryObject<Item> TOTEM_OF_REBIRTH = REGISTRY.register("totem_of_rebirth", () -> new TotemOfRebirthItem());
	public static final RegistryObject<Item> CRACKED_TOTEM_OF_REBIRTH = REGISTRY.register("cracked_totem_of_rebirth", () -> new CrackedTotemOfRebirthItem());
	public static final RegistryObject<Item> CLEANSED_DIAMOND = REGISTRY.register("cleansed_diamond", () -> new CleansedDiamondItem());
	public static final RegistryObject<Item> ANCIENT_DAGGER = REGISTRY.register("ancient_dagger", () -> new AncientDaggerItem());
	public static final RegistryObject<Item> REFLESHING_APPLE = REGISTRY.register("refleshing_apple", () -> new RefleshingAppleItem());
	// Start of user code block custom items
	// End of user code block custom items
}
