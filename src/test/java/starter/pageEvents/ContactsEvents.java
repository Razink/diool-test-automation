package starter.pageEvents;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import starter.pageObjects.ProductOwnerElements.ContactsElements;
import starter.pageObjects.ProductOwnerElements.TransfersElements;
import java.awt.*;
import java.awt.event.KeyEvent;



public class ContactsEvents extends PageObject {


    public void AddNewContact(Actor actor, String paymentMethod, String profile) throws InterruptedException, AWTException {

        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        Robot robot = new Robot();

        System.out.println("Click on Add Contact Button");
        WebElementFacade addContact = find(By.xpath(ContactsElements.addContactBtn));
        addContact.waitUntilVisible().click();

        System.out.println("enter First Name : Contact");
        WebElementFacade firstName = find(By.xpath(ContactsElements.inputFirstName));
        firstName.waitUntilVisible();
        actor.attemptsTo(
                Enter.theValue("Contact").into(firstName)
                        .thenHit(Keys.ENTER)
        );


        if (paymentMethod.equals("Diool")) {

            System.out.println("enter Last Name : Diool");
            WebElementFacade lastName = find(By.xpath(ContactsElements.inputLastName));
            lastName.waitUntilVisible();
            actor.attemptsTo(
                    Enter.theValue("Diool").into(lastName)
                            .thenHit(Keys.ENTER)
            );

            System.out.println("Zoom out");
            for (int i = 0; i < 4; i++) {
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_SUBTRACT);
                robot.keyRelease(KeyEvent.VK_SUBTRACT);
                robot.keyRelease(KeyEvent.VK_CONTROL);
            }

            System.out.println("select Relationship with contact : Employee");
            Thread.sleep(3000);
            WebElementFacade radioEmployee = find(By.xpath(ContactsElements.selectEmployee));
            radioEmployee.waitUntilVisible();
            executor.executeScript("var clickEvent = document.createEvent('MouseEvents');clickEvent.initEvent ('click', true, true);arguments[0].dispatchEvent (clickEvent);", radioEmployee);

            System.out.println("Click on Payment Methods Button");
            WebElementFacade enablePaymeth = find(By.xpath(ContactsElements.paymentMethodBtn));
            enablePaymeth.waitUntilVisible();
            executor.executeScript("arguments[0].click();",enablePaymeth);

            System.out.println("Click on Diool choice as payment method");
            WebElementFacade clickDioolMethod = find(By.xpath(ContactsElements.selectDiool));
            clickDioolMethod.waitUntilVisible();
            executor.executeScript("arguments[0].click();",clickDioolMethod);


            if(profile.equals("Agent")) {
                System.out.println("enter Diool email : john.theagent@email.com");
                WebElementFacade dioolEmail = find(By.xpath(ContactsElements.inputDioolEmail));
                dioolEmail.waitUntilVisible();
                actor.attemptsTo(
                        Enter.theValue("john.theagent@email.com")
                                .into(dioolEmail)
                );
            }else{
                System.out.println("enter Diool email : roland.thecashier@email.com");
                WebElementFacade dioolEmail = find(By.xpath(ContactsElements.inputDioolEmail));
                dioolEmail.waitUntilVisible();
                actor.attemptsTo(
                        Enter.theValue("roland.thecashier@email.com")
                                .into(dioolEmail)
                );
            }
            System.out.println("click on add payment option");
            Thread.sleep(2000);
            WebElementFacade addPayMethOptionButton = find(By.xpath(ContactsElements.addPMBtn));
            addPayMethOptionButton.waitUntilVisible();
            executor.executeScript("arguments[0].click();",addPayMethOptionButton);

        } else {

            System.out.println("enter Last Name : Bank");
            WebElementFacade lastName = find(By.xpath(ContactsElements.inputLastName));
            lastName.waitUntilVisible();
            actor.attemptsTo(
                    Enter.theValue("Bank").into(lastName)
                            .thenHit(Keys.ENTER)
            );


            System.out.println("select Relationship with contact : Client");
            WebElementFacade radioClient = find(By.xpath(ContactsElements.selectClient));
            radioClient.waitUntilVisible();
            executor.executeScript("var clickEvent = document.createEvent('MouseEvents');clickEvent.initEvent ('click', true, true);arguments[0].dispatchEvent (clickEvent);", radioClient);

            System.out.println("Click on Payment Methods Button");
            WebElementFacade enablePaymeth = find(By.xpath(ContactsElements.paymentMethodBtn));
            enablePaymeth.waitUntilVisible();
            executor.executeScript("arguments[0].click();",enablePaymeth);

            System.out.println("Click on Bank account choice as payment method");
            WebElementFacade clickBankMethod = find(By.xpath(ContactsElements.selectBankAccount));
            clickBankMethod.waitUntilVisible();
            executor.executeScript("arguments[0].click();",clickBankMethod);

            System.out.println("enter the IBAN : 12345678912345678912345");
            WebElementFacade ibanInput = find(By.xpath(ContactsElements.inputIBAN));
            ibanInput.waitUntilVisible();
            actor.attemptsTo(
                    Enter.theValue("12345678912345678912345")
                            .into(ibanInput)
                            .thenHit(Keys.ENTER)
            );

            System.out.println("click on add payment option");
            Thread.sleep(3000);
            WebElementFacade addPayMethOptionButton = find(By.xpath(ContactsElements.addPMBtn));
            addPayMethOptionButton.waitUntilVisible();
            executor.executeScript("arguments[0].click();",addPayMethOptionButton);
        }

        System.out.println("click on Save button");
        WebElementFacade saveBtn = find(By.xpath(ContactsElements.saveBtn));
        WebElementFacade chechDiooolContact = find(By.xpath(ContactsElements.checkDioolAdded));
        chechDiooolContact.waitUntilVisible();
        executor.executeScript("arguments[0].click();",saveBtn);

        System.out.println("Click on close button");
        WebElementFacade closeBtn = find(By.xpath(ContactsElements.closeBtn));
        closeBtn.waitUntilVisible();
        executor.executeScript("arguments[0].click();",closeBtn);
    }

    public void sendMoneyAdressBook(Actor actor, String profile,String language) throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();

        if (profile.equals("Agent")) {
            System.out.println("Search for the diool contact who was added recently");
            Thread.sleep(2000);
            WebElementFacade search = find(By.xpath(TransfersElements.inputSearch));
            search.waitUntilVisible();
            actor.attemptsTo(
                    Enter.theValue("Contact Diool")
                            .into(search)
                            .thenHit(Keys.ENTER)
            );


        } else if (profile.equals("Cashier")) {
            System.out.println("Search for the Bank contact who was added recently");
            WebElementFacade search = find(By.xpath(ContactsElements.inputSearch));
            search.waitUntilVisible();
            actor.attemptsTo(
                    Enter.theValue("Contact Diool")
                            .into(search)
                            .thenHit(Keys.ENTER)
            );
        } else {
            System.out.println("Search for the Bank contact who was added recently");
            WebElementFacade search = find(By.xpath(ContactsElements.inputSearch));
            search.waitUntilVisible();
            actor.attemptsTo(
                    Enter.theValue("Contact Bank")
                            .into(search)
                            .thenHit(Keys.ENTER)
            );
        }

        System.out.println("Click option");
        WebElementFacade optionMenu = find(By.xpath(ContactsElements.selectOptions));
        element(optionMenu).waitUntilVisible();
        executor.executeScript("arguments[0].click();", optionMenu);

        System.out.println("Select Send money");
        WebElementFacade sendMoney = find(By.xpath(ContactsElements.selectSendMoney));
        sendMoney.waitUntilVisible();
        executor.executeScript("arguments[0].click();", sendMoney);

        System.out.println("Enter 1000 XAF as Amount");
        Thread.sleep(3000);
        WebElementFacade inputAmount = find(By.xpath(TransfersElements.inputAmount));
        inputAmount.waitUntilVisible();
        actor.attemptsTo(
                Enter.theValue("1000")
                        .into(inputAmount)
                        .thenHit(Keys.ENTER)
        );
        if (profile.equals("Agent")) {
            System.out.println("Verify fees value = 12 XAF");
            Thread.sleep(2000);
            WebElementFacade feeVal = find(By.xpath(TransfersElements.checkFeesValue));
            String feeValString = feeVal.getText();
            actor.attemptsTo(
                    Ensure.that(feeValString).isEqualToIgnoringCase("XAF 12")
            );
        } else if (profile.equals("Cashier")) {
            System.out.println("Verify fees value = 0 XAF");
            Thread.sleep(2000);
            WebElementFacade feeVal = find(By.xpath(TransfersElements.checkFeesValue));
            String feeValString = feeVal.getText();
            actor.attemptsTo(
                    Ensure.that(feeValString).isEqualToIgnoringCase("XAF 0")
            );

        } else {
            System.out.println("Verify fees value = 0 XAF");
            Thread.sleep(2000);
            WebElementFacade feeVal = find(By.xpath(TransfersElements.checkFeesValue));
            String feeValString = feeVal.getText();
            actor.attemptsTo(
                    Ensure.that(feeValString).isEqualToIgnoringCase("XAF 0")
            );
        }

        System.out.println("Click on Next button");
        WebElementFacade next = find(By.xpath(TransfersElements.nextBtn));
        next.waitUntilVisible();
        executor.executeScript("arguments[0].click();", next);

        if (profile.equals("Agent")){
            System.out.println("Check Total value = 1012 XAF");
        Thread.sleep(2000);
        WebElementFacade totalval = find(By.xpath(TransfersElements.checkTotalValue));
        String totalvalString = totalval.getText();
        actor.attemptsTo(
                Ensure.that(totalvalString).isEqualToIgnoringCase("1,012 XAF")
        );
    }else{
            System.out.println("Check Total value = 1000 XAF");
            Thread.sleep(2000);
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
        Thread.sleep(1000);

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
            WebElementFacade checkTransfStatus = find(By.xpath(TransfersElements.successfulPayVerif));
            checkTransfStatus.waitUntilVisible();
            String checkTransfStatusString = checkTransfStatus.getText();
            actor.attemptsTo(
                    Ensure.that(checkTransfStatusString).isEqualToIgnoringCase("Paiement réussi")
            );

        } else {
            System.out.println("Verify the Payment was successfully passed : Successful payment");
            WebElementFacade checkTransfStatus = find(By.xpath(TransfersElements.successfulPayVerif));
            checkTransfStatus.waitUntilVisible();
            String checkTransfStatusString = checkTransfStatus.getText();
            actor.attemptsTo(
                    Ensure.that(checkTransfStatusString).isEqualToIgnoringCase("Successful payment")
            );
        }

        System.out.println("Click Ok button to confirm transaction");
        WebElementFacade okSuccess = find(By.xpath(TransfersElements.okButtonConfirm));
        okSuccess.waitUntilVisible();
        executor.executeScript("arguments[0].click()",okSuccess);

    }

    public void deleteContact(Actor actor, String profile) throws InterruptedException {

        JavascriptExecutor executor =(JavascriptExecutor)getDriver();
        Thread.sleep(2000);

        System.out.println("Enter on Contacts table");
        WebElementFacade contactTable = find(By.xpath(ContactsElements.contactsTab));
        contactTable.waitUntilVisible();
        executor.executeScript("arguments[0].click();",contactTable);

        System.out.println("Close ChatBox if exist");
        Thread.sleep(2000);
        WebElementFacade close = find(By.xpath(TransfersElements.closePopup));
        if(close.isPresent()){
            executor.executeScript("arguments[0].click();", close);
            Thread.sleep(1000);
        } else {
            System.out.println("the chatbox already not displayed");
        }

        if (profile.equals("Cashier")){
            System.out.println("Search for the contact Contact Diool : Roland who was added recently");
            Thread.sleep(2000);
            WebElementFacade search = find(By.xpath(TransfersElements.inputSearch));
            search.waitUntilVisible();
            actor.attemptsTo(
                    Enter.theValue("Contact Diool")
                            .into(search)
                            .thenHit(Keys.ENTER)
            );


        } else if (profile.equals("Agent")){
            System.out.println("Search for the Bank contact who was added recently");
            WebElementFacade search = find(By.xpath(ContactsElements.inputSearch));
            search.waitUntilVisible();
            actor.attemptsTo(
                    Enter.theValue("Contact Diool")
                            .into(search)
                            .thenHit(Keys.ENTER)
            );
        } else {

            System.out.println("Search for the Bank contact who was added recently");
            WebElementFacade search = find(By.xpath(ContactsElements.inputSearch));
            search.waitUntilVisible();
            actor.attemptsTo(
                    Enter.theValue("Contact Bank")
                            .into(search)
                            .thenHit(Keys.ENTER));

        }

        System.out.println("Click option");
        WebElementFacade optionMenu = find(By.xpath(ContactsElements.selectOptions));
        element(optionMenu).waitUntilVisible();
        executor.executeScript("arguments[0].click();",optionMenu);


        System.out.println("Select Delete");
        WebElementFacade deleteContact = find(By.xpath(ContactsElements.selectDelete));
        deleteContact.waitUntilVisible();
        executor.executeScript("arguments[0].click();",deleteContact);

        System.out.println("Select Ok to confirm deleting");
        WebElementFacade clickOK = find(By.xpath(ContactsElements.okConfirmation));
        clickOK.waitUntilVisible();
        executor.executeScript("arguments[0].click();",clickOK);

        System.out.println("check Contact was successfully deleted");
        WebElementFacade checkContactdelete = find(ContactsElements.checkDelete);
        checkContactdelete.waitUntilNotVisible();

    }

}
