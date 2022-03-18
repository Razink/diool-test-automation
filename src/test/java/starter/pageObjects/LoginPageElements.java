package starter.pageObjects;

public interface LoginPageElements {

    String emailUserNameID = "email";
    String loginText = "//span[contains(text(),'Sign in')]";
    String passwordID = "password";
    String logInBtnID = "btn-login";
    String languageSelect = "//*[@id='language-menu']/button";
    String languageFR = "//*[@id='language-menu-content']/md-menu-item[2]/button";

}
