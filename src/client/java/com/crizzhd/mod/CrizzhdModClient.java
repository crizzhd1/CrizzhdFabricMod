package com.crizzhd.mod;
import com.crizzhd.mod.keybinds.ModKeyBinds;
import com.crizzhd.mod.overlay.OverLay;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.render.entity.ChickenEntityRenderer;


public class CrizzhdModClient implements ClientModInitializer {
	ModKeyBinds modKeyBinds = new ModKeyBinds();

	@Override
	public void onInitializeClient() {
		modKeyBinds.register();
		HudRenderCallback.EVENT.register(new OverLay());
	}
}