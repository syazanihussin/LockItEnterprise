	package com.lockit.ejb.logic.remote;
	
	import javax.ejb.Local;
	import javax.ejb.Remote;
	
	@Local
	@Remote
	
	public interface SensorDataLogicRemote
	{

		Boolean detectUnusualData();

	}
