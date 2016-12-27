package seleniumtest4maven.seleniumtest4maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello World!");

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\T\\DEV\\webtest\\gecko\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");

		WebElement we = driver.findElement(By.name("q"));
		we.sendKeys("selenium");

		driver.findElement(By.name("btnG")).click();
		// we.submit();

		Thread.sleep(1540);

		we = driver.findElement(By.name("q"));
		we.clear();
		we.sendKeys("selenium3");
		driver.findElement(By.name("btnG")).click();

		driver.close();

	}
}
