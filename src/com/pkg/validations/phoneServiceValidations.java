package com.pkg.validations;

import java.time.LocalDate;
import java.time.Period;

import com.pkg.exceptions.PhoneException;

public class phoneServiceValidations {
	
	public static LocalDate parseDate(String dateOfBirth)throws PhoneException
	{
		LocalDate date = LocalDate.parse(dateOfBirth);
		return date;
	}
	public static  int validateAge(String dateOfBirth)throws PhoneException
	{
		LocalDate date = LocalDate.parse(dateOfBirth);//1900-10-10
		LocalDate todayDate = LocalDate.now();//2025-04-10
		int age = Period.between(date,todayDate).getYears();
		if (age < 80)
		{
			throw new PhoneException("age is below 80");
		}
		return age;
	}

}
	
	
