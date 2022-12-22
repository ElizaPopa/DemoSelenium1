package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class TablePage {

    public static void getTableDetails(ChromeDriver driver) {
        WebElement tableCaption = driver.findElement(By.cssSelector("#tablehere table caption"));
        System.out.println("Caption: " + tableCaption.getText());
        WebElement table = driver.findElement(By.cssSelector("#tablehere table"));
        System.out.println("Id attribute: " + table.getAttribute("id"));
        System.out.println("");
        // select table rows and columns
        List<WebElement> tableRows = driver.findElements(By.cssSelector("#tablehere table tr"));
        for (int i = 0; i < tableRows.size(); i++) {
            WebElement currentRow = tableRows.get(i);
            if (i == 0) {
                List<WebElement> firstRowColumns = currentRow.findElements(By.cssSelector("th"));
                System.out.println("Header din prima coloana: " + firstRowColumns.get(0).getText());
                System.out.println("Header din a doua coloana: " + firstRowColumns.get(1).getText());
                System.out.println("");
            } else {
                List<WebElement> currentColumns = currentRow.findElements(By.cssSelector("td"));
                System.out.println("Text din randul " + (i + 1) + ", coloana 1: " + currentColumns.get(0).getText());
                System.out.println("Text din randul " + (i + 1) + ", coloana 2: " + currentColumns.get(1).getText());
            }
        }
    }

    public static void updateTable(ChromeDriver driver) {
        WebElement summary = driver.findElement(By.cssSelector("details summary"));
        summary.click();
        // update caption
        WebElement caption = driver.findElement(By.id("caption"));
        caption.clear();
        caption.sendKeys("Eli's Table");
        // update table id
        WebElement tableId = driver.findElement(By.id("tableid"));
        tableId.clear();
        tableId.sendKeys("anotherId");
        // update table content
        WebElement jsonData = driver.findElement(By.id("jsondata"));
        jsonData.clear();
        jsonData.sendKeys("[{\"name\": \"Bob\", \"age\": 20}, { \"name\": \"George\", \"age\": 42},{\"name\": \"Derek\",\"age\": 35}, {\"name\": \"Meredith\",\"age\": 27},{\"name\": \"Cristina\",\"age\": 30}]");
        System.out.println(jsonData.getAttribute("value"));
        // press refrsh button
        WebElement refreshTableButton = driver.findElement(By.id("refreshtable"));
        refreshTableButton.click();
    }
}
