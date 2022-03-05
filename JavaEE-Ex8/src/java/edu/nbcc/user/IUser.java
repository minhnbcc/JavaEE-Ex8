package edu.nbcc.user;

public interface IUser {
	  void setFirstName(String paramString);
	  
	  String getFirstName();
	  
	  void setLastName(String paramString);
	  
	  String getLastName();
	  
	  void setEmailAddress(String paramString);
	  
	  String getEmailAddress();
	  
	  boolean hasRequiredFields();
	  
	  boolean isEmailValid();
	}
