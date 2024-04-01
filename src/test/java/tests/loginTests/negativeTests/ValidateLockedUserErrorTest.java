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
        driver.findElement(By.id("login-button")).click();
        WebElement text = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3"));
        String errorMessage = text.getText();
        if (errorMessage.equals("Epic sadface: Username and password do not match any user in this service")){
            System.out.println("Error message is valid: " + errorMessage);
        } else {
            System.out.println("Error message is invalid: " + errorMessage);
        }
        driver.quit();
    }

    @Test
    public void usernameIncorrectPasswordCorrect(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        fillUserInfo(driver,"incorrectUsername","secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement text = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3"));
        String errorMessage = text.getText();
        if (errorMessage.equals("Epic sadface: Username and password do not match any user in this service")){
            System.out.println("Error message is valid: " + errorMessage);
        } else {
            System.out.println("Error message is invalid: " + errorMessage);
        }
        driver.quit();
    }

    @Test
    public void usernameIncorrectPasswordIncorrect(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        fillUserInfo(driver,"incorrectUsername","secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement text = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3"));
        String errorMessage = text.getText();
        if (errorMessage.equals("Epic sadface: Username and password do not match any user in this service")){
            System.out.println("Error message is valid: " + errorMessage);
        } else {
            System.out.println("Error message is invalid: " + errorMessage);
        }
        driver.quit();
    }

    @Test
    public void usernameEmptyPasswordCorrect(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        fillUserInfo(driver,"","secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement text = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3"));
        String errorMessage = text.getText();
        if (errorMessage.equals("Epic sadface: Username is required")){
            System.out.println("Error message is valid: " + errorMessage);
        } else {
            System.out.println("Error message is invalid: " + errorMessage);
        }
        driver.quit();
    }

    @Test
    public void usernameCorrectPasswordEmpty(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        fillUserInfo(driver,"locked_out_user","");
        driver.findElement(By.id("login-button")).click();
        WebElement text = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3"));
        String errorMessage = text.getText();
        if (errorMessage.equals("Epic sadface: Password is required.")){
            System.out.println("Error message is valid: " + errorMessage);
        } else {
            System.out.println("Error message is invalid: " + errorMessage);
        }
        driver.quit();
    }

    @Test
    public void usernameEmptyPasswordEmpty(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        fillUserInfo(driver,"","");
        driver.findElement(By.id("login-button")).click();
        WebElement text = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3"));
        String errorMessage = text.getText();
        if (errorMessage.equals("Epic sadface: Username is required")){
            System.out.println("Error message is valid: " + errorMessage);
        } else {
            System.out.println("Error message is invalid: " + errorMessage);
        }
        driver.quit();
    }
    public static void fillUserInfo(WebDriver driver,String userName,String password){
        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
    }

}



