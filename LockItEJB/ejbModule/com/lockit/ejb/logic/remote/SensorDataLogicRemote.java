	package com.lockit.ejb.logic.remote;
	
	import javax.ejb.Local;
	import javax.ejb.Remote;
	
	@Remote
	
	public interface SensorDataLogicRemote
	{

		Boolean detectUnusualData();

	}
