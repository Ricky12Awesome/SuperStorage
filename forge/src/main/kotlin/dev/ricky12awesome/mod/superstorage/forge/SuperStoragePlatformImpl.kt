package dev.ricky12awesome.mod.superstorage.forge

import net.minecraftforge.fml.loading.FMLPaths
import java.nio.file.Path
import dev.ricky12awesome.mod.superstorage.SuperStoragePlatform

@Suppress("unused")
object SuperStoragePlatformImpl {
  /**
   * This is our actual method to [SuperStoragePlatform.getConfigDirectory].
   */
  @JvmStatic
  fun getConfigDirectory(): Path = FMLPaths.CONFIGDIR.get()
}