package com.pkg.services;

import com.pkg.exceptions.PhoneException;

public interface INPhoneService {
	
	
	
	String addContact(String phoneNo, String name, String dateOfBirth, String email) throws PhoneException;
	void displayContactDetails();
	void updateContactDetails(String name,String dateOfBirth,String newPhoneNo) throws PhoneException;
	void deleteContact(String dateOfBirth)throws PhoneException;

	

}


/*1.	Add new Contact
2.	Display All Contact Details
3.	Update Contact details for given Name & Date of Birth
4.	Remove all Contacts who are above 80 years
*/