package starter.pageObjects.ProductOwnerElements;

import net.serenitybdd.screenplay.targets.Target;

public interface TransfersElements {

    String transfersTabText = "//span[contains(text(),'Transfers') or contains(text(),'Transferts')]";
    String verifytransfersTabText = "//div[contains(text(),'Transfers') or contains(text(),'Transferts')]";
    String inputSearch = "//label[contains(text(),'Search') or contains(text(),'Rechercher')]/input";
    String closePopup = "/html/body/div[2]/div[2]/div/div/div[1]/div/span[3]";
    String sendBtn = "//button[@class='neutral-button md-button md-ink-ripple md-diool-theme' and not(@disabled)]";
    String inputAmount = "//label[contains(text(),'Amount') or contains(text(),'Montant')]/../input";
    String checkFeesValue = "//span[contains(text(),'Fees') or contains(text(),'Frais')]/../span[2]";
    String nextBtn = "//button[@class='md-raised md-primary md-button md-ink-ripple md-diool-theme']";
    String checkTotalValue = "//span[contains(text(),'Total') or contains(text(),'Total')]/../span[2]";

    String send2Btn = "//button[@class='md-raised md-primary md-button md-ink-ripple md-diool-theme']";
    String successfulPayVerif = "/html/body//md-dialog/md-dialog-content/section/div[1]";
    String okButtonConfirm = "//button[@class='md-raised md-primary md-button md-ink-ripple md-diool-theme']";
    String sendAgainButton = "//span[contains(text(),'Send again')]/../../button[2]";

}