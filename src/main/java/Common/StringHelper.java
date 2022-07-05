package Common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class StringHelper {
	// Separate words from String which has digits
	public static String drawDigitsFromString(String strValue) {
		String str = strValue.trim();
		String digits = "";
		for (int i = 0; i < str.length(); i++) {
			char chrs = str.charAt(i);
			if (Character.isDigit(chrs) || chrs == '.')
				digits = digits + chrs;

		}
		return digits;
	}

	
	public static double getDoubleValue(String strValue) {

		double doubleNumber = 0;
		String str = strValue.trim();
		String digits = "";
		for (int i = 0; i < str.length(); i++) {
			char chrs = str.charAt(i);
			if (Character.isDigit(chrs) || chrs == '.')
				digits = digits + chrs;

		}
		

		try {
			doubleNumber = Double.parseDouble(digits);
		} catch (NumberFormatException e) {
			System.out.println(e);
		}

		return doubleNumber;
	}
	
	
	public static int getIntValue(String strValue) {

		int intNumber = 0;
		String str = strValue.trim();
		String digits = "";
		for (int i = 0; i < str.length(); i++) {
			char chrs = str.charAt(i);
			if (Character.isDigit(chrs) || chrs == '.')
				digits = digits + chrs;

		}
		

		try {
			intNumber = Integer.parseInt(digits);
		} catch (NumberFormatException e) {
			System.out.println(e);
		}

		return intNumber;
	}
	

		
		
		
	}
	
