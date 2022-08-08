package dev.ricky12awesome.mod.superstorage.block.entity

import net.minecraft.core.BlockPos
import net.minecraft.nbt.CompoundTag
import net.minecraft.nbt.IntTag
import net.minecraft.network.protocol.Packet
import net.minecraft.network.protocol.game.ClientGamePacketListener
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState

class ControllerBlockEntity(pos: BlockPos, state: BlockState) :
  BlockEntity(BlockEntities.CONTROLLER_BLOCK_ENTITY.get(), pos, state) {

  var number = 0

  override fun saveAdditional(tag: CompoundTag) {
    tag.put("number", IntTag.valueOf(number))

    super.saveAdditional(tag)
  }

  override fun load(compoundTag: CompoundTag) {
    super.load(compoundTag)
    number = compoundTag.getInt("number")
  }

  override fun getUpdatePacket(): Packet<ClientGamePacketListener>? {
    return ClientboundBlockEntityDataPacket.create(this)
  }

  override fun getUpdateTag(): CompoundTag {
    return saveWithFullMetadata()
  }
}