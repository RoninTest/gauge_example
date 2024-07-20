package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.BiDi;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "myAccount")
    public WebElement myAccount;

    @FindBy(id = "login")
    public WebElement loginOptionInMainPage;

    @FindBy(id = "btnLogin")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[text()=\"Geçerli bir e-posta adresi girmelisiniz.\"]")
    public WebElement unsuccessfulText;

    @FindBy(xpath = "//*[text()=\"Beklenmeyen bir hata oluştu.\"]")
    public WebElement unexpectedLoginError;

    @FindBy(id = "txtUserName")
    public WebElement userName;

    @FindBy(id = "txtPassword")
    public WebElement password;
}
