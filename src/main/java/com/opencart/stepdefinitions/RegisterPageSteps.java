package com.opencart.stepdefinitions;

import com.opencart.managers.DataGeneratorManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @And("the Register form is populated with data")
    public void theRegisterFormIsPopulatedWithData() {
        String randomEmail = DataGeneratorManager.getRandomEmail();
        registerPage.completeTheRegisterForm("Olga", "Cosneanu", randomEmail, "Password1234!");

    }

    @And("the Privacy Toggle bar is enabled")
    public void thePrivacyToggleBarIsEnabled() {
        registerPage.enablePrivacyToggle();
    }

    @When("the continueButton is clicked")
    public void theContinueButtonIsClicked() {
        registerPage.clickOnContinueButton();
    }

    @And("the Register form is populated with data as following:")
    public void theRegisterFormIsPopulatedWithDataAsFollowing(Map<String, String> userDetailsMap) {
        String firstNameValue = userDetailsMap.get("firstName");
        if (firstNameValue != null && firstNameValue.toUpperCase().equals("RANDOM")) {
            firstNameValue = DataGeneratorManager.getRandomFirstName();
        }

        String lastNameValue = userDetailsMap.get("lastName");
        if (lastNameValue != null && lastNameValue.toUpperCase().equals("RANDOM")){
            lastNameValue = DataGeneratorManager.getRandomName();
        }

        String emailValue = userDetailsMap.get("email");
        if (emailValue != null && emailValue.toUpperCase().equals("RANDOM")){
            emailValue = DataGeneratorManager.getRandomEmail();
        }

        String passwordValue = userDetailsMap.get("password");
        if (passwordValue != null && passwordValue.toUpperCase().equals("RANDOM")){
            passwordValue = DataGeneratorManager.getRandomPassword(4,20);
        }
        registerPage.completeTheRegisterForm(firstNameValue, lastNameValue, emailValue, passwordValue);
    }
}
