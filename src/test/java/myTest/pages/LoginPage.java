package myTest.pages;

import helper.Base;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static helper.WaitingClass.waitResult;

public class LoginPage extends Base {

    @FindBy(xpath = "//*[@id=\"login-form-submit\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"login-form-username\"]")
    private WebElement userNameField;

    @FindBy(xpath = "//*[@id=\"login-form-password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"login-form\"]/div[1]/div[1]/p")
    private WebElement incorrectData;

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public void login() {
        System.out.println("Login Page1");
        String userName = getUserName();
        String password = getPassword();
        System.out.println("Login Page2" + getUserName().isEmpty());
        System.out.println("Page3" + getPassword().length());
        if (!password.isEmpty() && !userName.isEmpty()) {

                loginButton.click();
                waitResult();

                return;

        }

        setFormAndSubmit();

    }

    public void setFormAndSubmit() {
        setPasswordField();
        setUserNameField();
        loginButton.click();
    }

    public String getUserName() {
       return getValue(userNameField);
    }

    public String getPassword() {
        System.out.println(getValue(passwordField));
        return getValue(passwordField);
    }

    @Step("Ввести имя")
    public void setUserNameField() {
        userNameField.clear();
        userNameField.sendKeys("DMaltsev");
    }

    public void setUserNameField(String username) {
        userNameField.clear();
        userNameField.sendKeys(username);
    }

    public void setPasswordField() {
        passwordField.sendKeys("Bvlv%9r8?wZ!");
    }

    public void setPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public boolean isIncorrectData() {
        return incorrectData.getText().contains("Sorry, your username and password are incorrect - please try again.");
    }
}
