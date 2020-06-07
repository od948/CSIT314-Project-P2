package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class baseTests {
    private WebDriver driver;
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://www.ebay.com.au/");
        WebElement searchbar = driver.findElement(By.id("gh-ac"));
        searchbar.click();
        searchbar.sendKeys("asdf");
        WebElement search = driver.findElement(By.id("gh-btn"));
        search.submit();


        System.out.println(driver.getTitle());
        //driver.quit();
    }
    public static void main(String args[]){
        baseTests test = new baseTests();
        test.setUp();
    }
}
