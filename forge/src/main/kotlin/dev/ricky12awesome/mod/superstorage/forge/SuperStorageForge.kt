package dev.ricky12awesome.mod.superstorage.forge

import dev.architectury.platform.forge.EventBuses
import dev.ricky12awesome.mod.superstorage.SuperStorage.init
import dev.ricky12awesome.mod.superstorage.MOD_ID
import dev.ricky12awesome.mod.superstorage.forge.datagen.ChineseProvider
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext

@Mod(MOD_ID)
class SuperStorageForge {
  init {
    // Submit our event bus to let architectury register our content on the right time
    EventBuses.registerModEventBus(MOD_ID, FMLJavaModLoadingContext.get().modEventBus)
    FMLJavaModLoadingContext.get().modEventBus.addListener(this::onGatherData)
    init()
  }

  @Deprecated("", ReplaceWith("onGatherDataEvent()"))
  private fun onGatherData(event: GatherDataEvent) {
    val gen = event.generator
    gen.addProvider(true, ChineseProvider(gen))
  }
}