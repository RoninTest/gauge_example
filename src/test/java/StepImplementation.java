import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.CasePage;


public class StepImplementation extends CasePage {

    @Step("Close the driver")
    public void CloseDriver() {
        Driver.closeDriver();
    }

    @Step("Go to home page")
    public void GoToHomePage() throws InterruptedException {
        Driver.getDriver();
        cookieReject.click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(searchFieldClickElement));
    }

    @Step("Search a <product>")
    public void SearchAProduct(String product) throws InterruptedException {
        action.moveToElement(searchFieldClickElement).click().perform();
        searchField.sendKeys(product);
        searchButton.click();
    }
}