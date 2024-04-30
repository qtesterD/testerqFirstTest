package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

import java.util.concurrent.TimeUnit;

public class Driver {
    public static WebDriver driver;

    public static WebDriver initWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\worker\\AppData\\Local\\Chromium\\Application\\chrome.exe");
        options.addArguments("--incognito");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://fk.jira.lanit.ru/login.jsp?os_destination=%2Fbrowse%2FFCS-294875");

        return driver;
    }

    public static WebDriver initWebDriver(String path) {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\worker\\AppData\\Local\\Chromium\\Application\\chrome.exe");
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("path");

        return driver;
    }


}
