package starter.pageEvents;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import starter.pageObjects.LoginPageElements;


public class CommonEvents extends PageObject {

    @WhenPageOpens

    public void enterEmailAndPasswordId() throws InterruptedException {
        JavascriptExecutor executor =(JavascriptExecutor) getDriver();
        System.out.println("Enter Email and Password");
        Thread.sleep(3000);
        getDriver().findElement(By.id(LoginPageElements.emailUserNameID)).sendKeys("john.themanager@email.com");
        getDriver().findElement(By.id(LoginPageElements.passwordID)).sendKeys("M3Paris");

        System.out.println("Click on login button");
        Thread.sleep(1000);
        WebElement loginButton = getDriver().findElement(By.id(LoginPageElements.logInBtnID));
        executor.executeScript("arguments[0].click();", loginButton);

    }


    public void changeFRLanguage() throws InterruptedException {

        JavascriptExecutor executor =(JavascriptExecutor)getDriver();
        System.out.println("Change Fr Language");
        Thread.sleep(15000);
        WebElement languageMenu = getDriver().findElement(By.xpath(LoginPageElements.languageSelect));
        executor.executeScript("arguments[0].click();", languageMenu);
        Thread.sleep(2000);
        WebElement selectFR = getDriver().findElement(By.xpath(LoginPageElements.languageFR));
        executor.executeScript("arguments[0].click();", selectFR);


    }
}
