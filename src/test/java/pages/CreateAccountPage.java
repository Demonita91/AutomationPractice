package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateAccountPage extends BasePage {
    public String endpoint = "index.php?controller=authentication&back=my-account#account-creation";
    private static final By FIRST_NAME = By.id("customer_firstname");
    private static final By LAST_NAME = By.id("customer_lastname");
    private static final By PASSWORD = By.id("passwd");
//    private static final By FIRST_NAME = By.id("firstname");
//    private static final By LAST_NAME = By.id("lastname");
    private static final By ADDRESS = By.id("address1");
    private static final By CITY = By.id("city");
    private static final By STATE = By.id("id_state");
    private static final By POSTAL_CODE = By.id("postcode");
    private static final By COUNTRY = By.id("id_country");
    private static final By PHONE = By.id("phone_mobile");
    private static final By REGISTER_BUTTON = By.id("submitAccount");

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage setFirstName(String firstName) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);

        return this;
    }

    public CreateAccountPage setLastName(String lastName) {
        driver.findElement(LAST_NAME).sendKeys(lastName);

        return this;
    }

    public CreateAccountPage setPassword(String password) {
        driver.findElement(PASSWORD).sendKeys(password);

        return this;
    }

    public CreateAccountPage setAddress(String address) {
        driver.findElement(ADDRESS).sendKeys(address);

        return this;
    }

    public CreateAccountPage setCity(String city) {
        driver.findElement(CITY).sendKeys(city);

        return this;
    }

    public CreateAccountPage setState(String state) {
        driver.findElement(STATE).click();

        new Select(driver.findElement(STATE)).selectByVisibleText(state);

        return this;
    }

    public CreateAccountPage setPostalCode(String postalCode) {
        driver.findElement(POSTAL_CODE).sendKeys(postalCode);

        return this;
    }

    public CreateAccountPage setCountry(String country) {
        new Select(driver.findElement(COUNTRY)).selectByVisibleText(country);

        return this;
    }

    public CreateAccountPage setPhone(String phone) {
        driver.findElement(PHONE).sendKeys(phone);

        return this;
    }

    public CreateAccountPage clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();


        return new CreateAccountPage(driver);
    }

    @Override
    public BasePage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(REGISTER_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + REGISTER_BUTTON);
        }
//        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Override
    public BasePage openPage() {
        driver.get(URL + endpoint);
        isPageOpened();
        return this; //САМОСТОЯТЕЛЬРНО НЕ ОТКРЫВАЕТСЯ, НАСЛЕДОВАТЬСЯ ЛИ?
    }

}
