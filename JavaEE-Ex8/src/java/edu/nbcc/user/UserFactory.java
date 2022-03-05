package edu.nbcc.user;

public abstract class UserFactory {
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 * @return
	 */
	  public static IUser createInstance(String firstName, String lastName, String emailAddress) {
	    return new User(firstName, lastName, emailAddress);
	  }
	}
