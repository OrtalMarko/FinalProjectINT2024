package tests.sanityTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class BuyProductTest {

    @Test
    public void testMethod2() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        //store all the relevant website locators
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();

        String currentURL = driver.getCurrentUrl();

        if(!currentURL.equals("https://www.saucedemo.com/inventory.html"))
        {
            System.out.println("Url is invalid, expected inventory.html");
        }
        else {
            System.out.println("successfully login ");

            WebElement pageTitle = driver.findElement(By.cssSelector(".title"));
            String title=pageTitle.getText();
            if (!title.equals("Products")) {
                System.out.println("Page title is invalid");
            } else {
                System.out.println("Page title is valid");
                WebElement addToCartFirstItem = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
                addToCartFirstItem.click();

                WebElement addToCartSecondItem = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
                addToCartSecondItem.click();

                WebElement cartBadge = driver.findElement(By.cssSelector(".shopping_cart_badge"));
                String cartItemsCountText = cartBadge.getText();
                assert (cartItemsCountText).equals("2");

                cartBadge.click();

                currentURL = driver.getCurrentUrl();
                assert (currentURL).equals("https://www.saucedemo.com/cart.html");

                WebElement checkoutButton = driver.findElement(By.id("checkout"));
                checkoutButton.click();

                currentURL = driver.getCurrentUrl();
                pageTitle = driver.findElement(By.cssSelector(".title"));
                title=pageTitle.getText();

                assert(currentURL).equals("https://www.saucedemo.com/checkout-step-one.html");
                assert(title).equals("Checkout: Your Information");

                WebElement firstName = driver.findElement(By.id("first-name"));
                WebElement lastName = driver.findElement(By.id("last-name"));
                WebElement postalCode = driver.findElement(By.id("postal-code"));

                firstName.sendKeys("Ortal");
                lastName.sendKeys("Marko");
                postalCode.sendKeys("7575418");

                WebElement continueButton=driver.findElement(By.id("continue"));
                continueButton.click();

                currentURL = driver.getCurrentUrl();
                pageTitle = driver.findElement(By.cssSelector(".title"));
                title=pageTitle.getText();

                assert (currentURL).equals("https://www.saucedemo.com/checkout-step-two.html");
                assert(title).equals("Checkout: Overview");

                WebElement finishButton= driver.findElement(By.id("finish"));
                finishButton.click();


                currentURL = driver.getCurrentUrl();
                pageTitle = driver.findElement(By.cssSelector(".title"));
                title=pageTitle.getText();

                assert (currentURL).equals("https://www.saucedemo.com/checkout-complete.html");
                assert(title).equals("Checkout: Complete!");

                WebElement compleateHeader= driver.findElement(By.cssSelector(".complete-header"));
                WebElement compleateText= driver.findElement(By.cssSelector(".complete-text"));

                assert(compleateHeader.getText()).equals("Thank you for your order!");
                assert(compleateText.getText()).equals("Your order has been dispatched, and will arrive just as fast as the pony can get there!!");

                driver.quit();

            }
        }
    }
}