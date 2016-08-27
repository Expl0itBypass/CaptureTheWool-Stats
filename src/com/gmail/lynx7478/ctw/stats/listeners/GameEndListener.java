package com.gmail.lynx7478.ctw.stats.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.gmail.lynx7478.ctw.events.GameEndEvent;
import com.gmail.lynx7478.ctw.game.CTWPlayer;
import com.gmail.lynx7478.ctw.stats.Stats;

public class GameEndListener implements Listener {
	
	private boolean sql;
	
	public GameEndListener(boolean sql)
	{
		this.sql = sql;
	}
	
	@EventHandler
	public void onGameEnd(GameEndEvent e)
	{
		if(this.sql)
		{
			for(Player p : Bukkit.getOnlinePlayers())
			{
				CTWPlayer aP = CTWPlayer.getCTWPlayer(p.getUniqueId());
				if(e.getWinner().getPlayers().contains(aP))
				{
					Stats.getStats().setWins(p, Stats.getStats().getWins(p)+1);
				}else
				{
					// Add a loss.
				}
					
			}
		}else
		{
			
		}
	}

}
