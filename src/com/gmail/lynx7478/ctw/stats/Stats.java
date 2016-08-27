package com.gmail.lynx7478.ctw.stats;

import org.bukkit.plugin.java.JavaPlugin;

public class Stats extends JavaPlugin {
	
	private static Stats instance;
	
	public static Stats getInstance()
	{
		return instance;
	}
	
	@Override
	public void onEnable()
	{
		instance = this;
	}
	
	public void onDisable()
	{
		
	}

}
