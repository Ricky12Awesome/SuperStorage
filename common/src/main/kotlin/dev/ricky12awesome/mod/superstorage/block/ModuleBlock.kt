package dev.ricky12awesome.mod.superstorage.block

import dev.ricky12awesome.mod.superstorage.block.entity.ModuleBlockEntity
import net.minecraft.core.BlockPos
import net.minecraft.util.StringRepresentable
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.EntityBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.EnumProperty
import net.minecraft.world.level.material.Material

class ModuleBlock(val tier: Tier) : Block(Properties.of(Material.METAL)), EntityBlock {

  init {
    registerDefaultState(stateDefinition.any().setValue(TIER, tier))
  }

  override fun createBlockStateDefinition(builder: StateDefinition.Builder<Block, BlockState>) {
    builder.add(TIER)
  }

  override fun newBlockEntity(blockPos: BlockPos, blockState: BlockState): ModuleBlockEntity {
    return ModuleBlockEntity(blockPos, blockState)
  }

  companion object {
    val TIER: EnumProperty<Tier> = EnumProperty.create("tier", Tier::class.java)
  }

  enum class Tier : StringRepresentable {
    TIER_1, TIER_2, TIER_3, TIER_4, TIER_5;

    override fun getSerializedName(): String {
      return when (this) {
        TIER_1 -> "1"
        TIER_2 -> "2"
        TIER_3 -> "3"
        TIER_4 -> "4"
        TIER_5 -> "5"
      }
    }
  }
}