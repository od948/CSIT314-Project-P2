package base;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.text.ParseException;


public class baseTests {
    private WebDriver driver;
    public WebDriver getDriver(){
        return driver;
    }

    public void setUp() throws InterruptedException {
        //instantiate the googlechrome command drivers.
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        //allows chrome to run without opening a browser.
        //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ingore-certificate-errors");
        //drivers are the main object that selenium interacts with browsers with, this code opens a new window.
        driver = new ChromeDriver(options);

        //get opens url's
        driver.get("https://www.ebay.com.au/");
        System.out.println("Opening " + driver.getTitle());
        if(driver.getTitle() != null){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }



        //advanced search for water bottle


//        driver.quit();
    }

    public void quit(){
        driver.quit();
    }

    public static void main(String args[]) throws InterruptedException, ParseException {
        baseTests test = new baseTests();
        System.out.println("\n start open webpage test \n");
        test.setUp();
        System.out.println("\n start add to cart test \n");
        CartTest cart = new CartTest(test.getDriver());
        cart.addToCart();
        System.out.println("\n start remove from cart test \n");
        cart.removeFromCart();
        System.out.println("\n start advanced search tests \n");

        SearchTest search = new SearchTest(test.getDriver());
        String sendsearch = search.topsearch();
        search.searchResults("water bottle" , sendsearch);
        test.quit();

    }

}
