package elements;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDown {

  private static final String DROP_DOWN_XPATH = "//*[contains(text(),'%s')]/ancestor::span[contains(@class, 'test')]//button";
  private static final String SELECT_OPTION_XPATH = "//*[@role='option']//span[contains(text(),'%s')]";

  private WebDriver driver;
  private String label;

  public DropDown(WebDriver driver, String label) {
    this.driver = driver;
    this.label = label;
  }

  public void selectOption(String option) {
    new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions
    .visibilityOfElementLocated(By.xpath(String.format(DROP_DOWN_XPATH, label)))).click();
    driver.findElement(By.xpath(String.format(SELECT_OPTION_XPATH, option))).click();
  }
}
