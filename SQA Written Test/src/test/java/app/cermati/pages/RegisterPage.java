package app.cermati.pages;

import app.cermati.handler.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

/**
 * used to locate element and take action in registration page
 */

public class RegisterPage {
    WebDriver webDriver;
    Action action;

    //constructor
    public RegisterPage(WebDriver driver) {
        this.webDriver = driver;
        this.action = new Action(this.webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    //email field element locator
    @FindBy(id = "email")
    private WebElement fieldEmail;

    //phone number field element locator
    @FindBy(id = "mobilePhone")
    private WebElement fieldPhoneNumber;

    //password field element locator
    @FindBy(id = "password")
    private WebElement fieldPassword;

    //confirm password field element locator
    @FindBy(id = "confirmPassword")
    private WebElement fieldConfirmPassword;

    //first name field element locator
    @FindBy(id = "firstName")
    private WebElement fieldFirstName;

    //last name field element locator
    @FindBy(id = "lastName")
    private WebElement fieldLastName;

    //city field element locator
    @FindBy(id = "cityAndProvince")
    private WebElement fieldCity;

    //kota bandung button element locator
    @FindBy(xpath = "//button[@type = 'button' and (text() = 'KOTA BANDUNG' or . = 'KOTA BANDUNG')]")
    private WebElement btnKotaBandung;

    //register button element locator
    @FindBy(xpath = "//button[@type = 'button' and (text() = 'Daftar' or . = 'Daftar')]")
    private WebElement btnDaftar;

    //action to fill all registration data/credential
    public void enterRegister(String email, String phoneNumber, String password, String confirmPassword, String firstName, String lastName, String city) {
        enterEmail(email);
        enterPhoneNumber(phoneNumber);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        enterFirstName(firstName);
        enterLastName(lastName);
        enterCity(city);
    }

    //function to fill email field
    public void enterEmail(String email) {
        action.waitElementToBeDisplayed(fieldEmail, 3);
        fieldEmail.sendKeys(email);
    }

    public void enterPhoneNumber(String phoneNumber) {
        action.waitElementToBeDisplayed(fieldPhoneNumber, 3);
        fieldPhoneNumber.sendKeys(phoneNumber);
    }

    public void enterPassword(String password) {
        action.waitElementToBeDisplayed(fieldPassword, 3);
        fieldPassword.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        action.waitElementToBeDisplayed(fieldConfirmPassword, 3);
        fieldConfirmPassword.sendKeys(confirmPassword);
    }

    public void enterFirstName(String firstName) {
        action.waitElementToBeDisplayed(fieldFirstName, 3);
        fieldFirstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        action.waitElementToBeDisplayed(fieldLastName, 3);
        fieldLastName.sendKeys(lastName);
    }

    public void enterCity(String city) {
        action.waitElementToBeDisplayed(fieldCity, 3);
        fieldCity.sendKeys(city);
    }

    public void tapButtonCity() {
        btnKotaBandung.click();
    }

    public void tapButtonDaftar() {
        btnDaftar.click();
    }
}
