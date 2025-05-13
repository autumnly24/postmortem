package net.mcreator.postmortem.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.postmortem.network.PostmortemModVariables;

public class GhostOverlayDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PostmortemModVariables.PlayerVariables())).IsGhost == true) {
			return true;
		}
		return false;
	}
}
