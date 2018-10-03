package com.triangle.abilitytree.tree.allskills;

import com.triangle.abilitytree.tree.Counter;
import com.triangle.abilitytree.tree.Reward;
import com.triangle.abilitytree.tree.Skill;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

//DOC_ME
public class JumpSkill1 extends Skill
{
	public JumpSkill1()
	{
		addCounter(new Counter("jump", 5, LivingEvent.LivingJumpEvent.class, "Нужно много прыгать"));
		addChild(new ElfSkill());
		setName("Jumper");
		setCoord(50,50);

		addReward(new HighJumpReward());
	}

	class HighJumpReward extends Reward
	{
		public HighJumpReward()
		{
			setDescription("Увеличивает высоту прыжка до двух блоков");
			setEventType(LivingEvent.LivingJumpEvent.class);
		}

		@Override
		protected void influenceOnEvent(Event e) {
			( (LivingEvent.LivingJumpEvent) e) .getEntity().motionY+=0.132;
		}
	}

}
