package dev.ricky12awesome.mod.superstorage.fabric

import net.fabricmc.loader.api.FabricLoader
import java.nio.file.Path
import dev.ricky12awesome.mod.superstorage.SuperStoragePlatform

object SuperStoragePlatformImpl {
  /**
   * This is our actual method to [SuperStoragePlatform.getConfigDirectory].
   */
  @JvmStatic
  fun getConfigDirectory(): Path = FabricLoader.getInstance().configDir
}