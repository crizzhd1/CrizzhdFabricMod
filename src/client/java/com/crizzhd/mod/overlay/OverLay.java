package com.crizzhd.mod.overlay;

import com.crizzhd.mod.CrizzhdMod;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class OverLay implements HudRenderCallback {
    private Identifier idk = new Identifier(CrizzhdMod.ModId,
            "textures/item/texture.png");
    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        int x = 0;
        int y = 0;

        MinecraftClient client = MinecraftClient.getInstance();
        if(client != null){
            int width = client.getWindow().getScaledWidth();
            int hight = client.getWindow().getScaledHeight();

            x = width / 2;
            y = hight;
        }

        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
        RenderSystem.setShaderTexture(0,idk);
        for (int i =0; i < 10; i++){
            DrawableHelper.drawTexture(matrixStack,x -94+ (i * 9),y - 54,0,0,12,12,12,12);
        }
    }
}
