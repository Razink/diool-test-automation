package starter.pageEvents;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import starter.pageObjects.ProductOwnerElements.ContactsElements;
import starter.pageObjects.ProductOwnerElements.TransfersElements;
import java.awt.*;
import java.awt.event.KeyEvent;


public class TransfersEvents extends PageObject {

    @WhenPageOpens
    public void verifyScreenTable(Actor actor,String screenTab) throws InterruptedException {
        JavascriptExecutor executor =(JavascriptExecutor)getDriver();
        Thread.sleep(25000);
        if(screenTab.equals("Transfers")) {
            System.out.println("Enter on Transfers table");
            WebElementFacade trSession = find(By.xpath(TransfersElements.transfersTabText));
            trSession.waitUntilVisible().click();

        } else  if(screenTab.equals("Contacts")){
            System.out.println("Enter on Contacts table");
            WebElementFacade contactTable = find(By.xpath(ContactsElements.contactsTab));
            contactTable.waitUntilVisible().click();
        }


        System.out.println("Close ChatBox");
        WebElementFacade close = find(By.xpath(TransfersElements.closePopup));
        close.waitUntilVisible();
        executor.executeScript("arguments[0].click();", close);
        Thread.sleep(1000);
    }


    public void sendMoneyTransfer(Actor actor, String profile, String language) throws InterruptedException, AWTException {
        JavascriptExecutor executor =(JavascriptExecutor)getDriver();
        Robot robot = new Robot();

        if (profile.equals("Agent")) {
            System.out.println("Input on search field : John DOE");
            WebElementFacade inpSearch = find(By.xpath(TransfersElements.inputSearch));
            inpSearch.waitUntilVisible();
            actor.attemptsTo(
                    Enter.theValue("John DOE")
                            .into(inpSearch)
                            .thenHit(Keys.ENTER)
            );

        }
        else {
            System.out.println("Input on search field : Roland Keyboard");
            WebElementFacade inpSearch = find(By.xpath(TransfersElements.inputSearch));
            inpSearch.waitUntilVisible();
            actor.attemptsTo(
                    Enter.theValue("Roland Keyboard")
                            .into(inpSearch)
                            .thenHit(Keys.ENTER)
            );
        }

        System.out.println("Zoom out");
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);}
        Thread.sleep(2000);
        System.out.println("Click on send button");
        WebElementFacade send = find(By.xpath(TransfersElements.sendBtn));
        send.waitUntilVisible();
        executor.executeScript("arguments[0].click();", send);

        System.out.println("Enter 1000 XAF as Amount");
        WebElementFacade inputAmount = find(By.xpath(TransfersElements.inputAmount));
        inputAmount.waitUntilVisible();
        actor.attemptsTo(
                Enter.theValue("1000").into(inputAmount)
        );


        if (profile.equals("Cashier")){
        System.out.println("Verify fees value = 0 XAF");
        Thread.sleep(2000);
        WebElementFacade feeVal = find(By.xpath(TransfersElements.checkFeesValue));
            String feeValString = feeVal.getText();
            actor.attemptsTo(
                    Ensure.that(feeValString).isEqualToIgnoringCase("XAF 0")
            );
        } else {
            System.out.println("Verify fees value = 12 XAF");
            Thread.sleep(2000);
            WebElementFacade feeVal = find(By.xpath(TransfersElements.checkFeesValue));
            String feeValString = feeVal.getText();
            actor.attemptsTo(
                   Ensure.that(feeValString).isEqualToIgnoringCase("XAF 12")
            );
        }
        System.out.println("Click on Next button");
        WebElementFacade next = find(By.xpath(TransfersElements.nextBtn));
        next.waitUntilVisible();
        executor.executeScript("arguments[0].click();",next);

        if (profile.equals("Agent")){
            System.out.println("Check Total value = 1012 XAF");
            Thread.sleep(3000);
            WebElementFacade totalval = find(By.xpath(TransfersElements.checkTotalValue));
            String totalvalString = totalval.getText();
            actor.attemptsTo(
                    Ensure.that(totalvalString).isEqualToIgnoringCase("1,012 XAF")
            );


        } else {
            System.out.println("Check Total value = 1000 XAF");
            Thread.sleep(3000);
            WebElementFacade totalval = find(By.xpath(TransfersElements.checkTotalValue));
            String totalvalString = totalval.getText();
            actor.attemptsTo(
                    Ensure.that(totalvalString).isEqualToIgnoringCase("1,000 XAF")
            );
        }


        System.out.println("Click on Send Button");
        WebElementFacade sennd = find(By.xpath(TransfersElements.send2Btn));
        sennd.waitUntilVisible();
        executor.executeScript("arguments[0].click();",sennd);

        System.out.println("Check if the same amount");
        WebElementFacade sameAmount = find(TransfersElements.sendAgainButton);
        if(sameAmount.isPresent()){
            executor.executeScript("arguments[0].click();",sameAmount);
            Thread.sleep(1000);
        } else {
            System.out.println("it's a new amount");
            Thread.sleep(1000);
        }

        if (language.equals("FR")){
            System.out.println("Verify the Payment was successfully passed : Paiement réussi");
            Thread.sleep(5000);
            WebElementFacade checkTransfStatus  = find(By.xpath(TransfersElements.successfulPayVerif));
            String checkStatusString = checkTransfStatus.getText();
            actor.attemptsTo(
                    Ensure.that(checkStatusString).isEqualToIgnoringCase("Paiement réussi")
            );

        } else {
            System.out.println("Verify the Payment was successfully passed : Successful payment");
            Thread.sleep(5000);
            WebElementFacade checkTransfStatus  = find(By.xpath(TransfersElements.successfulPayVerif));
            String checkStatusString = checkTransfStatus.getText();
            actor.attemptsTo(
                    Ensure.that(checkStatusString).isEqualToIgnoringCase("Successful payment")
            );

        }

        System.out.println("Click Ok button to confirm");
        WebElementFacade okSuccess = find(By.xpath(TransfersElements.okButtonConfirm));
        executor.executeScript("arguments[0].click()",okSuccess);

        System.out.println("Zoom in");
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_CONTROL);}

    }

}
