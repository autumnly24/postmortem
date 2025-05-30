package net.mcreator.postmortem.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.postmortem.world.inventory.ImmortalityContractAgreementMenu;
import net.mcreator.postmortem.network.ImmortalityContractAgreementButtonMessage;
import net.mcreator.postmortem.PostmortemMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ImmortalityContractAgreementScreen extends AbstractContainerScreen<ImmortalityContractAgreementMenu> {
	private final static HashMap<String, Object> guistate = ImmortalityContractAgreementMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_sign_contract_button;

	public ImmortalityContractAgreementScreen(ImmortalityContractAgreementMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 144;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("postmortem:textures/screens/immortality_contract_agreement.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("postmortem:textures/screens/contract_gui_warning.png"), this.leftPos + -1, this.topPos + -11, 0, 0, 146, 180, 146, 180);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		imagebutton_sign_contract_button = new ImageButton(this.leftPos + 35, this.topPos + 115, 69, 17, 0, 0, 17, new ResourceLocation("postmortem:textures/screens/atlas/imagebutton_sign_contract_button.png"), 69, 34, e -> {
			if (true) {
				PostmortemMod.PACKET_HANDLER.sendToServer(new ImmortalityContractAgreementButtonMessage(0, x, y, z));
				ImmortalityContractAgreementButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_sign_contract_button", imagebutton_sign_contract_button);
		this.addRenderableWidget(imagebutton_sign_contract_button);
	}
}
