package dev.ricky12awesome.mod.superstorage

import com.mojang.logging.LogUtils.getLogger
import dev.ricky12awesome.mod.superstorage.block.Blocks
import dev.ricky12awesome.mod.superstorage.item.Items
import dev.ricky12awesome.mod.superstorage.menu.Menus
import org.slf4j.Logger

object SuperStorage {
  val logger: Logger = getLogger()

  fun init() {
    Items.register()
    Blocks.register()
    Menus.register()

    println(SuperStoragePlatform.getConfigDirectory().toAbsolutePath().normalize().toString())
  }
}

