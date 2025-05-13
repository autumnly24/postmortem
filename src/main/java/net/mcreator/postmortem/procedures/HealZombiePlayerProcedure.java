package net.mcreator.postmortem.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.postmortem.network.PostmortemModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HealZombiePlayerProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double TotalKillHP = 0;
		if (sourceentity instanceof Player) {
			if ((sourceentity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PostmortemModVariables.PlayerVariables())).Host == 1
					|| (sourceentity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PostmortemModVariables.PlayerVariables())).Host == 3
					|| (sourceentity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PostmortemModVariables.PlayerVariables())).Host == 6) {
				TotalKillHP = entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1;
				if (sourceentity instanceof LivingEntity _entity)
					_entity.setHealth((float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + TotalKillHP / 4));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.eat")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			}
		}
	}
}
