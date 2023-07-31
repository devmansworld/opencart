import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class CartTest {
    private WebDriver driver;

    public void setup() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/nix/IdeaProjects/javascrapers-main/Cuncuna/resources/chromedriver");


        // Create ChromeOptions and add the necessary flags
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");

        // Create a new instance of ChromeDriver with the ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Maximize the browser window
        driver.manage().window().maximize();
        // Maximize the browser window
        driver.manage().window().maximize();
    }

    public void openCartPage() {
        // Navigate to the cart page (replace "https://example.com/cart" with your URL)
        driver.get("http://opencart.abstracta.us");
    }

    public void scrollPage() {
        // Scroll down to the bottom of the page
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Scroll back to the top of the page
        jsExecutor.executeScript("window.scrollTo(0, 0)");
    }

    public int searchAndCountOccurrences(String searchText) {
        // Perform a search by typing the given text into the search bar
        WebElement searchBar = driver.findElement(By.id("search-bar"));
        searchBar.sendKeys(searchText);

        // Click on the search button
        WebElement searchButton = driver.findElement(By.id("search-button"));
        searchButton.click();

        // Wait for a brief moment to allow the search results to load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find all occurrences of the given text on the page
        List<WebElement> searchResults = driver.findElements(By.xpath("//*[contains(text(), '" + searchText + "')]"));

        // Get the quantity of occurrences
        return searchResults.size();
    }

    public void addToCart(String product) {
        // Find and click the "Add to Cart" button for the specified product
        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(), '" + product + "')]/following-sibling::button[text()='Add to Cart']"));
        addToCartButton.click();
    }

    public void openCart() {
        // Find and click the "Cart" button to open the cart page
        WebElement cartButton = driver.findElement(By.id("cart-button"));
        cartButton.click();
    }

    public void deleteProductFromCart(String productName) {
        // Find and click the "Delete" button for the specified product in the cart
        WebElement deleteButton = driver.findElement(By.xpath("//td[text()='" + productName + "']/following-sibling::td/button[text()='Delete']"));
        deleteButton.click();

        // Click "Yes" in the confirmation dialog to confirm deletion
        WebElement confirmButton = driver.findElement(By.id("confirm-button"));
        confirmButton.click();
    }

    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
