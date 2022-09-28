package runner.browser_manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager{

    @Override
    public void createDriver() {
        System.setProperty("webdriver.gecko.driver", "./src/test/resource/geckodriver/geckodriver.exe");
        driver = new FirefoxDriver();

    }
}
