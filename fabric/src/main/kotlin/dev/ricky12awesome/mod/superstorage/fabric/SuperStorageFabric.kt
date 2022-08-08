package dev.ricky12awesome.mod.superstorage.fabric

import dev.ricky12awesome.mod.superstorage.SuperStorage.init
import net.fabricmc.api.ModInitializer

class SuperStorageFabric : ModInitializer {
  override fun onInitialize() {
    init()
  }
}