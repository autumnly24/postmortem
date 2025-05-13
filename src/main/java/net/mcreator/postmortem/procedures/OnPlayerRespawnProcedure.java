package net.mcreator.postmortem.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.postmortem.network.PostmortemModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnPlayerRespawnProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.isClientSide()) {
			Minecraft.getInstance().getTextureManager().release(new ResourceLocation("minecraft:textures/gui/icons.png"));
		}
		if ((entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PostmortemModVariables.PlayerVariables())).DeathType == 1) {
			{
				boolean _setval = true;
				entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.IsGhost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SPECTATOR);
			{
				Entity _ent = entity;
				_ent.teleportTo(((entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PostmortemModVariables.PlayerVariables())).DeathX),
						((entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PostmortemModVariables.PlayerVariables())).DeathY),
						((entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PostmortemModVariables.PlayerVariables())).DeathZ));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(((entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PostmortemModVariables.PlayerVariables())).DeathX),
							((entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PostmortemModVariables.PlayerVariables())).DeathY),
							((entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PostmortemModVariables.PlayerVariables())).DeathZ), _ent.getYRot(), _ent.getXRot());
			}
			world.getLevelData().getGameRules().getRule(GameRules.RULE_DO_IMMEDIATE_RESPAWN).set(false, world.getServer());
		}
	}
}
