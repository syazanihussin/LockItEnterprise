package com.lockit.ejb.logic;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SecurityBean
 */
@Stateless
@LocalBean
public class SecurityBean implements SecurityBeanRemote, SecurityBeanLocal {

    /**
     * Default constructor. 
     */
    public SecurityBean() {
        // TODO Auto-generated constructor stub
    }

}
