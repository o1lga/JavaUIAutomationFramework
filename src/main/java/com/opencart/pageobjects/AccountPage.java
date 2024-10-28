package com.opencart.pageobjects;

import com.opencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Page{

    public AccountPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[13]")
    private WebElement logOutBtn;

    public void clickOnLogOutButton(){
        ScrollManager.scrollToElement(logOutBtn);
        logOutBtn.click();
        System.out.println("The logOut btn was clicked");
    }
}
