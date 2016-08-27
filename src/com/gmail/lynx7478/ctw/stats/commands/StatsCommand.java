package com.gmail.lynx7478.ctw.stats.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.lynx7478.ctw.stats.Stats;

public class StatsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command stats, String s, String[] args) 
	{
		if(stats.getName().equalsIgnoreCase("stats"))
		{
			if(!(sender instanceof Player))
			{
				Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Only players can execute this command.");
				return false;
			}
			Player p = (Player) sender;
			if(args.length == 0)
			{
				Integer kills = Stats.getStats().getKills(p);
				Integer deaths = Stats.getStats().getDeaths(p);
				Integer wins = Stats.getStats().getWins(p);
				Integer wools = Stats.getStats().getWools(p);
				if(kills != null)
				{
					p.sendMessage(ChatColor.AQUA+"Kills: "+ChatColor.GREEN+kills);
				}
				if(deaths != null)
				{
					p.sendMessage(ChatColor.AQUA+"Deaths: "+ChatColor.GREEN+deaths);
				}
				if(wins != null)
				{
					p.sendMessage(ChatColor.AQUA+"Wins: "+ChatColor.GREEN+wins);
				}
				if(wools != null)
				{
					p.sendMessage(ChatColor.AQUA+"Wools Captured: "+ChatColor.GREEN+wools);
				}
				return true;
				
			}else
			{
				Player t = Bukkit.getPlayer(args[0]);
				if(t == null)
				{
					p.sendMessage(ChatColor.DARK_RED + args[0]+ChatColor.RED +" is not a valid player or is not online.");
					return false;
				}
				Integer kills = Stats.getStats().getKills(t);
				Integer deaths = Stats.getStats().getDeaths(t);
				Integer wins = Stats.getStats().getWins(t);
				Integer wools = Stats.getStats().getWools(t);
				if(kills != null)
				{
					p.sendMessage(ChatColor.AQUA+"Kills: "+ChatColor.GREEN+kills);
				}
				if(deaths != null)
				{
					p.sendMessage(ChatColor.AQUA+"Deaths: "+ChatColor.GREEN+deaths);
				}
				if(wins != null)
				{
					p.sendMessage(ChatColor.AQUA+"Wins: "+ChatColor.GREEN+wins);
				}
				if(wools != null)
				{
					p.sendMessage(ChatColor.AQUA+"Wools Captured: "+ChatColor.GREEN+wools);
				}
				return true;
			}
		}
		return false;
	}

}
