package starter.pageObjects.ProductOwnerElements;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public interface ContactsElements {
//Navigate to contact tab
    String contactsTab = "/html/body/div[1]/div/md-sidenav[1]/ms-navigation/ul/li[3]/div/a/span[contains(text(),'Contacts')]";
    // add new contact
    String addContactBtn = "/html/body/div[1]/div/div/md-content/div[1]/contacts/div/card/ms-widget/ms-widget-front/ng-transclude/md-content/div[1]/button";
    String inputFirstName = "/html/body/div[1]/div/md-sidenav[2]/div[1]/contact-form/form/div[2]/section/div[1]/div[1]/input";
    String inputLastName = "/html/body/div[1]/div/md-sidenav[2]/div[1]/contact-form/form/div[2]/section/div[1]/div[2]/input";
    String selectClient = "//span[contains(text(),'Client')]/../../div[1]";
    String selectEmployee = "/html/body/div[1]/div/md-sidenav[2]/div[1]/contact-form/form/div[2]/section/div[4]/md-radio-group/div/md-radio-button[1]";


    String paymentMethodBtn = "/html/body/div[1]/div/md-sidenav[2]/div[1]/contact-form/form/div[3]/button[1]";
    String selectDiool = "/html/body/div[1]/div/md-sidenav[2]/div[1]/contact-form/form/div[2]/contacts-payment-method/accordion[1]/div/div[1]";
    String selectBankAccount = "/html/body/div[1]/div/md-sidenav[2]/div[1]/contact-form/form/div[2]/contacts-payment-method/accordion[2]/div/div[1]";
    String inputDioolEmail = "/html/body/div[1]/div/md-sidenav[2]/div[1]/contact-form/form/div[2]/contacts-payment-method/accordion[1]/div/div[2]/ng-transclude/div/div[1]/input";

    String inputIBAN = "/html/body/div[1]/div/md-sidenav[2]/div[1]/contact-form/form/div[2]/contacts-payment-method/accordion[2]/div/div[2]/ng-transclude/form/div/div[1]/div/input";
    String addPMBtn = "//span[contains(text(),'Add payment option') or contains(text(),'Ajouter le mode de paiement')]/../../button";
    String checkDioolAdded = "//*[@id=\"quick-panel\"]/div[1]/contact-form/form/div[2]/contacts-payment-method/div[2]/div/span[1]";
    String saveBtn = "/html/body/div[1]/div/md-sidenav[2]/div[1]/contact-form/form/div[3]/button";
    String closeBtn = "/html/body/div[1]/div/md-sidenav[2]/div[1]/contact-form/section/div[2]/button/span";

    //Send money element

    String inputSearch = "/html/body/div[1]/div/div/md-content/div[1]/contacts/div/card/ms-widget/ms-widget-front/ng-transclude/md-content/div[2]/div/div[1]/div[1]/label/input";
    String selectOptions = "/html/body/div[1]/div/div/md-content/div[1]/contacts/div/card/ms-widget/ms-widget-front/ng-transclude/md-content/div[2]/div/table/tbody/tr/td[5]/md-menu/button";
    String selectSendMoney = "//span[contains(text(),' Send money') or contains(text(),\" Envoyer de l'argent\")]/../../button";


    String toScroll ="/html/body/div[1]/div/md-sidenav[2]/div[1]/contact-form/form/div[2]/section/div[1]/div[2]/div[1]/label";


    //Delete Contact

    String selectDelete = "//span[contains(text(),'Delete') or contains(text(),\"Supprimer\")]/../../button";
    String okConfirmation = "//span[contains(text(),'OK')]/../../button[2]";
    String checkDelete = "//span[contains(text(),'roland.thecashier@email.com')]/../../td[1]/span[contains(text(),'Contact Diool')]";
}