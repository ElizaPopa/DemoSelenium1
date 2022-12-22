package driver;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverManager {

    public static ChromeDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        return new ChromeDriver();
    }

    public static ChromeDriver createDriverAndGetPage() {
        ChromeDriver driver = WebdriverManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
        return driver;
    }
}
