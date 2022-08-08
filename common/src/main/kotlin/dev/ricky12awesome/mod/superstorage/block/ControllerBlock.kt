package dev.ricky12awesome.mod.superstorage.block

import dev.ricky12awesome.mod.superstorage.block.entity.ControllerBlockEntity
import dev.ricky12awesome.mod.superstorage.sync
import net.minecraft.core.BlockPos
import net.minecraft.network.chat.Component
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.EntityBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.material.Material
import net.minecraft.world.phys.BlockHitResult

class ControllerBlock : Block(Properties.of(Material.METAL)), EntityBlock {

  override fun newBlockEntity(blockPos: BlockPos, blockState: BlockState): ControllerBlockEntity {
    return ControllerBlockEntity(blockPos, blockState)
  }

  @Deprecated("idk why this is deprecated")
  override fun use(
    blockState: BlockState,
    level: Level,
    blockPos: BlockPos,
    player: Player,
    interactionHand: InteractionHand,
    blockHitResult: BlockHitResult
  ): InteractionResult {
    if (level.isClientSide) return InteractionResult.SUCCESS

    val entity = level.getBlockEntity(blockPos) as ControllerBlockEntity

    entity.sync()
    entity.number++
    entity.setChanged()
    entity.sync()

    player.displayClientMessage(Component.literal("Number: ${entity.number}"), true)

    return InteractionResult.SUCCESS
  }
}