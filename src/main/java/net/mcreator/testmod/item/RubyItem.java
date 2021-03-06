
package net.mcreator.testmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.testmod.itemgroup.RubyMaterialsItemGroup;
import net.mcreator.testmod.TestmodModElements;

@TestmodModElements.ModElement.Tag
public class RubyItem extends TestmodModElements.ModElement {
	@ObjectHolder("testmod:ruby")
	public static final Item block = null;
	public RubyItem(TestmodModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(RubyMaterialsItemGroup.tab).maxStackSize(64));
			setRegistryName("ruby");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
