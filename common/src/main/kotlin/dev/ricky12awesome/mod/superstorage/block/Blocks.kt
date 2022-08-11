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

@Suppress("MemberVisibilityCanBePrivate")
object Blocks {
  val TAB get() = Tabs.TAB

  val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(MOD_ID, Registry.BLOCK_REGISTRY)
  val BLOCK_ITEMS: DeferredRegister<Item> = DeferredRegister.create(MOD_ID, Registry.ITEM_REGISTRY)

  val CONTROLLER_BLOCK: RegistrySupplier<ControllerBlock> = BLOCKS.register("controller", ::ControllerBlock)
  val CONTROLLER_BLOCK_ITEM: RegistrySupplier<BlockItem> = BLOCK_ITEMS.register("controller") {
    BlockItem(CONTROLLER_BLOCK.get(), Item.Properties().tab(TAB))
  }

  val MODULE_1_BLOCK: RegistrySupplier<ModuleBlock> = BLOCKS.register("module_1") {
    ModuleBlock(ModuleBlock.Tier.TIER_1)
  }

  val MODULE_2_BLOCK: RegistrySupplier<ModuleBlock> = BLOCKS.register("module_2") {
    ModuleBlock(ModuleBlock.Tier.TIER_2)
  }

  val MODULE_3_BLOCK: RegistrySupplier<ModuleBlock> = BLOCKS.register("module_3") {
    ModuleBlock(ModuleBlock.Tier.TIER_3)
  }

  val MODULE_4_BLOCK: RegistrySupplier<ModuleBlock> = BLOCKS.register("module_4") {
    ModuleBlock(ModuleBlock.Tier.TIER_4)
  }

  val MODULE_5_BLOCK: RegistrySupplier<ModuleBlock> = BLOCKS.register("module_5") {
    ModuleBlock(ModuleBlock.Tier.TIER_5)
  }

  val MODULE_1_BLOCK_ITEM: RegistrySupplier<BlockItem> = BLOCK_ITEMS.register("module_1") {
    ModuleBlockItem(MODULE_1_BLOCK.get())
  }

  val MODULE_2_BLOCK_ITEM: RegistrySupplier<BlockItem> = BLOCK_ITEMS.register("module_2") {
    ModuleBlockItem(MODULE_2_BLOCK.get())
  }

  val MODULE_3_BLOCK_ITEM: RegistrySupplier<BlockItem> = BLOCK_ITEMS.register("module_3") {
    ModuleBlockItem(MODULE_3_BLOCK.get())
  }

  val MODULE_4_BLOCK_ITEM: RegistrySupplier<BlockItem> = BLOCK_ITEMS.register("module_4") {
    ModuleBlockItem(MODULE_4_BLOCK.get())
  }

  val MODULE_5_BLOCK_ITEM: RegistrySupplier<BlockItem> = BLOCK_ITEMS.register("module_5") {
    ModuleBlockItem(MODULE_5_BLOCK.get())
  }

  fun register() {
    BLOCKS.register()
    BLOCK_ITEMS.register()
    BlockEntities.register()
  }
}
