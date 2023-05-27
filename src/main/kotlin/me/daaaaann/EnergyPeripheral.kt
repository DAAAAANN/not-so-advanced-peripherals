package me.daaaaann

import dan200.computercraft.api.lua.LuaFunction
import dan200.computercraft.api.lua.MethodResult
import dan200.computercraft.api.peripheral.IPeripheral
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class EnergyPeripheral : IPeripheral {

    private final val world: World
    private final val pos: BlockPos

    constructor(world: World, pos: BlockPos) {
        this.world = world
        this.pos = pos
    }

    override fun equals(iPeripheral: IPeripheral?): Boolean {
        return this == iPeripheral
    }

    override fun getType(): String {
        return "energy"
    }

    @LuaFunction
    fun test(): MethodResult {
        return MethodResult.of(true, "Wow it worked!")
    }
}