package dev.ricky12awesome.mod.superstorage

import com.mojang.logging.LogUtils.getLogger
import dev.ricky12awesome.mod.superstorage.blocks.Blocks
import dev.ricky12awesome.mod.superstorage.items.Items
import org.slf4j.Logger

object SuperStorage {
  val logger: Logger = getLogger()

  fun init() {
    Items.register()
    Blocks.register()

    println(SuperStoragePlatform.getConfigDirectory().toAbsolutePath().normalize().toString())
  }
}

