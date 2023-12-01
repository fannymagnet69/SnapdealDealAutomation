package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter {
	private static ExtentReports extent;
	private static ExtentSparkReporter extentReport;

	public static ExtentReports getExtentReport() {
		Reporter.createExtentReport();
		return extent;
	}

	private static void createExtentReport() {

		String filename = "Report_" + CurrentDateTime.getCurrentDateTime() + ".html";
		extentReport = new ExtentSparkReporter("./reports/" + filename);
		extent = new ExtentReports();
		extent.attachReporter(extentReport);
	}

	// public static String createReport() {
	//
	// String filename = "Report_" + CurrentDateTime.getCurrentDateTime() + ".html";
	// extentReport = new ExtentSparkReporter("./testreport/" + filename);
	// extent = new ExtentReports();
	// extent.attachReporter(extentReport);
	// System.out.println("Testing is working fine...");
	// return filename;
	// }

}
