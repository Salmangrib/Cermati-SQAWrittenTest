package app.cermati.pages;

import app.cermati.handler.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class VerificationPage {

    WebDriver webDriver;

    public VerificationPage (WebDriver driver){
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@id=\"safe-area\"]/div[2]/div[2]/div/div[1]")
    private WebElement headerVerification;

    @FindBy(xpath = "//*[@id=\"safe-area\"]/div[2]/div[2]/div/div[2]/div/button[1]")
    private WebElement btnWa;

    @FindBy(xpath = "//*[@id=\"safe-area\"]/div[2]/div[2]/div/div[2]/div/button[2]")
    private WebElement btnSms;

    public String getHeaderText(){
        Action action = new Action(webDriver);
        action.waitElementToBeDisplayed(headerVerification, 3);
        action.validateElementIsVisibleAndEnabled(headerVerification);
        return headerVerification.getText();
    }

}