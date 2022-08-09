package dev.ricky12awesome.mod.superstorage.block.entity

import com.mojang.datafixers.types.constant.EmptyPart
import dev.architectury.registry.registries.DeferredRegister
import dev.architectury.registry.registries.RegistrySupplier
import dev.ricky12awesome.mod.superstorage.MOD_ID
import dev.ricky12awesome.mod.superstorage.block.Blocks
import net.minecraft.core.Registry
import net.minecraft.world.level.block.entity.BlockEntityType

@Suppress("MemberVisibilityCanBePrivate")
object BlockEntities {
  val BLOCK_ENTITIES: DeferredRegister<BlockEntityType<*>> =
    DeferredRegister.create(MOD_ID, Registry.BLOCK_ENTITY_TYPE_REGISTRY)

  val CONTROLLER_BLOCK_ENTITY: RegistrySupplier<BlockEntityType<*>> =
    BLOCK_ENTITIES.register("controller") {
      BlockEntityType.Builder.of(
        BlockEntityType.BlockEntitySupplier(::ControllerBlockEntity),
        Blocks.CONTROLLER_BLOCK.get()
      ).build(EmptyPart())
    }

  val MODULE_BLOCK_ENTITY: RegistrySupplier<BlockEntityType<*>> =
    BLOCK_ENTITIES.register("module") {
      BlockEntityType.Builder.of(
        BlockEntityType.BlockEntitySupplier(::ModuleBlockEntity),
        Blocks.MODULE_1_BLOCK.get()
      ).build(EmptyPart())
    }

  fun register() {
    BLOCK_ENTITIES.register()
  }
}