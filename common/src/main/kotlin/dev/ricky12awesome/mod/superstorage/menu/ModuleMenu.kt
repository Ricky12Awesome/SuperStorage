package dev.ricky12awesome.mod.superstorage.menu

import dev.ricky12awesome.mod.superstorage.container.ModuleContainer
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.inventory.Slot
import net.minecraft.world.item.ItemStack

class ModuleMenu(
  id: Int,
  inventory: Inventory,
  private val container: ModuleContainer = ModuleContainer.empty()
) : AbstractContainerMenu(Menus.MODULE_MENU.get(), id) {

  init {
    container.startOpen(inventory.player)
    val rows = 1
    val k = (rows - 4) * 18;

    for (l in 0 until rows) {
      for (m in 0 until 8) {
        addSlot(ModuleSlot(container, m + l * 9, 8 + m * 18, 18 + l * 18))
      }
    }

    for (l in 0 until 3) {
      for (m in 0 until 9) {
        addSlot(Slot(inventory, m + l * 9 + 9, 8 + m * 18, 103 + l * 18 + k))
      }
    }

    for (l in 0 until 9) {
      addSlot(Slot(inventory, l, 8 + l * 18, 161 + k))
    }
  }

  override fun quickMoveStack(player: Player, slot: Int): ItemStack {
    return ItemStack.EMPTY
  }

  override fun stillValid(player: Player): Boolean {
    return container.stillValid(player)
  }

  override fun removed(player: Player) {
    super.removed(player)
    container.stopOpen(player)
  }

  class ModuleSlot(
    private val _container: ModuleContainer,
    slot: Int,
    x: Int,
    y: Int
  ) : Slot(_container, slot, x, y) {
    override fun mayPlace(itemStack: ItemStack): Boolean {
      return false
    }

    override fun mayPickup(player: Player): Boolean {
      return false
    }

    override fun allowModification(player: Player): Boolean {
      return false
    }

    override fun getMaxStackSize(): Int {
      return _container.maxStackSize
    }

    override fun getMaxStackSize(item: ItemStack): Int {
      return _container.getMaxStackSize(item)
    }
  }
}