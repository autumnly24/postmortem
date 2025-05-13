
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.postmortem.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.postmortem.PostmortemMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PostmortemModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PostmortemMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {

			tabData.accept(PostmortemModItems.ANCIENT_DAGGER.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {

			tabData.accept(PostmortemModItems.CLEANSED_DIAMOND.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {

			tabData.accept(PostmortemModItems.IMMORTALITY_CONTRACT.get());
			tabData.accept(PostmortemModItems.TOTEM_OF_REBIRTH.get());
			tabData.accept(PostmortemModItems.CRACKED_TOTEM_OF_REBIRTH.get());
			tabData.accept(PostmortemModItems.ANCIENT_DAGGER.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {

			tabData.accept(PostmortemModItems.REFLESHING_APPLE.get());

		}
	}
}
