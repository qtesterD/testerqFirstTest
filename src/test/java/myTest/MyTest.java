package myTest;

import db.DbConection;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import myTest.pages.LoginPage;
import myTest.pages.Page;

import org.junit.*;
import org.openqa.selenium.WebDriver;


import static helper.Driver.initWebDriver;


@Epic("Web Application Regression Testing using JUnit4")
@Feature("Login Page Tests")
public class MyTest {


    private Page main;
    private WebDriver driver;
    private LoginPage loginPage;


    @Before
    public void initPages() {
        WebDriver driver = initWebDriver();
        this.driver = driver;
        main = new Page(driver);
        loginPage = new LoginPage(driver);

    }

    @After
    public void quitDriver() {
        try {
            Thread.sleep(3000);
            driver.quit();

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
//
//    @Test()
//    @Description("Test settings org")
//
//    public void test1(String url, String user, String pass) {
//        try (var conn = DbConection.open(url,
//                user,
//                pass)) {
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

    @Test()
    @Description("Test text error in incorrect data")
    public void test2() {
        loginPage.setPasswordField("jtjtjt");
        loginPage.setUserNameField("jtjtjt");
        loginPage.login();
        boolean isNotOK = loginPage.isIncorrectData();
        Assert.assertEquals(isNotOK, true);
    }

    @Test()
    @Description("Test sucsses login")
    public void test3() {
        main.stat();
    }


}
