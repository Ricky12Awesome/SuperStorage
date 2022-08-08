package dev.ricky12awesome.mod.superstorage.forge.datagen

import net.minecraft.data.DataGenerator
import net.minecraftforge.common.data.LanguageProvider
import dev.ricky12awesome.mod.superstorage.MOD_ID

class ChineseProvider(gen: DataGenerator) : LanguageProvider(gen, MOD_ID, "zh_cn") {
  override fun addTranslations() {
    add("chat.$MOD_ID.test", "一条聊天消息")
  }
}