package com.gmail.lynx7478.ctw.stats.sql;

import java.sql.ResultSet;

public interface AsyncQuery extends Runnable
{
	public boolean isCallback();
	public String getQuerey();
	public void setResult(ResultSet set);
	
}
