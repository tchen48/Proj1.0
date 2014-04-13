package com.ProjMgmtSys.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExPattern {
	public static boolean validateName(String input){
		Pattern name = Pattern.compile("[a-zA-Z]{1,20}");
		Matcher m = name.matcher(input);
		return m.matches();
	}

	public static boolean validatePassword(String input){
		Pattern password = Pattern.compile("[a-zA-Z0-9]{6,20}");
		Matcher m = password.matcher(input);
		return m.matches();
	}
	
	public static boolean validateAddress(String input){
		if(input.replaceAll(" ", "").length() == 0){
			return false;
		}
		Pattern address = Pattern.compile("[a-zA-Z0-9 ]{1,100}");
		Matcher m = address.matcher(input);
		return m.matches();
	}

	public static boolean validateSsn(String input){
		Pattern ssn = Pattern.compile("[0-9]{9}");
		Matcher m = ssn.matcher(input);
		return m.matches();
	}

	public static boolean validateTelephone(String input){
		Pattern telephone = Pattern.compile("[0-9]{10}");
		Matcher m = telephone.matcher(input);
		return m.matches();
	}

	public static boolean validateAccountID(String input){
		Pattern accountID = Pattern.compile("[0-9]{12}");
		Matcher m = accountID.matcher(input);
		return m.matches();
	}

	public static boolean validateOTP(String input){
		Pattern otp = Pattern.compile("[0-9]{8}");
		Matcher m = otp.matcher(input);
		return m.matches();
	}

	public static boolean validateCaptcha(String input){
		Pattern captcha = Pattern.compile("[a-zA-Z0-9]{6}");
		Matcher m = captcha.matcher(input);
		return m.matches();
	}

	public static boolean validateAmount(String input){
		Pattern amount = Pattern.compile("(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){1,2})?$");
		Matcher m = amount.matcher(input);
		return m.matches();
	}
	
	public static boolean validateEmail(String input){
		if(input.length() > 50)
			return false;
		Pattern email = Pattern.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
		Matcher m = email.matcher(input);
		return m.matches();
	}
	
	public static boolean validateStrID(String input){
		Pattern strID = Pattern.compile("[a-z]{2}[a-z]*[1-9]+[0-9]*"); 
		Matcher m = strID.matcher(input);
		return m.matches();
	}
	
	public static boolean validateDobYear(String input){
		Pattern dobYear = Pattern.compile("[0-9]{4}"); 
		Matcher m = dobYear.matcher(input);
		if(m.matches()){
			int year = Integer.valueOf(input);
			if(year >= 1900 && year <= 2013)
				return true;
		}
		return false;
	}
	
	public static boolean validateDobDay(String input){
		Pattern dobDay = Pattern.compile("[0-3]?[0-9]{1}"); 
		Matcher m = dobDay.matcher(input);
		if(m.matches()){
			int day = Integer.valueOf(input);
			if(day >= 1 && day <= 31)
				return true;
		}
		return false;
	}
	
	public static boolean validateDobMonth(String input){
		Pattern dobMonth = Pattern.compile("[01]?[0-9]{1}"); 
		Matcher m = dobMonth.matcher(input);
		if(m.matches()){
			int month = Integer.valueOf(input);
			if(month >= 1 && month <= 12)
				return true;
		}
		return false;
	}
}
