package dev.ricky12awesome.mod.superstorage.container

import dev.ricky12awesome.mod.superstorage.block.ModuleBlock
import dev.ricky12awesome.mod.superstorage.menu.ModuleMenu
import net.minecraft.core.NonNullList
import net.minecraft.network.chat.Component
import net.minecraft.world.Container
import net.minecraft.world.ContainerHelper
import net.minecraft.world.MenuProvider
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.item.ItemStack

interface ModuleContainer : Container, MenuProvider {
  val items: NonNullList<ItemStack>
  val tier: ModuleBlock.Tier

  override fun getContainerSize(): Int {
    return items.size
  }

  fun getMaxStackSize(base: Int) = base * tier.stackMultiplier
  fun getMaxStackSize(item: ItemStack) = getMaxStackSize(item.maxStackSize) * tier.stackMultiplier

  override fun getMaxStackSize(): Int {2
    return getMaxStackSize(super.getMaxStackSize())
  }

  override fun isEmpty(): Boolean {
    return items.all(ItemStack::isEmpty)
  }

  override fun getItem(slot: Int): ItemStack {
    return items[slot]
  }

  override fun removeItem(slot: Int, amount: Int): ItemStack {
    val result = ContainerHelper.removeItem(items, slot, amount)

    if (!result.isEmpty) setChanged()

    return result
  }

  override fun setItem(slot: Int, item: ItemStack) {
    items[slot] = item

    val max = getMaxStackSize(item.maxStackSize)

    if (item.count > max) item.count = max
  }

  override fun clearContent() {
    items.clear()
  }

  override fun removeItemNoUpdate(slot: Int): ItemStack {
    return items.set(slot, ItemStack.EMPTY)
  }

  override fun stillValid(player: Player): Boolean {
    return true
  }

  override fun createMenu(id: Int, inventory: Inventory, player: Player): AbstractContainerMenu {
    return ModuleMenu(id, inventory, this)
  }

  override fun getDisplayName(): Component {
    return Component.translatable(tier.translateLocation)
  }

  companion object {
    private class EmptyModuleContainer : ModuleContainer {
      override val items: NonNullList<ItemStack> = NonNullList.withSize(8, ItemStack.EMPTY)
      override val tier: ModuleBlock.Tier = ModuleBlock.Tier.TIER_1

      override fun setChanged() {}
    }

    fun empty(): ModuleContainer = EmptyModuleContainer()
  }
}
