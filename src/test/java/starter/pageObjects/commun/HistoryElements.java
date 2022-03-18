package starter.pageObjects.commun;

public interface HistoryElements {

    //Ledger and transactions view

    String historyMenu = "//*[@id=\"vertical-navigation\"]/ms-navigation/ul/li[5]/div/div/span";
    String transactionView = "/html/body/div[1]/div/md-sidenav[1]/ms-navigation/ul/li[5]/ul/li[1]/div/a/span";
    String ledgerView = "/html/body/div[1]/div/md-sidenav[1]/ms-navigation/ul/li[5]/ul/li[2]/div/a/span";
    String depositLedger = "//*[@id=\"content\"]/div[1]/div/card/ms-widget/ms-widget-front/ng-transclude/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]";
    String revenueLedger = "//*[@id=\"content\"]/div[1]/div/card/ms-widget/ms-widget-front/ng-transclude/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]";
    String getTransactionType = "//*[@id='report-history-table']/tbody/tr[1]/td[2]/div/span";
    String getTransactionTypeRev = "//*[@id='report-history-table']/tbody/tr[1]/td[2]/div/span";


    //Transaction view

    String getUser = "//*[@id='report-history-table']/tbody/tr[1]/td[3]/div/span";
    String getBeneficiary = "//*[@id='report-history-table']/tbody/tr[1]/td[4]/div/span[1]";
    String getBeneficiaryProfil = "//*[@id='report-history-table']/tbody/tr[1]/td[4]/div/span[2]";
    String getAmount = "//*[@id=\"report-history-table\"]/tbody/tr[1]/td[6]/div/span[1]";
    String getAmountfees = "//*[@id=\"report-history-table\"]/tbody/tr[1]/td[6]/div/span[2]";
    String getDirection = "//*[@id=\"report-history-table\"]/tbody/tr[1]/td[7]/div/span";
    String getStatus = "//*[@id=\"report-history-table\"]/tbody/tr[1]/td[8]/div/span";

    //Ledger view
    String getLedgerSenderBeneficiary = "//*[@id='report-history-table']/tbody/tr[1]/td[3]/div/span[1]";
    String getLedgerSenderBeneficiaryProfil = "//*[@id='report-history-table']/tbody/tr[1]/td[3]/div/span[2]";
    String getDebitValue = "//*[@id=\"report-history-table\"]/tbody/tr[1]/td[6]/div/span";
    String getActualBalanceValue = "//*[@id=\"report-history-table\"]/tbody/tr[1]/td[7]/div/span";
    String getPreviousBalanceValue = "//*[@id=\"report-history-table\"]/tbody/tr[2]/td[7]/div/span";





}
