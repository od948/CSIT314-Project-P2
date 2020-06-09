
package base;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;

public class CartTest {
    private WebDriver driver;

    //Constructor
    public CartTest(WebDriver wd){
        driver = wd;
    }

    //Function for adding an item to cart
    public void addToCart() throws InterruptedException {

        // opens a specific product to test the cart
        driver.get("https://www.ebay.com.au/itm/3X-Lightning-Data-Charger-Cable-Cord-Compatible-for-Apple-iPhone-5-6-S-7-8-X/153854545450?hash=item23d2720e2a:g:Qx8AAOSwnhFeYQ55");
        System.out.println("current page: " + driver.getTitle());
        //tests add to cart button
        driver.findElement(By.id("atcRedesignId_btn")).click();
        System.out.println("item added to cart");
        Thread.sleep(1500);
        //opens cart
        driver.get("https://cart.payments.ebay.com.au/sc/view");
        System.out.println("cart opened");
        Thread.sleep(1500);
        //reports cart size, testing if add to cart worked
        System.out.println("cart size = " + driver.findElements(By.className("cart-bucket-lineitem")).size());

        //driver.quit();
    }

    //function for removing an item from cart
    public void removeFromCart() throws InterruptedException {
        Boolean isPresent = driver.findElements(By.className("cart-bucket-lineitem")).size() > 0;
        while(isPresent){

            driver.findElement(By.cssSelector("button[data-test-id='cart-remove-item']")).click();
            System.out.println("deleted first item");
            if(driver.findElements(By.className("cart-bucket-lineitem")).size() > 0) isPresent=false;
            Thread.sleep(1500);
            System.out.println("cart size = " + driver.findElements(By.className("cart-bucket-lineitem")).size());
        }
    }

    public static void main(String[] args){

    }
}
