package com.triangle.abilitytree.ability.condition;

public class AbilityCondition implements IAbilityCondition
{
	protected int value = 0;
	protected final int target;
	protected String description;
	protected boolean visible = true;

	public AbilityCondition(int target, String description) throws IndexOutOfBoundsException
	{
		if(target <= 0)
			throw new IndexOutOfBoundsException("Target value must be larger than zero");

		this.target = target;
		this.description = description;
	}

	public AbilityCondition setVisible(boolean visible)
	{
		this.visible = visible;
		return this;
	}

	@Override
	public boolean isComplited()
	{
		return getCurrentValue() >= getTargetValue();
	}

	@Override
	public boolean isVisible()
	{
		return visible;
	}

	@Override
	public String getDescription()
	{
		return description;
	}

	@Override
	public int getTargetValue()
	{
		return target;
	}

	@Override
	public int getCurrentValue()
	{
		return value;
	}

	@Override
	public boolean addToValue()
	{
		value++;
		return isComplited();
	}

	@Override
	public boolean addToValue(int i)
	{
		value+=i;
		return isComplited();
	}

	@Override
	public void resetValue()
	{
		value = 0;
	}
}
