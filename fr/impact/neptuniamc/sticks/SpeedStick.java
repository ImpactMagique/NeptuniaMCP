package fr.impact.neptuniamc.sticks;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class SpeedStick extends Item
{
	

	
	public SpeedStick() 
	{
		this.setMaxStackSize(1);
		this.setMaxDamage(5);
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World worldIn, EntityPlayer playerIn) 
	{
				
		if(!playerIn.capabilities.isCreativeMode) 
		{
			if(!playerIn.isPotionActive(Potion.moveSpeed)) 
			{
				
				
		
					itemStack.damageItem(1, playerIn); 
					
					playerIn.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 120 * 20, 1));

		
			}
		
		}
		
		return itemStack;
				
	}
	

	
}
