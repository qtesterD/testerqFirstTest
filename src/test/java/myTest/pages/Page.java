package myTest.pages;

import helper.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Page extends Base {

    @FindBy(xpath = "//*[@id=\"APjFqb\"]")
    private WebElement searchField;

    private LoginPage loginPage;

    public Page(WebDriver driver) {
        super(driver);
    }

    public void initPage(WebDriver driver){

    }

    public void stat() {
        boolean isAuth = checkIsAuth();

        if (!isAuth) {
            loginPage = new LoginPage(getWebDriver());
            loginPage.login();
        }

    }

}
