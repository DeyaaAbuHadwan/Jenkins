package DriverClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFirefox {
	private WebDriver driver;
	private String pathDriver;
	
	public DriverFirefox(String path) {
		this.pathDriver=path;
		setDriver(path);

	}
	
	private void setDriver(String path) {
		System.setProperty("webdriver.gecko.driver", path);
		driver = new FirefoxDriver();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
