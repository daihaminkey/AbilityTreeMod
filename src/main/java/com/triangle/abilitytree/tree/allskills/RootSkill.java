package com.triangle.abilitytree.tree.allskills;

import com.triangle.abilitytree.tree.Skill;

//DOC_ME
public class RootSkill extends Skill
{
	public RootSkill()
	{
		setName("Root");
		setCoord(0,0);
		addChild(new JumpSkill1());

	}
}
