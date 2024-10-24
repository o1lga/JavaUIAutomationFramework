package com.opencart;

import com.opencart.managers.DataGeneratorManager;
import com.opencart.managers.DriverManager;
import com.opencart.managers.ScrollManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        // declaram obiectul manager, se creaza un obiect manager de tip driver manager, carui i se atribuie instance
        DriverManager manager = DriverManager.getInstance();
        WebDriver driver = manager.getDriver();

        String currentWindowName = driver.getWindowHandle(); //returneaza numele driverului pe care ne aflam
        //Thread.sleep(5000);
        driver.switchTo().newWindow(WindowType.TAB);

        //Tema2
        //Folosim metoda de instanta get() pentru a naviga catre pagina web
        driver.get("https://tekwillacademy-opencart.online/");
        //Folosim metoda getCurrentUrl() astfel incit sa obtinem adresa curenta pe care o gestioneaza driverul
        System.out.println("The current url is: " + driver.getCurrentUrl());
        System.out.println("The current page title " + driver.getTitle());


        //Declaram si initializam elementul in baza locatorului xpath
        WebElement userDropDownIcon = driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[2]/ul/li[2]/div"));
        //Executam un click asupra elementului prin click() - metoda de instanta
        userDropDownIcon.click();

        //Elementul registerButton a fost initializat cu ajutorul unui locator de tip css, preluat din SelectorHub
        WebElement registerOption = driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[1]/a"));
        registerOption.click();
        System.out.println("The current url is: " + driver.getCurrentUrl());
        System.out.println("The current page title " + driver.getTitle());

        //Pentru a scrie date intr-un element, vom folosi metoda sendKeys(String datele)
        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys("Gabriel");

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys("Burlaca");

        WebElement emailInput = driver.findElement(By.id("input-email"));
        String emailData = DataGeneratorManager.getRandomEmail();
        emailInput.sendKeys(emailData);
        System.out.println("Email:" + emailData);

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        String password = DataGeneratorManager.getRandomPassword(10, 15);
        passwordInput.sendKeys(password);
        System.out.println("Password: " + password);

        WebElement privacyToggle = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
        ScrollManager.scrollToElement(privacyToggle);
        privacyToggle.click();

        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();


        Thread.sleep(500);
        System.out.println("The current url is: " + driver.getCurrentUrl());
        System.out.println("The current page title " + driver.getTitle());
        driver.close();

        driver.switchTo().window(currentWindowName);
        driver.get("https://tekwillacademy-opencart.online/");
        driver.quit();


        //driver.switchTo().window(currentWindowName);
        //manager.getDriver().get("https://www.opencart.com/");
        //Thread.sleep(10000);
        //driver.quit();

        System.out.println("The driver is closed");
    }
}