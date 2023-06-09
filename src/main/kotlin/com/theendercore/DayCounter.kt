package com.theendercore

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
import net.minecraft.client.MinecraftClient
import net.minecraft.client.util.math.MatrixStack

class DayCounter : ModInitializer {
    override fun onInitialize() {
        HudRenderCallback.EVENT.register { matrixStack: MatrixStack, _: Float ->
            val client = MinecraftClient.getInstance()
            if (!(client.player?.isSpectator())!!) client.textRenderer.drawWithShadow(
                matrixStack,
                String.format("Day %d", client.world?.timeOfDay?.div(24000) ?: 0),
                (client.window.scaledWidth / 2f) + 95f,
                client.window.scaledHeight - 15f,
                0xffffff
            )
        }
    }
}