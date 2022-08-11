package dev.ricky12awesome.mod.superstorage.menu

import dev.architectury.registry.menu.MenuRegistry
import dev.architectury.registry.registries.DeferredRegister
import dev.architectury.registry.registries.RegistrySupplier
import dev.ricky12awesome.mod.superstorage.MOD_ID
import net.minecraft.core.Registry
import net.minecraft.world.inventory.MenuType

object Menus {
  val MENUS: DeferredRegister<MenuType<*>> = DeferredRegister.create(MOD_ID, Registry.MENU_REGISTRY)

  val MODULE_MENU: RegistrySupplier<MenuType<ModuleMenu>> = MENUS.register("module_menu") {
    MenuType(::ModuleMenu)
  }

  fun register() {
    MODULE_MENU.listen {
      MenuRegistry.registerScreenFactory(it, ::ModuleMenuScreen)
    }

    MENUS.register()
  }
}