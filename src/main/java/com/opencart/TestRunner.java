package com.opencart;

import com.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        // declaram obiectul manager, se creaza un obiect manager de tip driver manager, carui i se atribuie instance
        DriverManager manager = DriverManager.getInstance();
        WebDriver driver = manager.getDriver();

        String currentWindowName = driver.getWindowHandle(); //returneaza numele driverului pe care ne aflam
        Thread.sleep(5000);
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://maven.apache.org/guides/mini/guide-repository-ssl.html");
        Thread.sleep(5000);
        driver.close();


        driver.switchTo().window(currentWindowName);
        manager.getDriver().get("https://www.opencart.com/");
        Thread.sleep(10000);
        driver.quit();

        System.out.println("The driver is closed");
    }
}