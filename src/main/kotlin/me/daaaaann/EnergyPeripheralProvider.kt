package me.daaaaann

import dan200.computercraft.api.peripheral.IPeripheral
import dan200.computercraft.api.peripheral.IPeripheralProvider
import dan200.computercraft.shared.peripheral.generic.GenericPeripheralProvider
import net.minecraft.block.entity.BlockEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World
import org.slf4j.LoggerFactory
import team.reborn.energy.api.EnergyStorage
import techreborn.blockentity.machine.GenericMachineBlockEntity
import techreborn.blockentity.storage.energy.EnergyStorageBlockEntity
import techreborn.init.TRContent.MachineBlocks

class EnergyPeripheralProvider : IPeripheralProvider {

    private val logger = LoggerFactory.getLogger("Not So Advanced Peripherals")

    override fun getPeripheral(world: World, pos: BlockPos, side: Direction): IPeripheral? {

        val energyStorage: EnergyStorage? = EnergyStorage.SIDED.find(world, pos, side)

        energyStorage.let {
            if (energyStorage!!.supportsInsertion() || energyStorage.supportsExtraction()) {
                logger.info("Found one!")
                return EnergyPeripheral(world, pos, side)
            }
        }

        return null;
    }
}