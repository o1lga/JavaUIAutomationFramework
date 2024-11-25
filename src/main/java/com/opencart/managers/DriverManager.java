package com.opencart.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private static String webDriverType = "Edge";
    private static DriverManager instance; //obiect al clasei drivermanager accesibila doar in clasa DriverManager
    private WebDriver driver;

//definim constructorul, accesibul doar in interiorul clasei deoarece este PRIVATE
    private DriverManager() {
        switch (webDriverType.toUpperCase()) {
            // toUpperCase este o metoda de instanta, aplicabila pentru obiectele de tip String,
            // returneaza stringul doar ca cu litere mari
            case "CHROME":
                //WebDriverManager.chromedriver().setup();
                //ChromeOptions options = new ChromeOptions();
                //options.addArguments("--remote-allow-origins=*");
                //driver = new ChromeDriver(options);
                driver = new ChromeDriver(); // driver - este obiect, si este initializat cu constructorul ChromeDriver
                System.out.println("The Chrome Driver was initiated!");
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                System.out.println("The FireFox Driver was initiated!");
                break;
            case "EDGE":
                driver = new EdgeDriver();
                System.out.println("The Edge Driver was initiated!");
                break;
            case "SAFARI":
                driver = new SafariDriver();
                System.out.println("The Safari Driver was initiated!");
                break;
            default:
                System.out.println("There is not defined such a driver: " + webDriverType);
        }
    }

    //Metoda statica pentru a obtine instanta Singleton
    //Este metoda publica, statica, returneaza instanta clasei DriverManager
    public static DriverManager getInstance(){
        if (instance == null){
            instance = new DriverManager(); // se initializeaza obiectul de tip DriverManager
        }
        return instance;
    } // poti sa creezi  doar o singura instanta a clasei respective si mereu o sa fie returnata doar acelasi obiect instanta

    //Metoda publica, de instanta pentru a obtine un obiect de tip webdriverul

    public WebDriver getDriver() { // getDriver este metoda de instanta
        if (driver == null) {
            getInstance(); //este o metoda statica definita in interiorul clasei DriverManager, putem apela aceasta metoda fara a scrie numele clasei
        }
        return driver;
    }
    public void quiteTheDriver(){
        driver.quit();
        driver = null;
        instance = null;
        System.out.println("The Driver is closed after running and completing a test scenario!");

    }

}
