package nl.hu.v1ipass.model;

import nl.hu.v1ipass.webservices.GerechtService;
import nl.hu.v1ipass.webservices.ReserveringService;

public class ServiceProvider {
	  private static GerechtService gerechtService = new GerechtService();

	  public static GerechtService getGerechtService() { 
	    return gerechtService;
	  }
	  
	  private static ReserveringService reserveringService = new ReserveringService();
	  
	  public static ReserveringService getReserveringService() { 
		    return reserveringService;
		  }


}

