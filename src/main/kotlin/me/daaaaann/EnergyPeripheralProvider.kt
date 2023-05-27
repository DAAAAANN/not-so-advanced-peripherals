package me.daaaaann

import dan200.computercraft.api.peripheral.IPeripheral
import dan200.computercraft.api.peripheral.IPeripheralProvider
import net.minecraft.block.entity.BlockEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World
import techreborn.blockentity.machine.GenericMachineBlockEntity
import techreborn.init.TRContent.MachineBlocks

class EnergyPeripheralProvider : IPeripheralProvider {
    override fun getPeripheral(world: World, pos: BlockPos, side: Direction): IPeripheral? {
        val block: BlockEntity? = world.getBlockEntity(pos)

        if (block is GenericMachineBlockEntity) {
            return EnergyPeripheral(world, pos)
        }

        return null;
    }
}