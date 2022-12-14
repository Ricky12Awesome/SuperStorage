package dev.ricky12awesome.mod.superstorage.menu

import com.mojang.blaze3d.systems.RenderSystem
import com.mojang.blaze3d.vertex.PoseStack
import dev.ricky12awesome.mod.superstorage.container.ModuleContainer
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
import net.minecraft.client.renderer.GameRenderer
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.item.ItemStack

class ModuleMenuScreen(
  menu: ModuleMenu,
  inventory: Inventory,
  name: Component
) : AbstractContainerScreen<ModuleMenu>(menu, inventory, name) {
  private val containerRows = 1

  init {
    passEvents = false
    imageHeight = 114 + containerRows * 18
    inventoryLabelY = imageHeight - 94
  }

  override fun render(poseStack: PoseStack, i: Int, j: Int, f: Float) {
    this.renderBackground(poseStack)
    super.render(poseStack, i, j, f)
    this.renderTooltip(poseStack, i, j)
  }

  override fun getTooltipFromItem(itemStack: ItemStack): MutableList<Component> {
    val lines = super.getTooltipFromItem(itemStack)
    val container = hoveredSlot?.container

    if (container is ModuleContainer) {
      val slot = hoveredSlot?.index ?: 0
      val count = container.getItemCount(slot)
      lines.add(1, Component.literal("Items: $count"))
    }
    return lines
  }

  override fun renderBg(poseStack: PoseStack, f: Float, i: Int, j: Int) {
    RenderSystem.setShader { GameRenderer.getPositionTexShader() }
    RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f)
    RenderSystem.setShaderTexture(0, CONTAINER_BACKGROUND)
    val k = (width - imageWidth) / 2
    val l = (height - imageHeight) / 2
    this.blit(poseStack, k, l, 0, 0, imageWidth, containerRows * 18 + 17)
    this.blit(poseStack, k, l + containerRows * 18 + 17, 0, 126, imageWidth, 96)
  }

  companion object {
    private val CONTAINER_BACKGROUND = ResourceLocation("textures/gui/container/generic_54.png")
  }
}