package ru.yandex.practikum.Tests.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

public class WhoIsTheScooterFor {
    // драйвер
    private final WebDriver driver;
    // поле имя
    private final By firstNameField = By.cssSelector("[placeholder='* Имя']");
    // поле фамилия
    private final By lastNameField = By.cssSelector("[placeholder='* Фамилия']");
    // поле адрес
    private final By address = By.cssSelector("[placeholder='* Адрес: куда привезти заказ']");
    // поле метро
    private final By metro = By.cssSelector("[placeholder='* Станция метро']");
    // кнопка выбора станции "Бульвар Рокосовского"
    private final By metroStation = By.cssSelector("[data-index='0']");
    // поле номера телефона
    private final By phoneNumber = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']");
    // кнопка "Далее"
    private final By ButtonNext = By.xpath(".//div[contains(@class,'Order_NextButton__1')]/button");
    // конструктор
    public WhoIsTheScooterFor(WebDriver driver){
        this.driver = driver;
    }

    public void fillFirstNameField(){
        new WebDriverWait(driver, EnvConfig.BASE_DRIVER_WAIT_TIME).until(ExpectedConditions.visibilityOfElementLocated(ButtonNext));
        driver.findElement(firstNameField).sendKeys(EnvConfig.FIRSTNAME_FOR_ORDER);
    }

    public void fillLastNameField(){
        driver.findElement(lastNameField).sendKeys(EnvConfig.LASTNAME_FOR_ORDER);
    }

    public void fillAddressField(){
        driver.findElement(address).sendKeys(EnvConfig.ADDRESS_FOR_ORDER);
    }

    public void fillMetroField(){
        driver.findElement(metro).click();
        driver.findElement(metroStation).click();
    }

    public void fillPhoneNumberField(){
        driver.findElement(phoneNumber).sendKeys(EnvConfig.PHONE_NUMBER_FOR_ORDER);
    }

    public void clickNextButton(){
        driver.findElement(ButtonNext).click();
    }
}
