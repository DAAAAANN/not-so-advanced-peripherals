package me.daaaaann

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object NotSoAdvancedPeripherals : ModInitializer {

    private val logger = LoggerFactory.getLogger("Not So Advanced Peripherals")

    override fun onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        logger.info("Initialised")
    }
}