package com.gmail.lynx7478.ctw.stats.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.gmail.lynx7478.ctw.events.WoolCaptureEvent;
import com.gmail.lynx7478.ctw.game.CTWPlayer;
import com.gmail.lynx7478.ctw.stats.Stats;

public class WoolCaptureListener implements Listener {
	
	private boolean sql;
	
	public WoolCaptureListener(boolean sql)
	{
		this.sql = sql;
	}
	
	@EventHandler
	public void onWoolCapture(WoolCaptureEvent e)
	{
		if(this.sql)
		{
			CTWPlayer p = CTWPlayer.getCTWPlayer(e.getPlayer().getUniqueId());
			Stats.getStats().setWools(p.getPlayer(), Stats.getStats().getWools(p.getPlayer())+1);
		}
	}

}
