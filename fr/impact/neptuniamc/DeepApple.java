package fr.impact.neptuniamc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class DeepApple extends ItemFood
{
   



    public DeepApple(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
	}

	
    protected void onFoodEaten(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer p_77849_3_)
    {
    	if(!p_77849_2_.isClient) 
    	{
    		p_77849_3_.addPotionEffect(new PotionEffect(Potion.regeneration.id, 30 * 20, 1));
    		p_77849_3_.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 120 * 20, 1));
    		
    	}
    	
    	
    			
    	
    	
    }


}
