package com.gmail.lynx7478.ctw.stats.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.gmail.lynx7478.ctw.events.PlayerKilledEvent;
import com.gmail.lynx7478.ctw.stats.Stats;

public class DeathListener implements Listener {
	
	private boolean sql;
	
	public DeathListener(boolean sql)
	{
		this.sql = sql;
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerKilledEvent e)
	{
		if(this.sql)
		{
			Player d = e.getKilled().getPlayer();
			Player k = e.getKiller().getPlayer();
			
			// Adds a death to the player that has been killed.
			Stats.getStats().setDeaths(d, Stats.getStats().getDeaths(d)+1);
			
			// Adds a kill to the killer.
			Stats.getStats().setKills(k, Stats.getStats().getKills(k)+1);
		}else
		{
			
		}
	}

}
