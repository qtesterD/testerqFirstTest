package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Driver {
    public static WebDriver driver;
    private static ChromeDriverService service;

    public static WebDriver initWebDriver() {
        service = new ChromeDriverService.Builder().usingAnyFreePort().build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ChromeOptions options = new ChromeOptions();
        //options.setBinary("C:\\Users\\worker\\AppData\\Local\\Chromium\\Application\\chrome.exe");
        options.addArguments("--incognito");
        driver = new RemoteWebDriver(service.getUrl(), options);

        // driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://fk.jira.lanit.ru/login.jsp?os_destination=%2Fbrowse%2FFCS-294875");

        return driver;
    }

    public static WebDriver initWebDriver(String path) {
        ChromeOptions options = new ChromeOptions();
        //options.setBinary("C:\\Users\\worker\\AppData\\Local\\Chromium\\Application\\chrome.exe");
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("path");

        return driver;
    }

    @AfterClass
    public static void stopService() {

        service.stop();

    }


}
