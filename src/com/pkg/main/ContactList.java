package com.pkg.main;

import java.util.Scanner;

import com.pkg.services.PhoneServiceImpl;

public class ContactList {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			PhoneServiceImpl ps = new PhoneServiceImpl();
			boolean exit = false;

			try {
				while (!exit) {
					System.out.println("Phone Booth Menu");

					System.out.println("1.Add new Contact");
					System.out.println("2.Display All Contact Details");
					System.out.println("3.Update Contact details for given Name & Date of Birth");
					System.out.println("4.Remove all Contacts who are above 80 years");
					System.out.println("5.EXIT");

					int choice = sc.nextInt();
					switch (choice) {
					case 1:
						System.out.println("enter the phoneno,name,date of birth,email");

						ps.addContact(sc.next(), sc.next(), sc.next(), sc.next());
						System.out.println("Contact is added");

						break;

					case 2:
						System.out.println("The contact details are");
						ps.displayContactDetails();
						break;
					case 3:
						System.out.println("Enter the name, date of birth and New PhoneNo");
						ps.updateContactDetails(sc.next(), sc.next(), sc.next());
						System.out.println("The updated contact");
						break;
					case 4:
						System.out.println("Enter date of birth to remove contact who are above 80 years");
						ps.deleteContact(sc.next());
						System.out.println("The deleted contact");
						break;
					case 5:
						exit = true;
					}
				}
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Please retry");
				e.getStackTrace();

			}

		}

	}
}