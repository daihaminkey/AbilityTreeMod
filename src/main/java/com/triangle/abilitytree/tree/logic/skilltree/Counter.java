package com.triangle.abilitytree.tree.logic.skilltree;

import com.triangle.abilitytree.events.UpdateDebugger;
import com.triangle.abilitytree.interfaces.ICounter;
import net.minecraftforge.fml.common.eventhandler.Event;

public class Counter implements ICounter
{
	private int value;
	private int maxValue;
	private String description;
	private boolean isComplited;
	Class<? extends Event> eventType;

	//TODO List of event-listeners, binded to counters
	public Counter(String description, int maxValue, Class<? extends Event> eventType) throws IndexOutOfBoundsException
	{
		if(maxValue <= 0)
			throw new IndexOutOfBoundsException("maxValue must be greater than 0");


		this.description = description;
		this.value = 0;
		this.maxValue = maxValue;
		this.isComplited = false;
		this.eventType = eventType;
	}

	public void handleEvent(Event e)
	{

		if(eventType.isInstance(e))
			add(1);
	}

	@Override
	public String toString()
	{
		return description+": "+value+"/"+maxValue;
	}

	public void add(int i) throws IndexOutOfBoundsException
	{
		setValue(value+i);
	}

	public void setValue(int i) throws IndexOutOfBoundsException
	{
		if(isComplited)
			return;
		value = i;

		if(value >= maxValue)
			isComplited = true;

		UpdateDebugger.sendString(this.toString());
	}

	@Override
	public int getValue()
	{
		return value;
	}

	@Override
	public int getMaxValue()
	{
		return maxValue;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public boolean isComplited()
	{
		return isComplited;
	}
}
