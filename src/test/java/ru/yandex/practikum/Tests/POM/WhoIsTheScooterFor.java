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
    private final String metroStation = "[data-index='";
    // закрытие для cssSelector
    private final String closingCssSelectorForMetro = "']";
    // поле номера телефона
    private final By phoneNumber = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']");
    // кнопка "Далее"
    private final By ButtonNext = By.xpath(".//div[contains(@class,'Order_NextButton__1')]/button");
    // конструктор
    public WhoIsTheScooterFor(WebDriver driver){
        this.driver = driver;
    }

    public void fillFirstNameField(String firstName){
        new WebDriverWait(driver, EnvConfig.BASE_DRIVER_WAIT_TIME).until(ExpectedConditions.visibilityOfElementLocated(ButtonNext));
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void fillLastNameField(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void fillAddressField(String Address){
        driver.findElement(address).sendKeys(Address);
    }

    public void fillMetroField(String id){
        driver.findElement(metro).click();
        driver.findElement(By.cssSelector(metroStation+ id + closingCssSelectorForMetro)).click();
    }

    public void fillPhoneNumberField(String number){
        driver.findElement(phoneNumber).sendKeys(number);
    }

    public void clickNextButton(){
        driver.findElement(ButtonNext).click();
    }
}
