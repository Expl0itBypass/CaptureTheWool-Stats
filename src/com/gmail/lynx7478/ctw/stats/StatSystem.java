package com.gmail.lynx7478.ctw.stats;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.gmail.lynx7478.ctw.stats.sql.Database;
import com.gmail.lynx7478.ctw.stats.listeners.*;

public class StatSystem {
	
	private Database database;
	
	
	public StatSystem()
	{
		String backend = Stats.getInstance().getSConfig().getString("Backend");
		if(backend.equalsIgnoreCase("sql"))
		{
			ConfigurationSection sec = Stats.getInstance().getSConfig().getConfigurationSection("Database");
			this.database = Database.getMySQLDatabase(sec.getString("Address"), sec.getString("Port")
					, sec.getString("Database"), sec.getString("Username"),
					sec.getString("Password"));
			try
			{
				database.updateSQL("CREATE TABLE IF NOT EXISTS tbl_player_kills (ID VARCHAR(40), KILLS Integer, UNIQUE(ID));");
				database.updateSQL("CREATE TABLE IF NOT EXISTS tbl_player_wins (ID VARCHAR(40), WINS Integer, UNIQUE(ID));");
				database.updateSQL("CREATE TABLE IF NOT EXISTS tbl_player_deaths (ID VARCHAR(40), DEATHS Integer, UNIQUE(ID));");
				database.updateSQL("CREATE TABLE IF NOT EXISTS tbl_player_wools (ID VARCHAR(40), WOOLS Integer, UNIQUE(ID));");
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			//TODO: Listeners
			this.registerListener(new DeathListener(true));
			this.registerListener(new GameEndListener(true));
			this.registerListener(new WoolCaptureListener(true));
			
		}else if(backend.equalsIgnoreCase("file"))
		{
			
		}
	}
	
	private void registerListener(Listener l)
	{
		Stats.getInstance().getServer().getPluginManager().registerEvents(l, Stats.getInstance());
	}
	
	public Database getDatabase()
	{
		return database;
	}
	
	public int getWins(final Player p)
	{
		int a = 0;
		try {
			ResultSet result = database.querySQL("SELECT * FROM tbl_player_wins WHERE ID='"+p.getUniqueId().toString().replaceAll("-", "")+"';");
			if(result.next())
			{
				a = result.getInt("WINS");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		return a;
	}
	
	public void setWins(final Player p, int toSet)
	{
		try {
			database.updateSQL("INSERT INTO tbl_player_wins (ID, WINS) VALUES ('"+p.getUniqueId().toString().replaceAll("-", "")+"', "+toSet+") ON DUPLICATE KEY UPDATE WINS=VALUES(WINS);");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getKills(final Player p)
	{
		int a = 0;
		try {
			ResultSet result = database.querySQL("SELECT * FROM tbl_player_kills WHERE ID='"+p.getUniqueId().toString().replaceAll("-", "")+"';");
			if(result.next())
			{
				a = result.getInt("KILLS");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		return a;
	}
	
	public void setKills(final Player p, int toSet)
	{
		try {
			database.updateSQL("INSERT INTO tbl_player_kills (ID, KILLS) VALUES ('"+p.getUniqueId().toString().replaceAll("-", "")+"', "+toSet+") ON DUPLICATE KEY UPDATE KILLS=VALUES(KILLS);");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getDeaths(final Player p)
	{
		int a = 0;
		try {
			ResultSet result = database.querySQL("SELECT * FROM tbl_player_deaths WHERE ID='"+p.getUniqueId().toString().replaceAll("-", "")+"';");
			if(result.next())
			{
				a = result.getInt("DEATHS");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		return a;
	}
	
	public void setDeaths(final Player p, int toSet)
	{
		try {
			database.updateSQL("INSERT INTO tbl_player_deaths (ID, DEATHS) VALUES ('"+p.getUniqueId().toString().replaceAll("-", "")+"', "+toSet+") ON DUPLICATE KEY UPDATE DEATHS=VALUES(DEATHS);");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getWools(final Player p)
	{
		int a = 0;
		try {
			ResultSet result = database.querySQL("SELECT * FROM tbl_player_wools WHERE ID='"+p.getUniqueId().toString().replaceAll("-", "")+"';");
			if(result.next())
			{
				a = result.getInt("WOOLS");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		return a;
	}
	
	public void setWools(final Player p, int toSet)
	{
		try {
			database.updateSQL("INSERT INTO tbl_player_wools (ID, WOOLS) VALUES ('"+p.getUniqueId().toString().replaceAll("-", "")+"', "+toSet+") ON DUPLICATE KEY UPDATE WOOLS=VALUES(WOOLS);");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
