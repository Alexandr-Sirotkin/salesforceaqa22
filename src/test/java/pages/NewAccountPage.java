package pages;

import elements.DropDown;
import elements.InputField;
import model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountPage extends BasePage {

  private static final String SAVE_BUTTON_XPATH = "//button[@name = 'SaveEdit']";
  private static final String ACCOUNT_LABEL = "Account Name";
  private static final String WEBSITE_LABEL = "Website";
  private static final String INDUSTRY_LABEL = "Industry";

  public NewAccountPage(WebDriver driver) {
    super(driver);
  }

  public NewAccountPage openPage() {
    driver.get("https://saas-dream-294.lightning.force.com/lightning/o/Account/new");
    return this;
  }

  public void create(Account account) {
    new InputField(driver, ACCOUNT_LABEL).writeText(account.getAccountName());
    new InputField(driver, WEBSITE_LABEL).writeText(account.getWebSite());
    new DropDown(driver, INDUSTRY_LABEL).selectOption(account.getIndustry());
    clickSave();
  }

  public void clickSave() {
    driver.findElement(By.xpath(SAVE_BUTTON_XPATH)).click();
  }
}
