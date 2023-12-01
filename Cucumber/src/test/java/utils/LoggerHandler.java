package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHandler {
	private static final String LOG4J_PROPERTIES_FILE = "C:\\Users\\HP\\Desktop\\maven project\\Project1\\Log4j.properties";
	private static final String PROPERTY_KEY = "logFileName";
	private static String LOG_FILE_NAME;

	static {
		LOG_FILE_NAME = "./logs/logfile_" + CurrentDateTime.getCurrentDateTime();
	}

	public static Logger createLog(String className) {
		Logger logger = Logger.getRootLogger();
		System.setProperty(PROPERTY_KEY, LOG_FILE_NAME);
		PropertyConfigurator.configure(LOG4J_PROPERTIES_FILE);
		return logger;
	}
}