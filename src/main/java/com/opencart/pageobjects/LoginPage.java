package com.opencart.pageobjects;

import com.opencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver){
        super(driver);
    }
    @FindBy(id = "input-email")
    private WebElement usernameInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"form-login\"]/div[3]/button")
    private WebElement loginButton;

    public void completeTheLoginForm(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        System.out.println("The login form was populated with data");
    }

}
