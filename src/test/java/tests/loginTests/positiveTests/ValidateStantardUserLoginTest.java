package tests.loginTests.positiveTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import org.testng.annotations.*;


public class ValidateStantardUserLoginTest {


    @Test
    public void ValidateStantardUserLogin(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        ArrayList<Integer> arrayList = new ArrayList<>();
        String[] users = {"problem_user", "performance_glitch_user", "error_user", "visual_user"};

        for (int i =0; i < users.length; i++) {
            WebElement userName = driver.findElement(By.id("user-name"));
            WebElement password = driver.findElement(By.id("password"));

            String user = users[i];
            userName.sendKeys(user);

            password.sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            String currentURL = driver.getCurrentUrl();
            WebElement pageTitle = driver.findElement(By.cssSelector(".title"));
            String title=pageTitle.getText();

            assert(currentURL).equals("https://www.saucedemo.com/inventory.html");
            assert(title).equals("Products");

            driver.navigate().back();
        }
        driver.quit();
    }
}