package dev.ricky12awesome.mod.superstorage

import dev.architectury.hooks.block.BlockEntityHooks
import net.minecraft.world.level.block.entity.BlockEntity

fun BlockEntity.sync() {
  BlockEntityHooks.syncData(this)
}