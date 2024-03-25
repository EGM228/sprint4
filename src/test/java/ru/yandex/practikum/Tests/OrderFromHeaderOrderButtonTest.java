package ru.yandex.practikum.Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.practikum.Tests.POM.AboutRent;
import ru.yandex.practikum.Tests.POM.ConfirmOrderRequest;
import ru.yandex.practikum.Tests.POM.MainPage;
import ru.yandex.practikum.Tests.POM.WhoIsTheScooterFor;

public class OrderFromHeaderOrderButtonTest {
    private final DriverFactory driverFactory = new DriverFactory();

    @Before
    public void startUp(){
        driverFactory.initDriver();
    }

    @Test
    public void checkOrderingOfScooter(){
        WebDriver driver = driverFactory.getDriver();
        MainPage main = new MainPage(driver);
        main.open();
        main.clickHeaderRequestButton();

        WhoIsTheScooterFor scooterForm = new WhoIsTheScooterFor(driver);
        scooterForm.fillFirstNameField();
        scooterForm.fillLastNameField();
        scooterForm.fillAddressField();
        scooterForm.fillMetroField();
        scooterForm.fillPhoneNumberField();
        scooterForm.clickNextButton();

        AboutRent rentForm = new AboutRent(driver);
        rentForm.fillDateField();
        rentForm.fillRentTimeField();
        rentForm.fillColorField();
        rentForm.fillCommentField();
        rentForm.clickOrderButton();

        ConfirmOrderRequest confirm = new ConfirmOrderRequest(driver);
        confirm.checkConfirmFormIsVisible();
    }


    @After
    public void tearDown(){
        driverFactory.getDriver().quit();
    }
}
