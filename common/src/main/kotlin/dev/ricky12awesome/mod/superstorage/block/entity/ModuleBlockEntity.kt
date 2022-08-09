package dev.ricky12awesome.mod.superstorage.block.entity

import net.minecraft.core.BlockPos
import net.minecraft.nbt.CompoundTag
import net.minecraft.network.protocol.Packet
import net.minecraft.network.protocol.game.ClientGamePacketListener
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState

class ModuleBlockEntity(pos: BlockPos, state: BlockState) :
  BlockEntity(BlockEntities.MODULE_BLOCK_ENTITY.get(), pos, state) {

  override fun saveAdditional(tag: CompoundTag) {
    super.saveAdditional(tag)
  }

  override fun load(compoundTag: CompoundTag) {
    super.load(compoundTag)
  }

  override fun getUpdatePacket(): Packet<ClientGamePacketListener>? {
    return ClientboundBlockEntityDataPacket.create(this)
  }

  override fun getUpdateTag(): CompoundTag {
    return saveWithFullMetadata()
  }
}