package com.opencart;

import com.opencart.managers.DataGeneratorManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.AccountPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class TestRegistrationFlowWithJunit {

    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;

    @BeforeAll
    public static void beforeAllTheTests(){
        System.out.println("This methods is run before all the tests from this class ");
    }

    @BeforeEach
    public void beforeEachTest(){

        driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
        registerPage = new RegisterPage(driver);

    }

    @Test
    @DisplayName("User is redirected to Account page when registering with valid data")

    public void registerFlowWithValidDataRedirectsTheUserToAccountPage() throws InterruptedException {
        //System.out.println("The test with empty instructions is executed");


        //Action on the Register page
        //Generate random data from email
        String randomEmail = DataGeneratorManager.getRandomEmail();
        registerPage.completeTheRegisterForm("Olga", "Cosneanu", randomEmail, "Password1234!");
        registerPage.enablePrivacyToggle();
        registerPage.clickOnContinueButton();

        Thread.sleep(2000);

        boolean urlContainSuccessKeyword = driver.getCurrentUrl().contains("success");
        Assertions.assertTrue(urlContainSuccessKeyword, "The URL of the page contain the Success keyword");


    }

    @Test
    @DisplayName("The user remains on the Register page when registering without accepting the terms and conditions")

    public void userRemainOnRegisterPageWhenRegisteringWithoutAcceptingPrivacyRules() throws InterruptedException {

        String randomEmail = DataGeneratorManager.getRandomEmail();
        registerPage.completeTheRegisterForm("Olga", "Cosneanu", randomEmail, "Password1234!");

        registerPage.clickOnContinueButton();
        Assertions.assertTrue(driver.getCurrentUrl().contains("register"), "The page url has the keyword register");


    }
    @Test
    @DisplayName("Navigate to Login Page from Register Page")
    public void navigateToLoginPageFromRegisterPage(){
        registerPage.navigateToLoginPage();
        Assertions.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @AfterEach
    public void afterEachTest(){
        DriverManager.getInstance().quiteTheDriver();
    }

    @AfterAll
    public static void afterAllTheTests(){
        System.out.println("This methods is executed after all the tests!");
    }
}
