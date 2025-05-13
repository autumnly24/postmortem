package net.mcreator.postmortem.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.postmortem.network.PostmortemModVariables;
import net.mcreator.postmortem.client.model.Modelzombie;
import net.mcreator.postmortem.client.model.Modelwither_skeleton;
import net.mcreator.postmortem.client.model.Modelstray_outer;
import net.mcreator.postmortem.client.model.Modelstray;
import net.mcreator.postmortem.client.model.Modelskeleton;
import net.mcreator.postmortem.client.model.Modeldrowned_outer;
import net.mcreator.postmortem.client.model.Modeldrowned;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;

@Mod.EventBusSubscriber(value = {Dist.CLIENT})
public class HostRenderProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onEventTriggered(RenderLivingEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		RenderLivingEvent _evt = (RenderLivingEvent) event;
		Minecraft mc = Minecraft.getInstance();
		EntityRenderDispatcher dis = Minecraft.getInstance().getEntityRenderDispatcher();
		EntityRendererProvider.Context context = new EntityRendererProvider.Context(dis, mc.getItemRenderer(), mc.getBlockRenderer(), dis.getItemInHandRenderer(), mc.getResourceManager(), mc.getEntityModels(), mc.font);
		Entity _evtEntity = _evt.getEntity();
		PlayerRenderer _pr = null;
		PoseStack poseStack = _evt.getPoseStack();
		if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
			ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/empty.png");
			com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer emptyRenderer = new com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer(context,
					(_evtEntity instanceof AbstractClientPlayer ? ((AbstractClientPlayer) _evtEntity).getModelName().equals("slim") : false), _texture);
			_pr = emptyRenderer;
			emptyRenderer.clearLayers();
			emptyRenderer.render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(), _evt.getMultiBufferSource(), _evt.getPackedLight());
		}
		if ((entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PostmortemModVariables.PlayerVariables())).Host == 1) {
			if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
				if (ResourceLocation.tryParse("minecraft:textures/entity/zombie/zombie.png") != null) {
					_texture = new ResourceLocation("minecraft:textures/entity/zombie/zombie.png");
				}
				Modelzombie newModel = new Modelzombie(context.bakeLayer(Modelzombie.LAYER_LOCATION));
				newModel.LeftLeg.copyFrom(_pr.getModel().leftLeg);
				newModel.RightLeg.copyFrom(_pr.getModel().rightLeg);
				newModel.LeftArm.copyFrom(_pr.getModel().leftArm);
				newModel.RightArm.copyFrom(_pr.getModel().rightArm);
				newModel.Body.copyFrom(_pr.getModel().body);
				newModel.Head.copyFrom(_pr.getModel().head);
				poseStack.pushPose();
				poseStack.scale(0.9375F, 0.9375F, 0.9375F);
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerAnimatedRenderer(context, _texture, newModel).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
						_evt.getMultiBufferSource(), _evt.getPackedLight());
				poseStack.popPose();
			}
		} else if ((entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PostmortemModVariables.PlayerVariables())).Host == 2) {
			if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
				if (ResourceLocation.tryParse("minecraft:textures/entity/skeleton/skeleton.png") != null) {
					_texture = new ResourceLocation("minecraft:textures/entity/skeleton/skeleton.png");
				}
				Modelskeleton newModel = new Modelskeleton(context.bakeLayer(Modelskeleton.LAYER_LOCATION));
				newModel.LeftLeg.copyFrom(_pr.getModel().leftLeg);
				newModel.RightLeg.copyFrom(_pr.getModel().rightLeg);
				newModel.LeftArm.copyFrom(_pr.getModel().leftArm);
				newModel.RightArm.copyFrom(_pr.getModel().rightArm);
				newModel.Body.copyFrom(_pr.getModel().body);
				newModel.Head.copyFrom(_pr.getModel().head);
				poseStack.pushPose();
				poseStack.scale(0.9375F, 0.9375F, 0.9375F);
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerAnimatedRenderer(context, _texture, newModel).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
						_evt.getMultiBufferSource(), _evt.getPackedLight());
				poseStack.popPose();
			}
		} else if ((entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PostmortemModVariables.PlayerVariables())).Host == 3) {
			if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
				if (ResourceLocation.tryParse("minecraft:textures/entity/zombie/drowned.png") != null) {
					_texture = new ResourceLocation("minecraft:textures/entity/zombie/drowned.png");
				}
				Modeldrowned newModel = new Modeldrowned(context.bakeLayer(Modeldrowned.LAYER_LOCATION));
				newModel.LeftLeg.copyFrom(_pr.getModel().leftLeg);
				newModel.RightLeg.copyFrom(_pr.getModel().rightLeg);
				newModel.LeftArm.copyFrom(_pr.getModel().leftArm);
				newModel.RightArm.copyFrom(_pr.getModel().rightArm);
				newModel.Body.copyFrom(_pr.getModel().body);
				newModel.Head.copyFrom(_pr.getModel().head);
				poseStack.pushPose();
				poseStack.scale(0.9375F, 0.9375F, 0.9375F);
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerAnimatedRenderer(context, _texture, newModel).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
						_evt.getMultiBufferSource(), _evt.getPackedLight());
				poseStack.popPose();
			}
			if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
				if (ResourceLocation.tryParse("minecraft:textures/entity/zombie/drowned_outer_layer.png") != null) {
					_texture = new ResourceLocation("minecraft:textures/entity/zombie/drowned_outer_layer.png");
				}
				Modeldrowned_outer newModel = new Modeldrowned_outer(context.bakeLayer(Modeldrowned_outer.LAYER_LOCATION));
				newModel.LeftLeg.copyFrom(_pr.getModel().leftLeg);
				newModel.RightLeg.copyFrom(_pr.getModel().rightLeg);
				newModel.LeftArm.copyFrom(_pr.getModel().leftArm);
				newModel.RightArm.copyFrom(_pr.getModel().rightArm);
				newModel.Body.copyFrom(_pr.getModel().body);
				newModel.Head.copyFrom(_pr.getModel().head);
				poseStack.pushPose();
				poseStack.scale(0.9375F, 0.9375F, 0.9375F);
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerAnimatedRenderer(context, _texture, newModel).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
						_evt.getMultiBufferSource(), _evt.getPackedLight());
				poseStack.popPose();
			}
		} else if ((entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PostmortemModVariables.PlayerVariables())).Host == 4) {
			if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
				if (ResourceLocation.tryParse("minecraft:textures/entity/skeleton/stray.png") != null) {
					_texture = new ResourceLocation("minecraft:textures/entity/skeleton/stray.png");
				}
				Modelstray newModel = new Modelstray(context.bakeLayer(Modelstray.LAYER_LOCATION));
				newModel.LeftLeg.copyFrom(_pr.getModel().leftLeg);
				newModel.RightLeg.copyFrom(_pr.getModel().rightLeg);
				newModel.LeftArm.copyFrom(_pr.getModel().leftArm);
				newModel.RightArm.copyFrom(_pr.getModel().rightArm);
				newModel.Body.copyFrom(_pr.getModel().body);
				newModel.Head.copyFrom(_pr.getModel().head);
				poseStack.pushPose();
				poseStack.scale(0.9375F, 0.9375F, 0.9375F);
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerAnimatedRenderer(context, _texture, newModel).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
						_evt.getMultiBufferSource(), _evt.getPackedLight());
				poseStack.popPose();
			}
			if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
				if (ResourceLocation.tryParse("minecraft:textures/entity/skeleton/stray_overlay.png") != null) {
					_texture = new ResourceLocation("minecraft:textures/entity/skeleton/stray_overlay.png");
				}
				Modelstray_outer newModel = new Modelstray_outer(context.bakeLayer(Modelstray_outer.LAYER_LOCATION));
				newModel.LeftLeg.copyFrom(_pr.getModel().leftLeg);
				newModel.RightLeg.copyFrom(_pr.getModel().rightLeg);
				newModel.LeftArm.copyFrom(_pr.getModel().leftArm);
				newModel.RightArm.copyFrom(_pr.getModel().rightArm);
				newModel.Body.copyFrom(_pr.getModel().body);
				newModel.Head.copyFrom(_pr.getModel().head);
				poseStack.pushPose();
				poseStack.scale(0.9375F, 0.9375F, 0.9375F);
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerAnimatedRenderer(context, _texture, newModel).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
						_evt.getMultiBufferSource(), _evt.getPackedLight());
				poseStack.popPose();
			}
		} else if ((entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PostmortemModVariables.PlayerVariables())).Host == 5) {
			if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
				if (ResourceLocation.tryParse("minecraft:textures/entity/skeleton/wither_skeleton.png") != null) {
					_texture = new ResourceLocation("minecraft:textures/entity/skeleton/wither_skeleton.png");
				}
				Modelwither_skeleton newModel = new Modelwither_skeleton(context.bakeLayer(Modelwither_skeleton.LAYER_LOCATION));
				newModel.LeftLeg.copyFrom(_pr.getModel().leftLeg);
				newModel.RightLeg.copyFrom(_pr.getModel().rightLeg);
				newModel.LeftArm.copyFrom(_pr.getModel().leftArm);
				newModel.RightArm.copyFrom(_pr.getModel().rightArm);
				newModel.Body.copyFrom(_pr.getModel().body);
				newModel.Head.copyFrom(_pr.getModel().head);
				poseStack.pushPose();
				poseStack.scale(0.9375F, 0.9375F, 0.9375F);
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerAnimatedRenderer(context, _texture, newModel).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
						_evt.getMultiBufferSource(), _evt.getPackedLight());
				poseStack.popPose();
			}
		} else if ((entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PostmortemModVariables.PlayerVariables())).Host == 6) {
			if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
				if (ResourceLocation.tryParse("minecraft:textures/entity/zombie/husk.png") != null) {
					_texture = new ResourceLocation("minecraft:textures/entity/zombie/husk.png");
				}
				Modelzombie newModel = new Modelzombie(context.bakeLayer(Modelzombie.LAYER_LOCATION));
				newModel.LeftLeg.copyFrom(_pr.getModel().leftLeg);
				newModel.RightLeg.copyFrom(_pr.getModel().rightLeg);
				newModel.LeftArm.copyFrom(_pr.getModel().leftArm);
				newModel.RightArm.copyFrom(_pr.getModel().rightArm);
				newModel.Body.copyFrom(_pr.getModel().body);
				newModel.Head.copyFrom(_pr.getModel().head);
				poseStack.pushPose();
				poseStack.scale(0.9375F, 0.9375F, 0.9375F);
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerAnimatedRenderer(context, _texture, newModel).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
						_evt.getMultiBufferSource(), _evt.getPackedLight());
				poseStack.popPose();
			}
		}
		if ((entity.getCapability(PostmortemModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PostmortemModVariables.PlayerVariables())).Host != 0) {
			if (_evt.getRenderer() instanceof PlayerRenderer _prmodel && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer.hidePlayerModelPiece(_prmodel.getModel(), 7);
			}
			if (_evt.getRenderer() instanceof PlayerRenderer _prmodel && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer.hidePlayerModelPiece(_prmodel.getModel(), 1);
			}
			if (_evt.getRenderer() instanceof PlayerRenderer _prmodel && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer.hidePlayerModelPiece(_prmodel.getModel(), 6);
			}
			if (_evt.getRenderer() instanceof PlayerRenderer _prmodel && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer.hidePlayerModelPiece(_prmodel.getModel(), 0);
			}
			if (_evt.getRenderer() instanceof PlayerRenderer _prmodel && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer.hidePlayerModelPiece(_prmodel.getModel(), 10);
			}
			if (_evt.getRenderer() instanceof PlayerRenderer _prmodel && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer.hidePlayerModelPiece(_prmodel.getModel(), 4);
			}
			if (_evt.getRenderer() instanceof PlayerRenderer _prmodel && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer.hidePlayerModelPiece(_prmodel.getModel(), 8);
			}
			if (_evt.getRenderer() instanceof PlayerRenderer _prmodel && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer.hidePlayerModelPiece(_prmodel.getModel(), 2);
			}
			if (_evt.getRenderer() instanceof PlayerRenderer _prmodel && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer.hidePlayerModelPiece(_prmodel.getModel(), 11);
			}
			if (_evt.getRenderer() instanceof PlayerRenderer _prmodel && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer.hidePlayerModelPiece(_prmodel.getModel(), 5);
			}
			if (_evt.getRenderer() instanceof PlayerRenderer _prmodel && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer.hidePlayerModelPiece(_prmodel.getModel(), 9);
			}
			if (_evt.getRenderer() instanceof PlayerRenderer _prmodel && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
				com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer.hidePlayerModelPiece(_prmodel.getModel(), 3);
			}
		}
	}
}
