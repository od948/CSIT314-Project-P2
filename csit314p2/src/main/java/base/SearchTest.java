package base;

//import junit.framework.Assert;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.text.ParseException;

public class SearchTest {
    private WebDriver driver;

    //Constructor
    public SearchTest(WebDriver wd){
        driver = wd;
    }



    //previous itteration random generation, now using random word from list of top ebay searches.
    /*
    public String randomStringGenerator(int length){
        String searchText = RandomStringUtils.randomAlphabetic(length);
        return searchText;
    }
    */


    //following method is a random word generator using a txtfile and rng to select a word to search.
    public String topsearch() {
        String tops = "";
        File file = new File("resources/topsearch.txt");
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int searchtotal = 0;
        while (scan.hasNextLine()) {
            scan.nextLine();
            searchtotal += 1;
        }
        Random r = new Random();
        double d = (r.nextInt(searchtotal) + 0);
        Scanner find = null;
        try {
            find = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int findint = 0;
        while (findint <= d) {
            if (findint == d){
                tops = find.nextLine();
                break;
            }else {
                find.nextLine();
                findint += 1;
            }
        }
        return tops;
    }

    public void searchResults(String keyWord, String randsearch) throws InterruptedException, ParseException {
        //print the keyword to the console
        System.out.println("keyword to search ebay for: " + keyWord);
        System.out.println("random word to search ebay for: " + randsearch + "\n");

        //tests the main basic search features of ebay.
        Thread.sleep(500);
        driver.findElement(By.id("gh-ac")).click();
        Thread.sleep(500);
        driver.findElement(By.id("gh-ac")).sendKeys(randsearch);
        Thread.sleep(500);
        driver.findElement(By.id("gh-btn")).submit();
        Thread.sleep(2500);
        System.out.println("Start test of search bar, using " + randsearch);
        System.out.println("current page: " + driver.getTitle());

        driver.get("https://www.ebay.com.au/sch/ebayadvsearch");
        driver.findElement(By.id("_nkw")).sendKeys(randsearch);
        driver.findElement(By.id("searchBtnUpperNoScript")).submit();
        Thread.sleep(500);
        System.out.println("searching for " + randsearch + " items found: " + (driver.findElement(By.className("rcnt"))).getText());
        if( (driver.getTitle()).contains(randsearch)){
            System.out.println(" TEST PASSED");
        } else {
            System.out.println(" TEST FAILED");
        }
        System.out.println();


        System.out.println("searching for: " + keyWord);
        int count = 0;

        //test some advanced search features of ebay
        System.out.println("Control test");
        driver.get("https://www.ebay.com.au/sch/ebayadvsearch");
        driver.findElement(By.id("_nkw")).sendKeys(keyWord);
        driver.findElement(By.id("searchBtnUpperNoScript")).submit();
        Thread.sleep(500);
        System.out.println("Basic search items found: " + (driver.findElement(By.className("rcnt"))).getText());
        if( (driver.getTitle()).contains(keyWord)){
            System.out.println(" TEST PASSED");
        } else {
            System.out.println(" TEST FAILED");
        }
        System.out.println();

        System.out.println("Test Condition = Not Specified");
        driver.get("https://www.ebay.com.au/sch/ebayadvsearch");
        driver.findElement(By.id("LH_ItemConditionNS")).click();
        driver.findElement(By.id("_nkw")).sendKeys(keyWord);
        driver.findElement(By.id("searchBtnUpperNoScript")).submit();
        Thread.sleep(500);
        System.out.println("condition= Not Specified, items found: " + (driver.findElement(By.className("rcnt"))).getText());
        if( (driver.getTitle()).contains(keyWord)){
            System.out.println(" TEST PASSED");
        } else {
            System.out.println(" TEST FAILED");
        }
        System.out.println();

        System.out.println("Test Condition = Used");
        driver.get("https://www.ebay.com.au/sch/ebayadvsearch");
        driver.findElement(By.id("LH_ItemConditionUsed")).click();
        driver.findElement(By.id("_nkw")).sendKeys(keyWord);
        driver.findElement(By.id("searchBtnUpperNoScript")).submit();
        Thread.sleep(500);
        System.out.println("condition= Used, items found: " + (driver.findElement(By.className("rcnt"))).getText());
        if( (driver.getTitle()).contains(keyWord)){
            System.out.println(" TEST PASSED");
        } else {
            System.out.println(" TEST FAILED");
        }
        System.out.println();

        System.out.println("Test Condition = New");
        driver.get("https://www.ebay.com.au/sch/ebayadvsearch");
        driver.findElement(By.id("LH_ItemConditionNew")).click();
        driver.findElement(By.id("_nkw")).sendKeys(keyWord);
        driver.findElement(By.id("searchBtnUpperNoScript")).submit();
        Thread.sleep(500);
        System.out.println("condition= New, items found: " + (driver.findElement(By.className("rcnt"))).getText());
        if( (driver.getTitle()).contains(keyWord)){
            System.out.println(" TEST PASSED");
        } else {
            System.out.println(" TEST FAILED");
        }
        System.out.println();

        System.out.println("Test Sale Type = Auction");
        driver.get("https://www.ebay.com.au/sch/ebayadvsearch");
        driver.findElement(By.id("LH_Auction")).click();
        driver.findElement(By.id("_nkw")).sendKeys(keyWord);
        driver.findElement(By.id("searchBtnUpperNoScript")).submit();
        Thread.sleep(500);
        System.out.println("Sell Type= Auction, items found: " + (driver.findElement(By.className("rcnt"))).getText());
        if( (driver.getTitle()).contains(keyWord)){
            System.out.println(" TEST PASSED");
        } else {
            System.out.println(" TEST FAILED");
        }
        System.out.println();

        System.out.println("Test Sale Type = Buy it now");
        driver.get("https://www.ebay.com.au/sch/ebayadvsearch");
        driver.findElement(By.id("LH_BIN")).click();
        driver.findElement(By.id("_nkw")).sendKeys(keyWord);
        driver.findElement(By.id("searchBtnUpperNoScript")).submit();
        Thread.sleep(500);
        System.out.println("Sell Type= Buy it now, items found: " + (driver.findElement(By.className("rcnt"))).getText());
        if( (driver.getTitle()).contains(keyWord)){
            System.out.println(" TEST PASSED");
        } else {
            System.out.println(" TEST FAILED");
        }
        System.out.println();

        System.out.println("Test Sale Type = Classified Ads");
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
        if( (driver.getTitle()).contains(keyWord)){
            System.out.println(" TEST PASSED");
        } else {
            System.out.println(" TEST FAILED");
        }
        System.out.println();

        return;
    }


    public static void main(String[] args){

    }
}
