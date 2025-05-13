package net.mcreator.postmortem.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.RenderArmEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;

@Mod.EventBusSubscriber(value = {Dist.CLIENT})
public class HostRenderArmsProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onEventTriggered(RenderArmEvent event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		RenderArmEvent _evt = (RenderArmEvent) event;
		Minecraft mc = Minecraft.getInstance();
		EntityRenderDispatcher dis = mc.getEntityRenderDispatcher();
		Entity _evtEntity = _evt.getPlayer();
		PlayerRenderer playerRenderer = (PlayerRenderer) dis.getRenderer(_evt.getPlayer());
		EntityRendererProvider.Context context = new EntityRendererProvider.Context(dis, mc.getItemRenderer(), mc.getBlockRenderer(), dis.getItemInHandRenderer(), mc.getResourceManager(), mc.getEntityModels(), mc.font);
		MultiBufferSource bufferSource = _evt.getMultiBufferSource();
		int packedLight = _evt.getPackedLight();
		PoseStack poseStack = _evt.getPoseStack();
		PlayerModel<AbstractClientPlayer> playerModel = new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER), false);
		playerModel.attackTime = 0.0F;
		playerModel.crouching = false;
		playerModel.swimAmount = 0.0F;
		playerModel.setupAnim(_evt.getPlayer(), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		playerModel.leftArm.xRot = 0.0F;
		playerModel.rightArm.xRot = 0.0F;
		HumanoidArm arm = _evt.getArm();
	}
}
