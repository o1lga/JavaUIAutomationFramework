package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {

    public Page(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    // pentru a utiliza pagefactory pentru fiecare webelement trebuie sa definim elementul si tipul locatorului
    @FindBy(xpath = "//*[@id=\"top\"]/div/div[2]/ul/li[2]/div")
    protected WebElement userDropDownIcon;

    @FindBy(xpath = "//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[1]/a")
    protected WebElement registerOption;

    @FindBy(xpath = "//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[2]/a")
    protected WebElement loginOption;

    // metoda de instanta pentru a naviga la registerpage
    public void navigateToRegisterPage(){
        userDropDownIcon.click();
        registerOption.click();
        System.out.println("The Register option was selected from Header");
    }
    public void navigateToLoginPage(){
        userDropDownIcon.click();
        loginOption.click();
        System.out.println("The Login option was selected from Header");
    }
}
