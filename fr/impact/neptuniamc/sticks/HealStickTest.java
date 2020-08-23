package fr.impact.neptuniamc.sticks;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class HealStickTest extends Item 
{
	private int clientTimer;
	
	public HealStickTest(int clientTimer) 
	{
		this.clientTimer = clientTimer;
		this.setMaxStackSize(1);
		this.setMaxDamage(5);
	}
	
	@Override
	public void onUpdate(ItemStack itemStack, World worldIn, Entity playerIn, int slotType,
			boolean inHand) {
		
		if(!itemStack.hasTagCompound()) 
		{
			itemStack.setTagCompound(new NBTTagCompound());
			itemStack.getTagCompound().setInteger("timer", 0);
		}
		
		if(itemStack.getTagCompound().getInteger("timer") > 0) 
		{
			itemStack.getTagCompound().setInteger("timer", itemStack.getTagCompound().getInteger("timer") - 1);
		}
		
		super.onUpdate(itemStack, worldIn, playerIn, slotType, inHand);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World worldIn, EntityPlayer playerIn) 
	{
		
		if(!playerIn.capabilities.isCreativeMode) 
		{
			if(playerIn.getHealth() != playerIn.getMaxHealth()) 
			{
				if(itemStack.getTagCompound().getInteger("timer") <= 0) 
				{
					if(!worldIn.isClient) 
					{
						itemStack.getTagCompound().setInteger("timer", getClientTimer());
						itemStack.damageItem(1, playerIn);
						playerIn.setHealth(playerIn.getMaxHealth());
						playerIn.addChatComponentMessage(new ChatComponentText("Utilisation du Heal Stick ! Vous avez été soigné"));
					}
				}
				else 
				{
					playerIn.addChatComponentMessage(new ChatComponentText("HealStick en cooldown !"));

				}
			}
		}
		
		
		return super.onItemRightClick(itemStack, worldIn, playerIn);
		
		
	
		
	}
	
	public int getClientTimer() {
		return clientTimer;
	}
	
}
