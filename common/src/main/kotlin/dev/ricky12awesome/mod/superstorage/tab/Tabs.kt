package dev.ricky12awesome.mod.superstorage.tab

import dev.architectury.registry.CreativeTabRegistry
import dev.ricky12awesome.mod.superstorage.MOD_ID
import dev.ricky12awesome.mod.superstorage.item.Items
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack

object Tabs {
  val EXAMPLE_TAB: CreativeModeTab =
    CreativeTabRegistry.create(
      ResourceLocation(
        MOD_ID,
        "example_tab"
      )
    ) {
      ItemStack(Items.EXAMPLE_ITEM.get())
    }
}