import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.BasePage;
import page.LoginPage;
import page.SearchPage;

import java.time.Duration;


public class StepImplementation {

    private final SearchPage searchPage = new SearchPage();
    private final LoginPage loginPage = new LoginPage();

    public StepImplementation() {
        super();
    }

    @Step("Close the driver")
    public void CloseDriver() {
        Driver.closeDriver();
    }

    @Step("Quite the driver")
    public void QuiteDriver() {
        Driver.closeDriver();
    }

    @Step("Go to home page")
    public void GoToHomePage() throws InterruptedException {
        Driver.getDriver();
        searchPage.cookieReject.click();
        Thread.sleep(5000);
        Driver.wait.until(ExpectedConditions.visibilityOf(searchPage.searchFieldClickElement));
    }

    @Step("Search a <product>")
    public void SearchAProduct(String product) {
        Driver.action.moveToElement(searchPage.searchFieldClickElement).click().perform();
        searchPage.searchField.sendKeys(product);
        searchPage.searchButton.click();
    }

    @Step("Verify searching product search result in page")
    public void VerifySearchingProductSearchResultInPage() {
        searchPage.searchResult.isDisplayed();
    }

    @Step("Verify no Result View")
    public void VerifyNoResultView() {
        searchPage.noResultView.isDisplayed();
    }

    @Step("Go to login page as guest user")
    public void GoToLoginPageAsGuestUser() {
        Driver.action.moveToElement(loginPage.myAccount).pause(Duration.ofSeconds(2)).perform();
        loginPage.loginOptionInMainPage.click();
        Driver.wait.until(ExpectedConditions.visibilityOf(loginPage.loginBtn));
    }

    @Step("Click login button")
    public void ClickLoginButton() {
        loginPage.loginBtn.click();
    }

    @Step("Verify attempt of unsuccessful login")
    public void VerifyAttemptOfUnsuccessfulLogin(){
        Driver.wait.until(ExpectedConditions.visibilityOf(loginPage.unsuccessfulText));
    }

    @Step("Enter email data")
        public void EnterEmailData(){
        loginPage.userName.click();
        loginPage.userName.sendKeys("example@gmail.com");
    }

    @Step("Verify attempt of unsuccessful login with just email data")
    public void VerifyAttemptOfUnsuccessfulLoginWithJustEmailData(){
        Driver.wait.until(ExpectedConditions.visibilityOf(loginPage.unexpectedLoginError));
    }

    @Step("Enter user password data")
    public void EnterUserPasswordData(){
        loginPage.password.click();
        loginPage.password.sendKeys(".Example123Example");
    }

}