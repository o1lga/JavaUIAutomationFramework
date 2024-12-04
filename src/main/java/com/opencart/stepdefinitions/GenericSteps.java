package com.opencart.stepdefinitions;

import com.opencart.managers.ConfigurationReaderManager;
import com.opencart.managers.DriverManager;
import com.opencart.managers.ScrollManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Then("the URL contains the following keyword {string}")
    public void theURLContainsTheFollowingKeyword(String collectKeyword) throws InterruptedException {

        Thread.sleep(1000);
        boolean containsKeyword = driver.getCurrentUrl().contains(collectKeyword);
        Assertions.assertTrue(containsKeyword, "The url contains : " + collectKeyword);
    }

    @Given("The {string} endpoint is accessed")
    public void theIsAccessed(String endpoint) {
        String fullLink = ConfigurationReaderManager.getProperty("baseUrl") + endpoint;
        driver.get(fullLink);
        System.out.println("The accessed link is:" + fullLink);
    }

    @And("a thread sleep of {int} seconds is executed")
    public void aThreadSleepOfSecondsIsExecuted(int timeToBeSlept) {
        try {
            Thread.sleep(timeToBeSlept * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the following list of error messages is displayed:")
    public void theFollowingListOfErrorMessagesIsDisplayed(List<String> listOfErrors) throws InterruptedException {
        Thread.sleep(500);

        listOfErrors.forEach(errorMessage -> {
            boolean messageIsDisplayed = driver.findElement(By.xpath(".//*[contains(text(),'" +
                    errorMessage + "')]")).isDisplayed();
            Assertions.assertTrue(messageIsDisplayed, "The error message is displayed");
        });

    }

    @When("the {string} from {string} is clicked")
    public void theFromIsClicked(String clickableElement, String pageName) throws Exception {
        Class classIstance = Class.forName("com.opencart.pageobjects." + pageName);
        Field webclickableElementField = classIstance.getDeclaredField(clickableElement);
        webclickableElementField.setAccessible(true);
        WebElement webclickableElement = (WebElement) webclickableElementField.get(classIstance.getConstructor(WebDriver.class).newInstance(driver));
        ScrollManager.scrollToElement(webclickableElement);
        webclickableElement.click();

    }
}
