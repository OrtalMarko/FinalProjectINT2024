package tests.loginTests.negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ValidateLockedUserErrorTest {

    @Test
    public void usernameCorrectPasswordIncorrect(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        fillUserInfo(driver,"locked_out_user","passwordIncorrect");
        invalidLogin(driver);
    }

    @Test
    public void usernameIncorrectPasswordCorrect(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        fillUserInfo(driver,"incorrectUsername","secret_sauce");
        invalidLogin(driver);
    }

    @Test
    public void usernameIncorrectPasswordIncorrect(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        fillUserInfo(driver,"incorrectUsername","secret_sauce");
        invalidLogin(driver);
    }

    @Test
    public void usernameEmptyPasswordCorrect(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        fillUserInfo(driver,"","secret_sauce");
        invalidLogin(driver);
    }

    @Test
    public void usernameCorrectPasswordEmpty(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        fillUserInfo(driver,"locked_out_user","");
        invalidLogin(driver);
    }

    @Test
    public void usernameEmptyPasswordEmpty(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        fillUserInfo(driver,"","");
        invalidLogin(driver);
    }

    public static void fillUserInfo(WebDriver driver,String userName,String password){
        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public  static  void  invalidLogin(WebDriver driver){
        driver.findElement(By.id("login-button")).click();

        WebElement text = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3"));
        String errorMessage = text.getText();
        if (errorMessage.equals("Epic sadface: user has been locked out.")){
            System.out.println("Error: " + errorMessage);
        } else {
            System.out.println("You might get this message: Epic sadface: Username and password do not match.");
        }
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("password")).clear();
        try {
            Thread.sleep(1000); // 1000 milliseconds = 1 second
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}



