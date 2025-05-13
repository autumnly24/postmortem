package net.mcreator.postmortem.procedures;

import org.lwjgl.glfw.GLFW;

import net.mcreator.postmortem.init.PostmortemModKeyMappings;

public class ReturnPossessKeybindProcedure {
	public static String execute() {
		String temptext = "";
		temptext = "" + GLFW.glfwGetKeyName(PostmortemModKeyMappings.POSSESS_KEYBIND.getKey().getValue(), GLFW.glfwGetKeyScancode(PostmortemModKeyMappings.POSSESS_KEYBIND.getKey().getValue()));
		return (temptext).toUpperCase();
	}
}
