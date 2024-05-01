package myTest;

import db.DbConection;
import myTest.pages.LoginPage;
import myTest.pages.Page;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static helper.Driver.initWebDriver;


public class MyTest {


    private Page main;
    private WebDriver driver;
    private LoginPage loginPage;


    @BeforeClass
    public void initPages() {
        WebDriver driver = initWebDriver();
        this.driver = driver;
        main = new Page(driver);
        loginPage = new LoginPage(driver);

    }

    @AfterClass
    public void quitDriver() {
        try {
            Thread.sleep(3000);
            driver.quit();

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    //@Test()
    public void test1(String url, String user, String pass) {
        try (var conn = DbConection.open(url,
                user,
                pass)) {

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test()
    public void test2() {
        loginPage.setPasswordField("jtjtjt");
        loginPage.setUserNameField("jtjtjt");
        loginPage.login();
        boolean isNotOK = loginPage.isIncorrectData();
        Assert.assertEquals(isNotOK, true);
    }

    @Test()
    public void test3() {
        main.stat();
    }


}
