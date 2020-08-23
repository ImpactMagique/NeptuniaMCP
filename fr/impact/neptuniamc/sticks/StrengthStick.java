package fr.impact.neptuniamc.sticks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class StrengthStick extends Item 
{
	
	public StrengthStick() 
	{
		this.setMaxStackSize(1);
		this.setMaxDamage(5);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World worldIn, EntityPlayer playerIn) {
		
		if(!playerIn.capabilities.isCreativeMode) 
		{
			if(!playerIn.isPotionActive(Potion.damageBoost)) 
			{
				itemStack.damageItem(1, playerIn);
				playerIn.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 120 * 20, 1));
			}
		}
		
		return itemStack;
	}

}
