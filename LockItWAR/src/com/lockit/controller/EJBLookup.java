package com.lockit.controller;


import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.lockit.ejb.dao.remote.HouseOwnerBeanRemote;
import com.lockit.ejb.logic.remote.HouseOwnerLogicRemote;


public class EJBLookup {

	
	public EJBLookup() {
		super();
	}
	
	
	public HouseOwnerBeanRemote getHouseOwnerBeanRemote() {
		
		HouseOwnerBeanRemote houseOwnerBeanRemote = null;
		Properties prop = new Properties();
	    prop.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
	    prop.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
	    prop.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
	    
	    try {
	        InitialContext ctx = new InitialContext(prop);                              
	        houseOwnerBeanRemote = (HouseOwnerBeanRemote) ctx.lookup("java:global/LockItEAR/LockItWAR/HouseOwnerBean!com.lockit.ejb.HouseOwnerBeanRemote");
	    } catch (NamingException e) {
	        e.printStackTrace();
	    }
	    
	    return houseOwnerBeanRemote;
	}
	
	
	public HouseOwnerLogicRemote getHouseOwnerLogicRemote() {
		
		HouseOwnerLogicRemote houseOwnerLogicRemote = null;
		Properties prop = new Properties();
	    prop.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
	    prop.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
	    prop.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
	    
	    try {
	        InitialContext ctx = new InitialContext(prop);                              
	        houseOwnerLogicRemote = (HouseOwnerLogicRemote) ctx.lookup("java:global/LockItEAR/LockItWAR/HouseOwnerBean!com.lockit.ejb.HouseOwnerLogicRemote");
	    } catch (NamingException e) {
	        e.printStackTrace();
	    }
	    
	    return houseOwnerLogicRemote;
	}
	

}
