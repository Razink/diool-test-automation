package starter.stepdefinitions;

import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Managed;
import starter.pageEvents.ContactsEvents;
import java.awt.*;

import static net.thucydides.core.annotations.ClearCookiesPolicy.Never;


public class TC_PO_SendMoney_AdressBook {
    @Managed(driver = "chrome", uniqueSession = true, clearCookies=Never)
    ContactsEvents adressBookEvent;
    ContactsEvents sendMoneyAdressBook;
    ContactsEvents deleteContact;
    @And("{actor} add new contact with {string} as Payment method and for {string}")
    public void the_user_sends_money(Actor actor, String paymentMethod, String profile) throws InterruptedException, AWTException {
        adressBookEvent.AddNewContact(actor, paymentMethod, profile);
    }


    @And("{actor} sends money to {string} contact {string} version")
    public void sends_money_AdressBook(Actor actor, String profile, String language) throws InterruptedException {
        sendMoneyAdressBook.sendMoneyAdressBook(actor, profile,language);
    }

    @And("{actor} delete the added contact {string}")
    public void delete(Actor actor, String profile) throws InterruptedException {
        deleteContact.deleteContact(actor,profile);
    }
}
