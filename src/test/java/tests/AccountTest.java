package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import model.Account;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pages.NewAccountPage;

public class AccountTest {

  @Test
  public void checkSuccessfulCreateAccount() {
    User user = new User();
    Account account = new Account("AQA account", "onliner", "Apparel");
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-popup-blocking");
    options.addArguments("--remote-allow-origins=*");
    WebDriver driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();

    driver.get(user.getUrl());
    driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user.getUsername());
    driver.findElement(By.xpath("//input[@id='password']")).sendKeys(user.getPassword());
    driver.findElement(By.xpath("//input[@id='Login']")).click();

    NewAccountPage newAccountPage = new NewAccountPage(driver);
    newAccountPage.openPage()
        .create(account);
  }

}
