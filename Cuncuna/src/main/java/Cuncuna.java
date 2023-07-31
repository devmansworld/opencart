import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
public class Cuncuna{
        public static void main(String[] args) throws InterruptedException {
            String correofeis = "";
            String correopass = "";
            System.setProperty("webdriver.chrome.driver", "/Users/nix/IdeaProjects/javascrapers-main/Cuncuna/resources/chromedriver");
            // Create ChromeOptions and add the necessary flags
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-web-security");
            options.addArguments("--allow-running-insecure-content");

            // Create a new instance of ChromeDriver with the ChromeOptions
            WebDriver driver = new ChromeDriver(options);

            // Maximize the browser window
            driver.manage().window().maximize();

            driver.get("http://opencart.abstracta.us");

            driver.close();
            driver.quit();
        }
    }










