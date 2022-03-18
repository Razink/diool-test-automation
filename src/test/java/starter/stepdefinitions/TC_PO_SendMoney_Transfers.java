package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import starter.navigation.NavigateTo;
import starter.pageEvents.CommonEvents;
import starter.pageEvents.HistoryEvents;
import starter.pageEvents.TransfersEvents;

import java.awt.*;
import java.text.ParseException;

import static net.thucydides.core.annotations.ClearCookiesPolicy.Never;


public class TC_PO_SendMoney_Transfers{
    @Managed(driver = "chrome", uniqueSession = true, clearCookies=Never)

    CommonEvents common;
    TransfersEvents transfersEvents;
    HistoryEvents historyEvents;


    @Given("{actor} sign in with a valid credentials")
    public void the_user_sign_in_with_a_valid_credentials(Actor actor) throws InterruptedException {
        actor.wasAbleTo(NavigateTo.theDioolLoginPage());
        common.enterEmailAndPasswordId();
    }

    @When("{actor} set Language: {string} and navigates to {string} screen")
    public void the_user_set_Langage_and_navigates_to_transfers_screen(Actor actor, String lang, String screen) throws InterruptedException {
        if (lang.equals("FR")) {
            System.out.println("Change platform to Frensh language");
            common.changeFRLanguage();
        }else {
            System.out.println("the test is with English language");
        }
        transfersEvents.verifyScreenTable(actor,screen);
    }

    @And("{actor}sends money to : {string} with {string}")
    public void the_user_sends_money(Actor actor, String profile, String language) throws InterruptedException, AWTException {
        transfersEvents.sendMoneyTransfer(actor,profile,language);
    }


    @Then("{actor} verify transaction is recorded with {string} : {string} as transaction type in the list of history")
    public void Verify_Transaction_History(Actor actor, String lang,String transactionType) throws InterruptedException, AWTException, ParseException {

        historyEvents.verifyTransactionView(actor,lang,transactionType);
        historyEvents.verifyLedgerViewDeposit(actor,lang,transactionType);
        if (transactionType.equals("Diool Transfer")){
            historyEvents.verifyLedgerViewRevenue(actor,lang,transactionType);
        }
    }

}