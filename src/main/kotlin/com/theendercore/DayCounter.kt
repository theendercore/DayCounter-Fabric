package com.theendercore

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
import net.minecraft.client.MinecraftClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class DayCounter : ModInitializer {

    override fun onInitialize() {
        LOGGER.info("hi $MODID")
        HudRenderCallback.EVENT.register { matrixStack, _ ->
            val client = MinecraftClient.getInstance()
            client.textRenderer.draw(
                matrixStack,
                "hello",
                client.window.width / 2 + 100f,
                client.window.height / 2 - 20f,
                0xffffff
            )

        }
    }

    companion object {
        const val MODID: String = "day_counter"
        val LOGGER: Logger = LoggerFactory.getLogger(MODID)
//        fun id(path: String): Identifier = Identifier(MODID, path)
    }
}