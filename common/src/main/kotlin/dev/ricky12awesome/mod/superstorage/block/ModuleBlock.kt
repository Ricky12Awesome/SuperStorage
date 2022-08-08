package dev.ricky12awesome.mod.superstorage.block

import dev.ricky12awesome.mod.superstorage.block.entity.ModuleBlockEntity
import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.EntityBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.material.Material

class ModuleBlock : Block(Properties.of(Material.METAL)), EntityBlock {
  override fun newBlockEntity(blockPos: BlockPos, blockState: BlockState): ModuleBlockEntity {
    return ModuleBlockEntity(blockPos, blockState)
  }
}