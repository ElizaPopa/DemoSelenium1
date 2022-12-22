package tests;

import driver.WebdriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TablePage;

public class WebTableTests {
    public static void main(String[] args) {
        ChromeDriver driver = WebdriverManager.createDriverAndGetPage();
        TablePage tablePage = new TablePage();
        tablePage.updateTable(driver);
        tablePage.getTableDetails(driver);
        driver.quit();
    }
}