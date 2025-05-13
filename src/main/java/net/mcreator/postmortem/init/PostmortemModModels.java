
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.postmortem.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.postmortem.client.model.Modelzombie;
import net.mcreator.postmortem.client.model.Modelwither_skeleton;
import net.mcreator.postmortem.client.model.Modelstray_outer;
import net.mcreator.postmortem.client.model.Modelstray;
import net.mcreator.postmortem.client.model.Modelskeleton;
import net.mcreator.postmortem.client.model.Modelfloating_skull;
import net.mcreator.postmortem.client.model.Modeldrowned_outer;
import net.mcreator.postmortem.client.model.Modeldrowned;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class PostmortemModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modeldrowned.LAYER_LOCATION, Modeldrowned::createBodyLayer);
		event.registerLayerDefinition(Modelfloating_skull.LAYER_LOCATION, Modelfloating_skull::createBodyLayer);
		event.registerLayerDefinition(Modelzombie.LAYER_LOCATION, Modelzombie::createBodyLayer);
		event.registerLayerDefinition(Modeldrowned_outer.LAYER_LOCATION, Modeldrowned_outer::createBodyLayer);
		event.registerLayerDefinition(Modelstray_outer.LAYER_LOCATION, Modelstray_outer::createBodyLayer);
		event.registerLayerDefinition(Modelskeleton.LAYER_LOCATION, Modelskeleton::createBodyLayer);
		event.registerLayerDefinition(Modelstray.LAYER_LOCATION, Modelstray::createBodyLayer);
		event.registerLayerDefinition(Modelwither_skeleton.LAYER_LOCATION, Modelwither_skeleton::createBodyLayer);
	}
}
