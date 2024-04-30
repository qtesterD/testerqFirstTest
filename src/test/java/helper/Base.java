package helper;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {

    private WebDriver driver;

    private Actions actions;

    final int waitBeforeActions = getWaitBeforeActions();
    final int driverWaitTime = getDriverWaitTime();

    public Base(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterKey(Keys keys) {
        actions = new Actions(driver);
        actions.sendKeys(keys);
    }

    public int getWaitBeforeActions() {
        String sysSec = System.getProperty("DriverWaitTimeBeforeActions");
        int sec = 0;
        if (sysSec != null) {
            try {
                sec = Integer.parseInt(sysSec);
            } catch (Exception ex) {
                ex.printStackTrace();
                sec = 0;
            }

        }


        return sec;
    }

    public void click(final WebElement webElement) {
        if (waitBeforeActions > 0) {
            try {
                Thread.sleep(waitBeforeActions);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        waitVisibilityOfElement(webElement);
     /*   Random r = new Random();
        index = r.nextInt(sec);
        //      // switchToFrame();
        c.sleep(index);*/
        webElement.click();
        //    switchToDefaultFrame();
    }

    public Boolean waitVisibilityOfElement(final WebElement element) {
        //   // switchToFrame();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(driverWaitTime));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            //          switchToDefaultFrame();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //      switchToDefaultFrame();
        return false;
    }

    public int getDriverWaitTime() {
        int waitTime = 60;
        String drWt = System.getProperty("DriverWaitTime");
        if (drWt != null) {
            waitTime = Integer.parseInt(drWt);
        }

        return waitTime;
    }

    public boolean checkIsAuth() {
        String currentLocation = driver.getCurrentUrl();
        if (currentLocation.contains("login")) {
            return false;
        }
        return true;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getText(final WebElement webElement) {
        if (waitBeforeActions > 0) {
            try {
                Thread.sleep(waitBeforeActions);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        waitVisibilityOfElement(webElement);
        //   // switchToFrame();
        String text = webElement.getText();
        System.out.println("text = " + text + "text=" + webElement);
        //    switchToDefaultFrame();
        return text;
    }

    public String getValue(final WebElement webElement) {
        if (waitBeforeActions > 0) {
            try {
                Thread.sleep(waitBeforeActions);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        waitVisibilityOfElement(webElement);
        //   // switchToFrame();
        String text = webElement.getAttribute("value");
        System.out.println("text = " + text + "text=" + webElement);
        //    switchToDefaultFrame();
        return text;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

}
