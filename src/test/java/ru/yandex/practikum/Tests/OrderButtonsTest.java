package ru.yandex.practikum.Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.practikum.Tests.POM.AboutRent;
import ru.yandex.practikum.Tests.POM.ConfirmOrderRequest;
import ru.yandex.practikum.Tests.POM.MainPage;
import ru.yandex.practikum.Tests.POM.WhoIsTheScooterFor;

@RunWith(Parameterized.class)
public class OrderButtonsTest {
    private final DriverFactory driverFactory = new DriverFactory();
    private final String whichButtonToClick;
    private final String firstName;
    private final String lastName;
    private final String Address;
    private final String idMetroStation;
    private final String phoneNumber;
    private final String date;
    private final String howMuchDays;
    private final String color;
    private final String comment;

    public OrderButtonsTest(String whichButtonToClick,
                            String firstName,
                            String lastName,
                            String Address,
                            String idMetroStation,
                            String phoneNumber,
                            String date,
                            String howMuchDays,
                            String color,
                            String comment){
        this.whichButtonToClick=whichButtonToClick;
        this.firstName=firstName;
        this.lastName=lastName;
        this.Address=Address;
        this.idMetroStation=idMetroStation;
        this.phoneNumber=phoneNumber;
        this.date=date;
        this.howMuchDays=howMuchDays;
        this.color=color;
        this.comment=comment;
    }

    @Before
    public void startUp(){
        driverFactory.initDriver();
    }

    @Parameterized.Parameters
    public static Object[][] dataForTests() {
        return new Object[][] {
                { "header", "Максим", "Мирошкин", "г. Москва", "0", "88005553535", "029", "1", "black", "Привезли быстро"},
                { "bottom", "Александр", "Каштанов", "г. Брянск", "1", "89233563298", "030", "2", "grey", "Спасибо курьеру"},
        };
    }

    @Test
    public void checkOrderingOfScooter(){
        WebDriver driver = driverFactory.getDriver();
        MainPage main = new MainPage(driver);
        main.open();
        main.clickRequestButtonHeaderOrBottom(whichButtonToClick);

        WhoIsTheScooterFor scooterForm = new WhoIsTheScooterFor(driver);
        scooterForm.fillFirstNameField(firstName);
        scooterForm.fillLastNameField(lastName);
        scooterForm.fillAddressField(Address);
        scooterForm.fillMetroField(idMetroStation);
        scooterForm.fillPhoneNumberField(phoneNumber);
        scooterForm.clickNextButton();

        AboutRent rentForm = new AboutRent(driver);
        rentForm.fillDateField(date);
        rentForm.fillRentTimeField(howMuchDays);
        rentForm.fillColorField(color);
        rentForm.fillCommentField(comment);
        rentForm.clickOrderButton();

        ConfirmOrderRequest confirm = new ConfirmOrderRequest(driver);
        confirm.checkConfirmFormIsVisible();
    }


    @After
    public void tearDown(){
        driverFactory.getDriver().quit();
    }
}
