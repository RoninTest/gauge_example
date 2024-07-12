import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.SearchPage;


public class StepImplementation extends SearchPage {

    @Step("Close the driver")
    public void CloseDriver() {
        Driver.closeDriver();
    }

    @Step("Quite the driver")
    public void QuiteDriver() {Driver.closeDriver();}

    @Step("Go to home page")
    public void GoToHomePage() throws InterruptedException {
        Driver.getDriver();
        cookieReject.click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(searchFieldClickElement));
    }

    @Step("Search a <product>")
    public void SearchAProduct(String product) {
        action.moveToElement(searchFieldClickElement).click().perform();
        searchField.sendKeys(product);
        searchButton.click();
    }

    @Step("Verify searching product search result in page")
    public void VerifySearchingProductSearchResultInPage() {
        searchResult.isDisplayed();
    }

    @Step("Verify no Result View")
    public void VerifyNoResultView() {
        noResultView.isDisplayed();
    }
}