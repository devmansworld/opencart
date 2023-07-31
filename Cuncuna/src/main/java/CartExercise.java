import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CartExercise {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/nix/IdeaProjects/javascrapers-main/Cuncuna/resources/webdriver");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the cart page (URL)
        driver.get("http://opencart.abstracta.us");

        // Scroll down to the bottom of the page
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Scroll back to the top of the page
        jsExecutor.executeScript("window.scrollTo(0, 0)");

        // Perform a search by typing "tennis ball" (or any other word) into the search bar
        WebElement searchBar = driver.findElement(By.id("search"));
       // #//*[@id="search"]/input
        searchBar.sendKeys("tennis ball");

        // Click on the search button
        WebElement searchButton = driver.findElement(By.className("input-group-btn"));
        searchButton.click();

        // Wait for a brief moment to allow the search results to load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find all occurrences of the word "tennis ball" (or any other word) on the page
        List<WebElement> searchResults = driver.findElements(By.xpath("//*[contains(text(), 'tennis ball')]"));

        // Get the quantity of occurrences
        int occurrences = searchResults.size();

        // Print the results
        System.out.println("The word 'tennis ball' appears " + occurrences + " times on the page.");

        // Close the browser
        driver.quit();
    }
}
