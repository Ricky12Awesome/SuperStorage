package dev.ricky12awesome.mod.superstorage.item

import dev.architectury.registry.registries.DeferredRegister
import dev.architectury.registry.registries.RegistrySupplier
import dev.ricky12awesome.mod.superstorage.MOD_ID
import dev.ricky12awesome.mod.superstorage.tab.Tabs
import net.minecraft.core.Registry
import net.minecraft.world.item.Item

@Suppress("MemberVisibilityCanBePrivate")
object Items {
  val ITEMS: DeferredRegister<Item> = DeferredRegister.create(MOD_ID, Registry.ITEM_REGISTRY)

  val EXAMPLE_ITEM: RegistrySupplier<Item> = ITEMS.register("example_item") {
    Item(Item.Properties().tab(Tabs.TAB))
  }

  fun register() {
    ITEMS.register()
  }
}