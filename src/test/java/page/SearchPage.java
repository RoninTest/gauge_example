package page;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends Driver {

    public SearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "searchBoxOld-M1esqHPyWSuRUjMCALPK")
    public WebElement searchFieldClickElement;

    @FindBy(xpath = "//input[@placeholder='Ürün, kategori veya marka ara']")
    public WebElement searchField;

    @FindBy(className = "searchBoxOld-yDJzsIfi_S5gVgoapx6f")
    public WebElement searchButton;
    @FindBy(xpath = "//a[contains(text(), \"Reddet\")]")
    public WebElement cookieReject;

    @FindBy(className = "searchResultSummaryBar-HM2Hk6FnQ2zwnblc0BJb")
    public WebElement searchResult;

    @FindBy(className = "no-result-view-LLgYHZRQwgIqJe3NVueY")
    public WebElement noResultView;
}
