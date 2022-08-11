package dev.ricky12awesome.mod.superstorage.block

import dev.ricky12awesome.mod.superstorage.block.entity.ModuleBlockEntity
import net.minecraft.core.BlockPos
import net.minecraft.util.StringRepresentable
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.EntityBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.material.Material
import net.minecraft.world.phys.BlockHitResult

class ModuleBlock(val tier: Tier) : Block(Properties.of(Material.METAL)), EntityBlock {
  override fun newBlockEntity(blockPos: BlockPos, blockState: BlockState): ModuleBlockEntity {
    return ModuleBlockEntity(blockPos, blockState)
  }

  @Deprecated("use")
  override fun use(
    blockState: BlockState,
    level: Level,
    blockPos: BlockPos,
    player: Player,
    interactionHand: InteractionHand,
    blockHitResult: BlockHitResult
  ): InteractionResult {
    if (level.isClientSide) return InteractionResult.SUCCESS

    val container = level.getBlockEntity(blockPos) as ModuleBlockEntity

    player.openMenu(container)

    return InteractionResult.SUCCESS
  }

  enum class Tier(
    val stackMultiplier: Int,
    val translateLocation: String,
    private val _name: String
  ) : StringRepresentable {
    TIER_0(0, "block.super_storage.module_0", "0"),
    TIER_1(8, "block.super_storage.module_1", "1"),
    TIER_2(16, "block.super_storage.module_2", "2"),
    TIER_3(32, "block.super_storage.module_3", "3"),
    TIER_4(64, "block.super_storage.module_4", "4"),
    TIER_5(128, "block.super_storage.module_5", "5");

    override fun getSerializedName(): String = this._name
  }
}