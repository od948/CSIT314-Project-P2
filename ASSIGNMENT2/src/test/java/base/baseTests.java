package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class baseTests {
    private WebDriver driver;
    private WebDriver tempdriver;
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ingore-certificate-errors");
        driver = new ChromeDriver(options);

        driver.get("https://www.ebay.com.au/");
        System.out.println("open ebay \n");

        driver.findElement(By.id("gh-ac")).click();
        driver.findElement(By.id("gh-ac")).sendKeys("asdf");
        driver.findElement(By.id("gh-btn")).submit();
        System.out.println("click search bar, enter 'asdf' and submit \n");


        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        System.out.println("current page: " + driver.getTitle());

        driver.quit();

        tempdriver = new ChromeDriver(options);


        tempdriver.get("https://www.ebay.com.au/itm/3X-Lightning-Data-Charger-Cable-Cord-Compatible-for-Apple-iPhone-5-6-S-7-8-X/153854545450?hash=item23d2720e2a:g:Qx8AAOSwnhFeYQ55");
        System.out.println("current page: " + tempdriver.getTitle());
        tempdriver.findElement(By.id("atcRedesignId_btn")).click();
        System.out.println("item added to cart");
        Thread.sleep(500);
        tempdriver.get("https://cart.payments.ebay.com.au/sc/view");
        System.out.println("cart opened");
        Thread.sleep(500);
        System.out.println("cart size = " + tempdriver.findElements(By.className("cart-bucket-lineitem")).size());
        Boolean isPresent = tempdriver.findElements(By.className("cart-bucket-lineitem")).size() > 0;
        while(isPresent){

            tempdriver.findElement(By.cssSelector("button[data-test-id='cart-remove-item']")).click();
            System.out.println("deleted first item" + "\n");
            if(tempdriver.findElements(By.className("cart-bucket-lineitem")).size() > 0) isPresent=false;
            Thread.sleep(500);
            System.out.println("cart size = " + tempdriver.findElements(By.className("cart-bucket-lineitem")).size());
        }
        tempdriver.quit();
    }
    public static void main(String args[]) throws InterruptedException {
        baseTests test = new baseTests();
        test.setUp();
    }
}
