package com.pkg.services;

import java.time.LocalDate;
import java.util.ArrayList;

import com.pkg.exceptions.PhoneException;
import com.pkg.pojo.Contact;
import com.pkg.validations.phoneServiceValidations;

public class PhoneServiceImpl implements INPhoneService {

	ArrayList<Contact> contact = new ArrayList<>();
	{
		contact.add(new Contact("9766157227", "Rekha", LocalDate.parse("1986-02-01"), "Rekha@gmail.com"));
		contact.add(new Contact("9111431781", "Sweety", LocalDate.parse("1988-02-23"), "Sweety@gmail.com"));
		contact.add(new Contact("9630845906", "Namrata", LocalDate.parse("1996-10-16"), "Namrata@gmail.com"));
		contact.add(new Contact("9658748778-8109159813", "Kajal", LocalDate.parse("1998-05-28"), "Kajal@gmail.com"));
	}

	@Override
	public String addContact(String phoneNo, String name, String dateOfBirth, String email) throws PhoneException {

		LocalDate Date = phoneServiceValidations.parseDate(dateOfBirth);
		Contact contacts = new Contact(phoneNo, name, Date, email);
		boolean exist = contact.stream()
				.filter(c -> c.getName().equalsIgnoreCase(name) && c.getPhoneNo().equals(phoneNo)).findFirst()
				.isPresent();
		if (exist) 
			throw new PhoneException("Contact is already added");
		
			contact.add(contacts);
		
		return "contact is added";

	}

	@Override
	public void displayContactDetails() {
		contact.stream().forEach(c -> System.out.println(c));

	}

	@Override
	public void updateContactDetails(String name, String dateOfBirth, String newPhoneNo) throws PhoneException {

		LocalDate Date = phoneServiceValidations.parseDate(dateOfBirth);
		contact.stream().filter(c -> c.getName().equalsIgnoreCase(name)).filter(c -> c.getDateOfBirth().equals(Date))
				.peek(c -> c.setPhoneNo(newPhoneNo)).forEach(c -> System.out.println(c));

	}

	@Override
	public void deleteContact(String dateOfBirth) throws PhoneException {

		phoneServiceValidations.validateAge(dateOfBirth);
		LocalDate Date = phoneServiceValidations.parseDate(dateOfBirth);
		contact.removeIf(c -> c.getDateOfBirth().equals(Date));

	}

}
