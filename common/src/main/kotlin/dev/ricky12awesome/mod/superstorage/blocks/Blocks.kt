package dev.ricky12awesome.mod.superstorage.blocks

import dev.architectury.registry.registries.DeferredRegister
import dev.architectury.registry.registries.RegistrySupplier
import dev.ricky12awesome.mod.superstorage.MOD_ID
import dev.ricky12awesome.mod.superstorage.tabs.Tabs
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

  val EXAMPLE_BLOCK: RegistrySupplier<Block> = BLOCKS.register("example_block") {
    Block(BlockBehaviour.Properties.of(Material.METAL))
  }

  val EXAMPLE_BLOCK_ITEM: RegistrySupplier<Item> = BLOCK_ITEMS.register("example_block") {
    BlockItem(EXAMPLE_BLOCK.get(), Item.Properties().tab(TAB))
  }

  fun register() {
    BLOCKS.register()
    BLOCK_ITEMS.register()
  }
}
