package starter.pageEvents;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import starter.pageObjects.commun.HistoryElements;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.ParseException;


public class HistoryEvents extends PageObject {


    public void verifyTransactionView(Actor actor, String language, String transType) throws InterruptedException, AWTException {
        Robot robot = new Robot();
        JavascriptExecutor executor =(JavascriptExecutor)getDriver();

        System.out.println("Click on History menu");
        Thread.sleep(5000);
        WebElementFacade historyMenusession = find(By.xpath(HistoryElements.historyMenu));
        historyMenusession.waitUntilVisible();
        executor.executeScript("arguments[0].click();", historyMenusession);

        System.out.println("Navigate to Transaction view");
        WebElementFacade transacView = find(By.xpath(HistoryElements.transactionView));
        transacView.waitUntilVisible();
        executor.executeScript("arguments[0].click();", transacView);

        System.out.println("Zoom Out");
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);}


        if (transType.equals("Diool Transfer")) {

            System.out.println("Check Transaction Type: Diool Transfer");
            WebElementFacade trType = find(By.xpath(HistoryElements.getTransactionType));
            trType.waitUntilVisible();
            String trTypeString = trType.getText();
            actor.attemptsTo(
                    Ensure.that("Diool Transfer").isEqualToIgnoringCase(trTypeString)
            );

            System.out.println("Check Sender or Beneficiary: Another New Co - John DOE");
//            Thread.sleep(2000);
            WebElementFacade senderOrBenef = find(By.xpath(HistoryElements.getBeneficiary));
            senderOrBenef.waitUntilVisible();
            String senderOrBenefString = senderOrBenef.getText();
            actor.attemptsTo(
                    Ensure.that("Another New Co - John DOE").isEqualToIgnoringCase(senderOrBenefString)
            );
//            Assert.assertEquals(senderOrBenef.getText(), "Another New Co - John DOE");

            System.out.println("Check Sender or Beneficiary Profil: agent");
//            Thread.sleep(2000);
            WebElementFacade senderOrBenefProf = find(By.xpath(HistoryElements.getBeneficiaryProfil));
            senderOrBenefProf.waitUntilVisible();
            String senderOrBenefProfString = senderOrBenefProf.getText();
            actor.attemptsTo(
                    Ensure.that("agent").isEqualToIgnoringCase(senderOrBenefProfString)
            );
//            Assert.assertEquals(senderOrBenefProf.getText(),"agent");

            System.out.println("Check fees Value: -12");
//            Thread.sleep(2000);
            WebElementFacade feesValue = find(By.xpath(HistoryElements.getAmountfees));
            feesValue.waitUntilVisible();
            String feesValueString = feesValue.getText();
            actor.attemptsTo(
                    Ensure.that("-12").isEqualToIgnoringCase(feesValueString)
            );
//            Assert.assertEquals(feesValue.getText(),"-12");

        }else if(transType.equals("Internal Transfer")){

            if(language.equals("FR")){
                System.out.println("Check Transaction Type: Transfert interne");
//                Thread.sleep(2000);
                WebElementFacade trType = find(By.xpath(HistoryElements.getTransactionType));
                trType.waitUntilVisible();
                String trTypeString = trType.getText();
                actor.attemptsTo(
                        Ensure.that("Transfert interne").isEqualToIgnoringCase(trTypeString)
                );

//                Assert.assertEquals(trType.getText(),"Transfert interne");

                System.out.println("Check Direction: envoyé");
//                Thread.sleep(2000);
                WebElementFacade direction = find(By.xpath(HistoryElements.getDirection));
                direction.waitUntilVisible();
                String directiontring = direction.getText();
                actor.attemptsTo(
                        Ensure.that("Envoyé").isEqualToIgnoringCase(directiontring)
                );


            } else {
                System.out.println("Check Transaction Type: Internal Transfer");
//                Thread.sleep(2000);
                WebElementFacade trType = find(By.xpath(HistoryElements.getTransactionType));
                trType.waitUntilVisible();
                String trTypeString = trType.getText();
                actor.attemptsTo(
                        Ensure.that("Internal Transfer").isEqualToIgnoringCase(trTypeString)
                );


                System.out.println("Check Direction: Outgoing");
                WebElementFacade direction = find(By.xpath(HistoryElements.getDirection));
                direction.waitUntilVisible();
                String directionString = direction.getText();
                actor.attemptsTo(
                        Ensure.that("Outgoing").isEqualToIgnoringCase(directionString)
                );
//                Assert.assertEquals(direction.getText(),"Outgoing");
            }


            System.out.println("Check Sender or Beneficiary Profil: cashier");
//            Thread.sleep(2000);
            WebElementFacade senderOrBenefProf = find(By.xpath(HistoryElements.getBeneficiaryProfil));
            senderOrBenefProf.waitUntilVisible();
            String senderOrBenefProfString = senderOrBenefProf.getText();
            actor.attemptsTo(
                    Ensure.that("cashier").isEqualToIgnoringCase(senderOrBenefProfString)
            );


            System.out.println("Check fees Value: 0");
//            Thread.sleep(2000);
            WebElementFacade feesValue = find(By.xpath(HistoryElements.getAmountfees));
            String feesValueString = feesValue.getText();
            actor.attemptsTo(
                    Ensure.that("0").isEqualToIgnoringCase(feesValueString)
            );

        }

        System.out.println("Check User: Serge BOUPDA");
//        Thread.sleep(2000);
        WebElementFacade user = find(By.xpath(HistoryElements.getUser));
        user.waitUntilVisible();
        String userString = user.getText();
        actor.attemptsTo(
                Ensure.that("Serge BOUPDA").isEqualToIgnoringCase(userString)
        );



        System.out.println("Check Amount Value: 1,000");
//        Thread.sleep(2000);
        WebElementFacade amount = find(By.xpath(HistoryElements.getAmount));
        amount.waitUntilVisible();
        String amountString = amount.getText();
        actor.attemptsTo(
                Ensure.that("1,000").isEqualToIgnoringCase(amountString)
        );




        System.out.println("Check Status: Success");
//        Thread.sleep(2000);
        WebElementFacade status = find(By.xpath(HistoryElements.getStatus));
        status.waitUntilVisible();
        String statusString = status.getText();
        actor.attemptsTo(
                Ensure.that("Success").isEqualToIgnoringCase(statusString)
        );



        System.out.println("Zoom in");
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_CONTROL);}

    }


    public void verifyLedgerViewDeposit(Actor actor, String language,String transType) throws InterruptedException, AWTException, ParseException {
        Robot robot = new Robot();
        JavascriptExecutor executor =(JavascriptExecutor) getDriver();

        System.out.println("Navigate to Ledger view");
        WebElementFacade depositLedgerView = find(By.xpath(HistoryElements.ledgerView));
        depositLedgerView.waitUntilVisible();
        executor.executeScript("arguments[0].click();",depositLedgerView);

        System.out.println("Click on deposit Ledger");
        WebElementFacade depsitMenu = find(By.xpath(HistoryElements.depositLedger));
        depsitMenu.waitUntilVisible();
        executor.executeScript("arguments[0].click()",depsitMenu);


        if (transType.equals("Diool Transfer")){
            System.out.println("Check Transaction Type: Diool Transfer");
            WebElementFacade transTypeDepo = find(By.xpath(HistoryElements.getTransactionType));
            transTypeDepo.waitUntilVisible();
            String transTypeDepoString = transTypeDepo.getText();
            actor.attemptsTo(
                    Ensure.that("Diool Transfer").isEqualToIgnoringCase(transTypeDepoString)
            );


            System.out.println("Check Sender or Beneficiary: John DOE");
            Thread.sleep(2000);
            WebElementFacade senderOrBenef = find(By.xpath(HistoryElements.getLedgerSenderBeneficiary));
            String senderOrBenefString = senderOrBenef.getText();
            actor.attemptsTo(
                    Ensure.that("John DOE").isEqualToIgnoringCase(senderOrBenefString)
            );



            System.out.println("Check Sender or Beneficiary Profil: agent");
            Thread.sleep(2000);
            WebElementFacade senderOrBenefProf = find(By.xpath(HistoryElements.getLedgerSenderBeneficiaryProfil));
            senderOrBenefProf.waitUntilVisible();
            String senderOrBenefProfString = senderOrBenefProf.getText();
            actor.attemptsTo(
                    Ensure.that("agent").isEqualToIgnoringCase(senderOrBenefProfString)
            );


        } else {

            System.out.println("Check Sender or Beneficiary: Roland Keyboard");
            Thread.sleep(2000);
            WebElementFacade senderOrBenef = find(By.xpath(HistoryElements.getLedgerSenderBeneficiary));
            senderOrBenef.waitUntilVisible();
            String senderOrBenefString = senderOrBenef.getText();
            actor.attemptsTo(
                    Ensure.that("Roland Keyboard").isEqualToIgnoringCase(senderOrBenefString)
            );


            System.out.println("Check Sender or Beneficiary Profil: cashier");
//            Thread.sleep(2000);
            WebElementFacade senderOrBenefProf = find(By.xpath(HistoryElements.getLedgerSenderBeneficiaryProfil));
            senderOrBenefProf.waitUntilVisible();
            String senderOrBenefProfString = senderOrBenefProf.getText();
            actor.attemptsTo(
                    Ensure.that("cashier").isEqualToIgnoringCase(senderOrBenefProfString)
            );


            if (language.equals("FR")){
                System.out.println("Check Transaction Type: Transfert interne");
//                Thread.sleep(15000);
                WebElementFacade transTypeDepo = find(By.xpath(HistoryElements.getTransactionType));
                transTypeDepo.waitUntilVisible();
                String transTypeDepoString = transTypeDepo.getText();
                actor.attemptsTo(
                        Ensure.that("Transfert interne").isEqualToIgnoringCase(transTypeDepoString)
                );


            } else {
                System.out.println("Check Transaction Type: Internal Transfer");
//                Thread.sleep(15000);
                WebElementFacade transTypeDepo = find(By.xpath(HistoryElements.getTransactionType));
                transTypeDepo.waitUntilVisible();
                String transTypeDepoString = transTypeDepo.getText();
                actor.attemptsTo(
                        Ensure.that("Internal Transfer").isEqualToIgnoringCase(transTypeDepoString)
                );
//                Assert.assertEquals(transTypeDepo.getText(),"Internal Transfer");
            }

        }

        System.out.println("Check Debit Value: -1,000");
//        Thread.sleep(2000);
        WebElementFacade debit = find(By.xpath(HistoryElements.getDebitValue));
        debit.waitUntilVisible();
        String debitString = debit.getText();
        actor.attemptsTo(
                Ensure.that("-1,000").isEqualToIgnoringCase(debitString)
        );
//        Assert.assertEquals(debit.getText(),"-1,000");


        System.out.println("Check Balance value: the difference between previous and actual balance value = -1000 (debit)");
//        Thread.sleep(2000);
        WebElementFacade previousBalanceValue = find(By.xpath(HistoryElements.getPreviousBalanceValue));
        WebElementFacade actualBalanceValue = find(By.xpath(HistoryElements.getActualBalanceValue));
        actualBalanceValue.waitUntilVisible();
        BigDecimal subtrValueBalance = calculBalanceDif(actualBalanceValue.getText(),previousBalanceValue.getText());
        BigDecimal doubleDebit = new BigDecimal(debit.getText().replace(",", "")).setScale(2);
        actor.attemptsTo(
                Ensure.that(subtrValueBalance).isEqualTo(doubleDebit)
        );
//        Assert.assertTrue(doubleDebit.equals(subtrValueBalance) );
//        Thread.sleep(1000);


    }


    public void verifyLedgerViewRevenue(Actor actor, String language,String transType) throws ParseException {

        JavascriptExecutor executor =(JavascriptExecutor) getDriver();

        System.out.println("Click on Revenue Ledger");
//        Thread.sleep(3000);
        WebElementFacade revenueLedgerView = find(By.xpath(HistoryElements.revenueLedger));
        revenueLedgerView.waitUntilVisible();
        executor.executeScript("arguments[0].click();",revenueLedgerView);
//        getDriver().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        if (language.equals("FR")){
            System.out.println("Check Transaction Type: Frais");
//            Thread.sleep(7000);
            WebElementFacade transTypeRev = find(By.xpath(HistoryElements.getTransactionTypeRev));
            transTypeRev.waitUntilVisible();
            String transTypeRevString = transTypeRev.getText();
            actor.attemptsTo(
                    Ensure.that("Frais").isEqualToIgnoringCase(transTypeRevString)
            );
//            Assert.assertEquals(transTypeRev.getText(),"Frais");

        } else {
            System.out.println("Check Transaction Type: Fees");
//            Thread.sleep(10000);
            WebElementFacade transTypeRev = find(By.xpath(HistoryElements.getTransactionTypeRev));
            transTypeRev.waitUntilVisible();
            String transTypeRevString = transTypeRev.getText();
            actor.attemptsTo(
                    Ensure.that("Fees").isEqualToIgnoringCase(transTypeRevString)
            );

        }

        System.out.println("Check Transaction Object: Diool Transfer");
//        Thread.sleep(2000);
        WebElementFacade transacObject = find(By.xpath(HistoryElements.getLedgerSenderBeneficiary));
        transacObject.waitUntilVisible();
        String transacObjectString = transacObject.getText();
        actor.attemptsTo(
                Ensure.that("Diool Transfer").isEqualToIgnoringCase(transacObjectString)
        );



        System.out.println("Check Debit Value: -12");
//        Thread.sleep(2000);
        WebElementFacade debitValForFees = find(By.xpath(HistoryElements.getAmount));
        debitValForFees.waitUntilVisible();
        String debitValForFeesString = debitValForFees.getText();
        actor.attemptsTo(
                Ensure.that("-12").isEqualToIgnoringCase(debitValForFeesString)
        );



        System.out.println("Check Balance Revenue value: the difference between the value of the previous and actual balance= -10(debit)");
        WebElementFacade previousBalanceValueRev = find(By.xpath(HistoryElements.getPreviousBalanceValue));
        WebElementFacade actualBalanceValueRev = find(By.xpath(HistoryElements.getActualBalanceValue));
        actualBalanceValueRev.waitUntilVisible();
        BigDecimal subtrValueBalance = calculBalanceDif(actualBalanceValueRev.getText(),previousBalanceValueRev.getText());
        BigDecimal doubleDebit = new BigDecimal(debitValForFees.getText().replace(",", "")).setScale(2);

        actor.attemptsTo(
                Ensure.that(subtrValueBalance).isEqualTo(doubleDebit)
        );

    }


    public BigDecimal calculBalanceDif (String B1, String B2) throws ParseException {
        BigDecimal f1 = new BigDecimal(B1.replace(",", ""));
        BigDecimal f2 = new BigDecimal(B2.replace(",", ""));
        BigDecimal res = f1.subtract(f2) ;
        return res;
    }


}

