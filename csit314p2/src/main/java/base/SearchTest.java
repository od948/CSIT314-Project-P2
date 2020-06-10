package base;

//import junit.framework.Assert;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;

public class SearchTest {
    private WebDriver driver;

    //Constructor
    public SearchTest(WebDriver wd){
        driver = wd;
    }



    public String randomStringGenerator(int length){
        String searchText = RandomStringUtils.randomAlphabetic(length);
        return searchText;
    }

    public int searchResults(String keyWord) throws InterruptedException, ParseException {
        //print the keyword to the console
        String randomword = randomStringGenerator(3);
        System.out.println("keyword to search ebay for: " + keyWord);
        System.out.println("random word to search ebay for: " + randomword);

        //tests the main basic search features of ebay.

        driver.findElement(By.id("gh-ac")).click();
        driver.findElement(By.id("gh-ac")).sendKeys(randomword);
        driver.findElement(By.id("gh-btn")).submit();
        System.out.println("test search bar, enters " + randomword + " and submit");
        ;
        if(driver.findElements(By.className("rcnt")).size() > 0) {

            System.out.println("searching for " + randomword + " items found: " + (driver.findElement(By.className("rcnt"))).getText());
        } else {
            System.out.println("searching for " + randomword + " items found: 0");
        }
        System.out.println("searching for: " + keyWord);
        int count = 0;

        //test some advanced search features of ebay

        driver.get("https://www.ebay.com.au/sch/ebayadvsearch");
        driver.findElement(By.id("_nkw")).sendKeys(keyWord);
        driver.findElement(By.id("searchBtnUpperNoScript")).submit();
        Thread.sleep(500);
        System.out.println("Basic search items found: " + (driver.findElement(By.className("rcnt"))).getText());

        driver.get("https://www.ebay.com.au/sch/ebayadvsearch");
        driver.findElement(By.id("LH_ItemConditionNS")).click();
        driver.findElement(By.id("_nkw")).sendKeys(keyWord);
        driver.findElement(By.id("searchBtnUpperNoScript")).submit();
        Thread.sleep(500);
        System.out.println("condition= Not Specified, items found: " + (driver.findElement(By.className("rcnt"))).getText());

        driver.get("https://www.ebay.com.au/sch/ebayadvsearch");
        driver.findElement(By.id("LH_ItemConditionUsed")).click();
        driver.findElement(By.id("_nkw")).sendKeys(keyWord);
        driver.findElement(By.id("searchBtnUpperNoScript")).submit();
        Thread.sleep(500);
        System.out.println("condition= Used, items found: " + (driver.findElement(By.className("rcnt"))).getText());

        driver.get("https://www.ebay.com.au/sch/ebayadvsearch");
        driver.findElement(By.id("LH_ItemConditionNew")).click();
        driver.findElement(By.id("_nkw")).sendKeys(keyWord);
        driver.findElement(By.id("searchBtnUpperNoScript")).submit();
        Thread.sleep(500);
        System.out.println("condition= New, items found: " + (driver.findElement(By.className("rcnt"))).getText());

        driver.get("https://www.ebay.com.au/sch/ebayadvsearch");
        driver.findElement(By.id("LH_Auction")).click();
        driver.findElement(By.id("_nkw")).sendKeys(keyWord);
        driver.findElement(By.id("searchBtnUpperNoScript")).submit();
        Thread.sleep(500);
        System.out.println("Sell Type= Auction, items found: " + (driver.findElement(By.className("rcnt"))).getText());

        driver.get("https://www.ebay.com.au/sch/ebayadvsearch");
        driver.findElement(By.id("LH_BIN")).click();
        driver.findElement(By.id("_nkw")).sendKeys(keyWord);
        driver.findElement(By.id("searchBtnUpperNoScript")).submit();
        Thread.sleep(500);
        System.out.println("Sell Type= Buy it now, items found: " + (driver.findElement(By.className("rcnt"))).getText());

        driver.get("https://www.ebay.com.au/sch/ebayadvsearch");
        driver.findElement(By.id("LH_CAds")).click();
        driver.findElement(By.id("_nkw")).sendKeys(keyWord);
        driver.findElement(By.id("searchBtnUpperNoScript")).submit();
        Thread.sleep(500);
        if((driver.findElements(By.className("rcnt"))).size() >0) {
            System.out.println("Sell Type= Classified Ads, items found: " + (driver.findElement(By.className("rcnt"))).getText());
        } else {
            System.out.println("Sell Type= Classified Ads, items found: 0");
        }
        //Get the number of results returned
        return count;
    }


    public static void main(String[] args){

    }
}

//---------------------TO-DO----------------//
/*
    There needs to be some tests to avoid expensive words error
    Would be nice if we can generate some meaningful words that could
    return more than 0 result.
 */