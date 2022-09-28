package runner.browser_manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager  extends DriverManager{
    @Override
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resource/chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");
        driver = new ChromeDriver(options);
    }
}
