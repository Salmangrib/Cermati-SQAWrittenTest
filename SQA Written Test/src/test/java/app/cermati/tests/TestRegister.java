package app.cermati.tests;

import app.cermati.handler.Action;
import app.cermati.handler.TestDataProvider;
import app.cermati.pages.RegisterPage;
import app.cermati.pages.VerificationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * used to finish SQA written test Cermati to make an automation testing Register feature at Cermati web apps
 */

public class TestRegister {
    WebDriver webDriver;
    Action  action;

    //used to handle before the test
    @BeforeMethod(alwaysRun = true)
    public void launchChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--kiosk");
        webDriver = new ChromeDriver(options);
        webDriver.get("https://www.cermati.com/app/gabung");
        webDriver.manage().window().fullscreen();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    //used to handle after the test
    @AfterMethod
    public void closeDriver() {
        if (webDriver != null) {
            webDriver.close();
            System.out.println("Chrome Driver Closed");
        }
    }
    //used to do the test
    @Test(description = "user should be able to register using valid Crendential")

    public void userShouldBeAbleToRegisterUsingValidCredential(){
        //used to navigate the web to URL
        RegisterPage registerPage = new RegisterPage(webDriver);

        //used to get credential data
        String email = TestDataProvider.getRandomEmail();
        String phoneNumber = TestDataProvider.getRandomPhoneNo();
        String password = "Test1234";
        String confirmPassowrd = "Test1234";
        String firstName = TestDataProvider.getRandomFirstName();
        String lastName = TestDataProvider.getRandomLastName();
        String city = "Bandung";

        //used to input credential data and proceed the registration process
        registerPage.enterRegister(email,phoneNumber,password,confirmPassowrd,firstName,lastName,city);
        registerPage.tapButtonCity();
        registerPage.tapButtonDaftar();

        //handle alert
        new Action(webDriver).alertHandler(true);

        //used to assert verificationPage page after finsih the registration
        VerificationPage verificationPage = new VerificationPage(webDriver);
        Assert.assertTrue(verificationPage.getHeaderText().contains("Pilih metode verifikasi untuk mengirim kode OTP"));
    }
}
