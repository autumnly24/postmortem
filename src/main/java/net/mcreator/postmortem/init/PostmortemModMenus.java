
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.postmortem.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.postmortem.world.inventory.ImmortalityContractAgreementMenu;
import net.mcreator.postmortem.PostmortemMod;

public class PostmortemModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, PostmortemMod.MODID);
	public static final RegistryObject<MenuType<ImmortalityContractAgreementMenu>> IMMORTALITY_CONTRACT_AGREEMENT = REGISTRY.register("immortality_contract_agreement", () -> IForgeMenuType.create(ImmortalityContractAgreementMenu::new));
}
