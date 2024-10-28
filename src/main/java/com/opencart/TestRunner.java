package com.opencart;

import com.opencart.managers.DataGeneratorManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.AccountPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");
        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickOnContinueButton();
        String randomEmail = DataGeneratorManager.getRandomEmail();
        registerPage.completeTheRegisterForm("Olga", "Cosneanu", randomEmail, "Password1234!");
        registerPage.enablePrivacyToggle();
        Thread.sleep(5000);
        registerPage.clickOnContinueButton();

        Thread.sleep(2000);

        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickOnLogOutButton();

        Thread.sleep(2000);

        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.completeTheLoginForm(randomEmail, "Password1234!");
        Thread.sleep(5000);
        loginPage.clickOnContinueButton();

        driver.quit();
        System.out.println("The test is finished and the driver is closed");
    }
}