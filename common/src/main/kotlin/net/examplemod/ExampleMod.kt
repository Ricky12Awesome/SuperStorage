package net.examplemod

import com.google.common.base.Suppliers
import dev.architectury.registry.CreativeTabRegistry
import dev.architectury.registry.registries.DeferredRegister
import dev.architectury.registry.registries.Registries
import dev.architectury.registry.registries.RegistrySupplier
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import java.util.function.Supplier
import com.mojang.logging.LogUtils.getLogger
import net.minecraft.world.item.BlockItem
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.Material
import net.minecraft.world.level.material.MaterialColor
import org.slf4j.Logger

object ExampleMod {
  const val MOD_ID = "examplemod"
  val logger: Logger = getLogger()

  // We can use this if we don't want to use DeferredRegister
  @Suppress("unused")
  val REGISTRIES: Supplier<Registries> = Suppliers.memoize { Registries.get(MOD_ID) }

  // Registering a new creative tab
  private val EXAMPLE_TAB: CreativeModeTab =
    CreativeTabRegistry.create(ResourceLocation(MOD_ID, "example_tab")) { ItemStack(EXAMPLE_ITEM.get()) }
  private val ITEMS: DeferredRegister<Item> = DeferredRegister.create(MOD_ID, Registry.ITEM_REGISTRY)
  private val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(MOD_ID, Registry.BLOCK_REGISTRY)
  private val BLOCK_ITEMS: DeferredRegister<Item> = DeferredRegister.create(MOD_ID, Registry.ITEM_REGISTRY)

  private val EXAMPLE_ITEM: RegistrySupplier<Item> = ITEMS.register("example_item") {
    Item(Item.Properties().tab(EXAMPLE_TAB))
  }

  private val EXAMPLE_BLOCK: RegistrySupplier<Block> = BLOCKS.register("example_block") {
    Block(BlockBehaviour.Properties.of(Material.METAL))
  }

  private val EXAMPLE_BLOCK_ITEM: RegistrySupplier<Item> = BLOCK_ITEMS.register("example_block") {
    BlockItem(EXAMPLE_BLOCK.get(), Item.Properties().tab(EXAMPLE_TAB))
  }

  fun init() {
    ITEMS.register()
    BLOCKS.register()
    BLOCK_ITEMS.register()

    println(ExampleExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString())
  }
}

