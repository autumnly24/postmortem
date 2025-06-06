package net.mcreator.postmortem.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.postmortem.network.PostmortemModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CheckPlayerInSunlightProcedure {
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
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getCount() == 0) {
			if (!(world.dayTime() % 24000 > 13000 && world.dayTime() % 24000 < 23000)) {
				if (!world.getLevelData().isRaining()) {
					if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
						{
							boolean _setval = true;
							entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.IsInSun = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						{
							boolean _setval = false;
							entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.IsInSun = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				} else {
					{
						boolean _setval = false;
						entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.IsInSun = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else {
				{
					boolean _setval = false;
					entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IsInSun = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else {
			{
				boolean _setval = false;
				entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.IsInSun = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
