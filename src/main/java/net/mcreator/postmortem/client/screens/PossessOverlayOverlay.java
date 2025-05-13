
package net.mcreator.postmortem.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import net.mcreator.postmortem.procedures.ReturnPossessKeybindProcedure;
import net.mcreator.postmortem.procedures.PossessOverlayDisplayOverlayIngameProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class PossessOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (PossessOverlayDisplayOverlayIngameProcedure.execute(world, entity)) {
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnPossessKeybindProcedure.execute(), w / 2 + -1, h / 2 + -5, -16751002, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnPossessKeybindProcedure.execute(), w / 2 + -2, h / 2 + -6, -10027060, false);
		}
	}
}
