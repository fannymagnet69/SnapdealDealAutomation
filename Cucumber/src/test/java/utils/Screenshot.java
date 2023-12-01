package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;

public class Screenshot {
	private static String SCREENSHOTS_DIRECTORY_PATH = "./screenshot/";
	private static File DIRECTORY;

	static {
		DIRECTORY = new File(SCREENSHOTS_DIRECTORY_PATH);
		if (!DIRECTORY.exists()) {
			DIRECTORY.mkdir();
		}
	}

	public static String getScreenshotAsFilePath(WebDriver driver, String fileName) {

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = SCREENSHOTS_DIRECTORY_PATH + fileName + "_" + CurrentDateTime.getCurrentDateTime()
				+ ".png";
		File target = new File(destination);

		try {
			FileUtils.copyFile(screenshotFile, target);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return destination;
	}

	public static String getScreenshotAsBase64String(WebDriver driver, String fileName) {
		Screenshot.getScreenshotAsFilePath(driver, fileName);
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}

	public static Media getScreenshotAsMedia(WebDriver driver, String fileName) {
		Screenshot.getScreenshotAsFilePath(driver, fileName);
		return MediaEntityBuilder
				.createScreenCaptureFromBase64String(getScreenshotAsBase64String(driver,
						fileName))
				.build();
	}
}
