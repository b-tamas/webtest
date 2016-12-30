package seleniumtest4maven.seleniumtest4maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WordpressBasicTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\T\\DEV\\webtest\\gecko\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://tamasbakai.wordpress.com/");

		WebElement login = driver.findElement(By.linkText("Log in"));
		if (null != login) {
			System.out.println("Login link found");
			System.out.println("is displayed? " + login.isDisplayed());
		} else {
			System.out.println("Login link not found");
		}

		Thread.sleep(1000);
		WebElement menuToggle = driver.findElement(By.className("menu-toggle"));
		menuToggle.click();
		System.out.println("opening menu");
		Thread.sleep(1000);

		login = driver.findElement(By.linkText("Log in"));
		if (null != login) {
			System.out.println("Login link found");
			System.out.println("is displayed? " + login.isDisplayed());
		} else {
			System.out.println("Login link not found");
		}

		WebElement we = driver.findElement(By
				.linkText("Slightly philosophical…"));
		Thread.sleep(1000);
		we.click();

		Thread.sleep(1000);

	}
}
