package net.mcreator.postmortem.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.postmortem.network.PostmortemModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GhostRenderProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PostmortemModVariables.PlayerVariables())).IsGhost == true) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, (y + 1.1), z, 6, 0.3, 0.4, 0.3, 0);
		}
	}
}
