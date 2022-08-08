package dev.ricky12awesome.mod.superstorage.quilt

import dev.ricky12awesome.mod.superstorage.SuperStorage.init
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer

@Suppress("unused")
class SuperStorageQuilt : ModInitializer {
  override fun onInitialize(mod: ModContainer) {
    init()
  }
}