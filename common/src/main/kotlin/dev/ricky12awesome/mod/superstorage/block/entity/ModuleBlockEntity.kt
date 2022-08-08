package dev.ricky12awesome.mod.superstorage.block.entity

import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState

class ModuleBlockEntity(pos: BlockPos, state: BlockState) :
  BlockEntity(BlockEntities.MODULE_BLOCK_ENTITY.get(), pos, state) {

}