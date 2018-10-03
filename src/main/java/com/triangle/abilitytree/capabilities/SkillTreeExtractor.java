package com.triangle.abilitytree.capabilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class SkillTreeExtractor
{
    public static ISkillTree getSkillTree(EntityPlayer player)
    {
        return player.getCapability(SkillTreeProvider.SKILL_TREE_CAPABILITY, null);
    }

    public static void passEvent(PlayerEvent e)
    {
    	getSkillTree(e.getEntityPlayer()).passEvent(e);
    }

	public static void passEvent(LivingEvent e)
	{
		Entity entity = e.getEntity();
		if(entity instanceof EntityPlayer)
			getSkillTree((EntityPlayer)entity).passEvent(e);
	}
}