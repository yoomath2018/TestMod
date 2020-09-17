
package net.mcreator.testmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.testmod.procedures.RedBreadFoodEatenProcedure;
import net.mcreator.testmod.itemgroup.RubyMaterialsItemGroup;
import net.mcreator.testmod.TestmodModElements;

import java.util.Map;
import java.util.HashMap;

@TestmodModElements.ModElement.Tag
public class RedBreadItem extends TestmodModElements.ModElement {
	@ObjectHolder("testmod:red_bread")
	public static final Item block = null;
	public RedBreadItem(TestmodModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(RubyMaterialsItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(4).saturation(0.3f).build()));
			setRegistryName("red_bread");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				RedBreadFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
