package com.gmail.lynx7478.ctw.stats;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.lynx7478.ctw.CTW;

public class Stats extends JavaPlugin {
	
	private static Stats instance;
	
	public static Stats getInstance()
	{
		return instance;
	}
	
	private File f;
	private YamlConfiguration config;
	
	private static StatSystem stats;
	
	@Override
	public void onEnable()
	{
		instance = this;
		f = new File(CTW.getInstance().getDataFolder(),"CTWStatsConfig.yml");
		config = YamlConfiguration.loadConfiguration(f);
		if(!f.exists())
		{
			try 
			{
				
				//TODO: File backend.
				f.createNewFile();
				config.set("Backend", "sql");
				ConfigurationSection sec = config.createSection("Database");
				sec.set("Address", "localhost");
				sec.set("Port", 3306);
				sec.set("Database", "ctw");
				sec.set("Username", "admin");
				sec.set("Password", "supersecretpassword");
				config.save(f);
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		stats = new StatSystem();
	}
	
	public void onDisable()
	{
		
	}
	
	public YamlConfiguration getSConfig()
	{
		return config;
	}
	
	public static StatSystem getStats()
	{
		return stats;
	}

}
