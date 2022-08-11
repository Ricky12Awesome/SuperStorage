package dev.ricky12awesome.mod.superstorage.block.entity

import dev.ricky12awesome.mod.superstorage.block.ModuleBlock
import dev.ricky12awesome.mod.superstorage.container.ModuleContainer
import net.minecraft.core.BlockPos
import net.minecraft.core.NonNullList
import net.minecraft.nbt.CompoundTag
import net.minecraft.nbt.ListTag
import net.minecraft.network.protocol.Packet
import net.minecraft.network.protocol.game.ClientGamePacketListener
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState

class ModuleBlockEntity(pos: BlockPos, state: BlockState) :
  BlockEntity(BlockEntities.MODULE_BLOCK_ENTITY.get(), pos, state),
  ModuleContainer {
  override val items: NonNullList<ItemStack> = NonNullList.withSize(8, ItemStack.EMPTY)
  override val tier: ModuleBlock.Tier = ModuleBlock.Tier.TIER_5

  // Read
  override fun load(tag: CompoundTag) {
    super.load(tag)

    val list = tag.getList("Items", ListTag.TAG_COMPOUND.toInt())

    for (i in list.indices) {
      val itemTag = list.getCompound(i)
      val slot = itemTag.getInt("Slot")
      val count = itemTag.getInt("Count")
      val item = ItemStack.of(itemTag)
      item.count = count
      items[slot] = item
    }
  }

  // Write
  override fun saveAdditional(tag: CompoundTag) {
    val list = ListTag()

    items.forEachIndexed { slot, item ->
      if (item.isEmpty) return@forEachIndexed

      val itemTag = CompoundTag()

      item.save(itemTag)
      itemTag.putInt("Count", item.count)
      itemTag.putInt("Slot", slot)
      list += itemTag
    }

    tag.put("Items", list)

    super.saveAdditional(tag)
  }

  override fun getUpdatePacket(): Packet<ClientGamePacketListener>? {
    return ClientboundBlockEntityDataPacket.create(this)
  }

  override fun getUpdateTag(): CompoundTag {
    return saveWithFullMetadata()
  }
}