package com.bugfix.jutil.validation;

import java.awt.Desktop;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import javax.swing.text.DateFormatter;

public class Validator {

	/**
	 * To validate whether an Object is null or empty
	 * @param inputToValidate
	 * @return boolean
	 */
	public static boolean isEmpty(Object inputToValidate) {
		if(inputToValidate == null){
			return false;
		}else if(inputToValidate instanceof String){
			return isStringEmpty((String) inputToValidate);
		}else if(inputToValidate.getClass().isArray()){
			return isArrayEmpty((Object[]) inputToValidate);
		}else if(inputToValidate instanceof List){
			return isListEmpty((List<?>) inputToValidate);
		}else if(inputToValidate instanceof Set){
			return isSetEmpty((Set<?>) inputToValidate);
		}else if(inputToValidate instanceof Map){
			return isMapEmpty((Map<?, ?>) inputToValidate);
		}else if(inputToValidate instanceof Enumeration){
			return isEnumerationEmpty((Enumeration<?>) inputToValidate);
		}
		return false;
	}
	
	/**
	 * To validate whether a String is empty
	 * @param inputToValidate
	 * @return boolean
	 */
	private static boolean isStringEmpty(String stringToValidate){
		if(stringToValidate.isEmpty() || stringToValidate.trim().isEmpty()){
			return true;
		}
		return false;
	}
	
	/**
	 * To validate whether an Array is empty
	 * @param arrayToValidate
	 * @return
	 */
	private static boolean isArrayEmpty(Object[] arrayToValidate){
		if(arrayToValidate.length <= 0){
			return true;
		}
		return false;
	}
	
	/**
	 * To validate whether a List is empty
	 * @param inputToValidate
	 * @return boolean
	 */
	private static boolean isListEmpty(List<?> listToValidate){
		if(listToValidate.isEmpty()){
			return true;
		}
		return false;
	}
	
	/**
	 * To validate whether a Map is empty
	 * @param inputToValidate
	 * @return boolean
	 */
	private static boolean isMapEmpty(Map<?,?> mapToValidate){
		if(mapToValidate.isEmpty()){
			return true;
		}
		return false;
	}
	
	/**
	 * To validate whether a Set is empty
	 * @param inputToValidate
	 * @return boolean
	 */
	private static boolean isSetEmpty(Set<?> setToValidate){
		if(setToValidate.isEmpty()){
			return true;
		}
		return false;
	}
	
	/**
	 * To validate whether an Enumeration is empty
	 * @param inputToValidate
	 * @return boolean
	 */
	private static boolean isEnumerationEmpty(Enumeration<?> enumerationToValidate){
		if(!enumerationToValidate.hasMoreElements()){
			return true;
		}
		return false;
		
	}

	public static boolean isValidHostAddressOrDomainName(String hostAddressOrDomainName){
		return true;
	}
	
	public static boolean isValidPortNumber(int portNumber){
		final int portNumber_ = portNumber;
		if(portNumber_ < 1024 || portNumber_ > 65535){
			return false;
		}
		return true;
	}
	
	public static boolean isValidEmailID(String emailID){
		return true;
	}
	
	public static boolean isValidPhoneNumber(String countryCode, int phoneNumber){
		return true;
	}
	
	public static boolean isValidMobileNumber(String countryCode, int mobileNumber){
		return true;
	}
	
	public static boolean isNumeric(String number){
		try{
			Float.parseFloat(number);
		}catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}
	
	public static boolean isDecimal(String number){
		try{
			Double.parseDouble(number);
		}catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}
	
	public static boolean isAmount(String number){
//		try{
			if(!isNumeric(number)){
				return false;
			}
			
//		}
	}
	
	public static boolean isInRange(String value, String minValue, String maxValue) throws Exception{
		try{
			Double value_ = Double.parseDouble(value);
			Double minValue_ = Double.parseDouble(minValue);
			Double maxValue_ = Double.parseDouble(maxValue);
			if(minValue_ <= value_	&& value_ <= maxValue_){
				return true;
			}
		}catch(NumberFormatException nfe){
			throw new NumberFormatException("Value::"+value+" isnot numeric");
		}
		return false;
	}
	
	public static boolean isDate(String date){
		
	}
	
	public static boolean isPastDate(){
		
	}
	
	public static boolean isFutureDate(){
		
	}
	
	
	public static boolean isCurrentDate(){
		
	}
	
	public static boolean isDateInRange(){
		
	}
	
	public static Date getDateFromTimeInMillis(){
		
	}	
	
	public static Calendar getCalendarFromTimeInMillis(){
		
	}
	
	public static TimeZone getTimeZoneFromTimeInMillis(){
		
	}
	
	
}
