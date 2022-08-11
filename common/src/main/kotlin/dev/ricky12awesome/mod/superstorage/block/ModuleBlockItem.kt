package dev.ricky12awesome.mod.superstorage.block

import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.Level

class ModuleBlockItem(block: ModuleBlock) : BlockItem(block, Properties().tab(Blocks.TAB)) {

  private val tier = block.tier

  override fun appendHoverText(
    itemStack: ItemStack,
    level: Level?,
    list: MutableList<Component>,
    tooltipFlag: TooltipFlag
  ) {
    // TODO: get values from config
    val slots = 8
    val times = when (tier) {
      ModuleBlock.Tier.TIER_0 -> 0
      ModuleBlock.Tier.TIER_1 -> 8
      ModuleBlock.Tier.TIER_2 -> 16
      ModuleBlock.Tier.TIER_3 -> 32
      ModuleBlock.Tier.TIER_4 -> 64
      ModuleBlock.Tier.TIER_5 -> 128
    }

    list += Component
      .translatable("item.super_storage.module.description.sm").withStyle(ChatFormatting.YELLOW)
      .append(Component.literal(": ").withStyle(ChatFormatting.DARK_GRAY))
      .append(Component.literal(times.toString()).withStyle(ChatFormatting.WHITE))

    list += Component
      .translatable("item.super_storage.module.description.slots").withStyle(ChatFormatting.YELLOW)
      .append(Component.literal(": ").withStyle(ChatFormatting.DARK_GRAY))
      .append(Component.literal(slots.toString()).withStyle(ChatFormatting.WHITE))

    super.appendHoverText(itemStack, level, list, tooltipFlag)
  }
}