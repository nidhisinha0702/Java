package String;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

	public static void main(String[] args) {
		// WAP to print a date in specific format
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		String date = sdf.format(new Date());
		System.out.println(date);

	}

}
