package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.utils;
public class SignInPage {

    static WebElement emailField = utils.driver.findElement(By.id("email"));
    static WebElement passwordField = utils.driver.findElement(By.id("passwd"));
    static WebElement signInButton = utils.driver.findElement(By.id("SubmitLogin"));
    static WebElement emailSignUpField = utils.driver.findElement(By.id("email_create"));
    static WebElement signUpButton = utils.driver.findElement(By.id("SubmitCreate"));
    public static void logIn(String email, String passwd){
        emailField.sendKeys(email);
        passwordField.sendKeys(utils.decode64(passwd));
        signInButton.click();
    }

    public void signUp(String email){
        emailSignUpField.sendKeys(email);
        signUpButton.click();
    }

}

