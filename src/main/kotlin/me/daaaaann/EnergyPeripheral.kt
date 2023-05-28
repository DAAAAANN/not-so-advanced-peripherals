package me.daaaaann

import dan200.computercraft.api.lua.LuaFunction
import dan200.computercraft.api.lua.MethodResult
import dan200.computercraft.api.peripheral.IPeripheral
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World
import team.reborn.energy.api.EnergyStorage

class EnergyPeripheral : IPeripheral {

    private final val world: World
    private final val pos: BlockPos
    private final val side: Direction

    constructor(world: World, pos: BlockPos, side: Direction) {
        this.world = world
        this.pos = pos
        this.side = side
    }

    override fun equals(iPeripheral: IPeripheral?): Boolean {
        return this == iPeripheral
    }

    override fun getType(): String {
        return "energy_storage"
    }

    @LuaFunction(mainThread = true)
    fun getEnergy(): MethodResult {
        return MethodResult.of(EnergyStorage.SIDED.find(world, pos, side)?.amount)
    }

    @LuaFunction(mainThread = true)
    fun getEnergyCapacity(): MethodResult {
        return MethodResult.of(EnergyStorage.SIDED.find(world, pos, side)?.capacity)
    }
}