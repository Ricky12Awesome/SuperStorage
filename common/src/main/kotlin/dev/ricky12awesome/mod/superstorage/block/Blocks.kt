package dev.ricky12awesome.mod.superstorage.block

import dev.architectury.registry.registries.DeferredRegister
import dev.architectury.registry.registries.RegistrySupplier
import dev.ricky12awesome.mod.superstorage.MOD_ID
import dev.ricky12awesome.mod.superstorage.block.entity.BlockEntities
import dev.ricky12awesome.mod.superstorage.tab.Tabs
import net.minecraft.core.Registry
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.Material

@Suppress("MemberVisibilityCanBePrivate")
object Blocks {
  private val TAB get() = Tabs.EXAMPLE_TAB

  val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(MOD_ID, Registry.BLOCK_REGISTRY)
  val BLOCK_ITEMS: DeferredRegister<Item> = DeferredRegister.create(MOD_ID, Registry.ITEM_REGISTRY)

  val CONTROLLER_BLOCK: RegistrySupplier<ControllerBlock> = BLOCKS.register("controller", ::ControllerBlock)
  val CONTROLLER_BLOCK_ITEM: RegistrySupplier<BlockItem> = BLOCK_ITEMS.register("controller") {
    BlockItem(CONTROLLER_BLOCK.get(), Item.Properties().tab(TAB))
  }

  val MODULE_BLOCK: RegistrySupplier<ModuleBlock> = BLOCKS.register("module", ::ModuleBlock)
  val MODULE_BLOCK_ITEM: RegistrySupplier<BlockItem> = BLOCK_ITEMS.register("module") {
    BlockItem(MODULE_BLOCK.get(), Item.Properties().tab(TAB))
  }

  fun register() {
    BLOCKS.register()
    BLOCK_ITEMS.register()
    BlockEntities.register()
  }
}
