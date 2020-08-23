package fr.impact.neptuniamc.sticks;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class HealStick extends Item {
	
	private int clientTimer;
	
	public HealStick(int clientTimer) {
		this.clientTimer = clientTimer;
		this.setMaxStackSize(1);
		this.setMaxDamage(5);
	}
	
	
	public ItemStack onItemRightClick(ItemStack itemStack, World worldIn, EntityPlayer playerIn) 
	{
				
		if(!playerIn.capabilities.isCreativeMode) 
		{
			if(playerIn.getHealth() != playerIn.getMaxHealth()) 
			{
				
				
				if(itemStack.getTagCompound().getInteger("timer") <= 0)
				{
					itemStack.getTagCompound().setInteger("timer", getClientTimer());
					itemStack.damageItem(1, playerIn); 
					
					playerIn.setHealth(playerIn.getMaxHealth());
				}
				
				else {
					playerIn.addChatComponentMessage(new ChatComponentText("Stick en cooldown ! Temps restant : " + itemStack.getTagCompound().getInteger("timer") / 20));
				}
				
		
				
				
				
		
			}
		
		}
		
		return itemStack;
				
	}
	
	@Override
	public void onUpdate(ItemStack itemStack, World worldIn, Entity entityIn, int slotType,
			boolean inHand) 
	{
		
		
		if(!itemStack.hasTagCompound()) 
		{
			itemStack.setTagCompound(new NBTTagCompound());
			itemStack.getTagCompound().setInteger("timer", 0);
		}
		
		if(itemStack.getTagCompound().getInteger("timer") > 0)
		{
			itemStack.getTagCompound().setInteger("timer", itemStack.getTagCompound().getInteger("timer") - 1);
		}
		
		super.onUpdate(itemStack, worldIn, entityIn, slotType, inHand);
		
		
		
		
		
	}
	
	
	
	public int getClientTimer() 
	{
		return clientTimer;
	}
	


	

	
	
	
}
