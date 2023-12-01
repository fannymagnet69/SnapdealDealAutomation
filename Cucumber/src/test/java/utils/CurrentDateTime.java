package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDateTime {

	public static String getCurrentDateTime() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		LocalDateTime currentDateTime = LocalDateTime.now();
		return dateTimeFormatter.format(currentDateTime);
	}

}
