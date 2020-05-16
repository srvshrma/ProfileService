package com.cognizant.myProject.exception;

public enum ExceptionMessage {
	
	EMPTY("Profile Not Found with id: "), 
	DUPLICATE("err"), 
	DATABASE("Try after some time"), 
	NOTEMPTY("* feild cannot be empty "), 
	User_FirstName_Not_Found("FirstName Not Found of user: "), 
	User_LastName_Not_Found("LastName Not Found of user: "),
	User_Email_Not_Found("Email Not Found of  user: "),
	NO_RECORD("No record found by id: ");
	private final String message;
	ExceptionMessage(String message)
	{
		this.message = message;
	}
	public String getMessage()
	{
		return this.message;
	}

}
