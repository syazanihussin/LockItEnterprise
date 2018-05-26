	package com.lockit.ejb.logic.local;
	
	import javax.ejb.Local;
	import javax.ejb.Remote;
	
	
	@Remote
	@Local
	public interface SensorDataLogicLocal
	{
		
		Boolean detectUnusualData();
		
		
	
	}
