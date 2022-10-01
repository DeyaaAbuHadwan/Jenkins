import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import DriverClasses.DriverChrome;

public class ParameterJenkinsTest {

	@Test
	public void test() throws IOException, InterruptedException {
		FileReader readFile = new FileReader("src\\test\\resources\\props.properties");
		Properties prop = new Properties();
		prop.load(readFile);
		String userName = prop.getProperty("username");
		String pw = prop.getProperty("pw");
		System.out.println("User Name:" + userName);
		DriverChrome driver = new DriverChrome();
		driver.getDriver().get("https://github.com/login");
		waitElement(By.name("login"), 20, driver.getDriver()).sendKeys(userName);
		waitElement(By.name("password"), 20, driver.getDriver()).sendKeys(pw);
		waitElement(By.name("commit"), 20, driver.getDriver()).click();

		TakesScreenshot scrShot = ((TakesScreenshot) driver.getDriver());

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File("img.png");
		FileUtils.copyFile(SrcFile, DestFile);

		// Copy file at destination

	}

	public WebElement waitElement(By by, int time, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}

}
