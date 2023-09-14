package elements;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputField {

  private static final String INPUT_XPATH = "//label[contains(text(),'%s')]/ancestor::div[@part='input-text']//input";

  private WebDriver driver;
  private String label;

  public InputField(WebDriver driver, String label) {
    this.driver = driver;
    this.label = label;
  }

  public void writeText(String text) {
    new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions
        .visibilityOfElementLocated(By.xpath(String.format(INPUT_XPATH, label)))).sendKeys(text);
  }
}
