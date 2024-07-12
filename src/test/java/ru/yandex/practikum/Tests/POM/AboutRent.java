package ru.yandex.practikum.Tests.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

public class AboutRent {
    // драйвер
    private final WebDriver driver;
    // конструктор
    public AboutRent(WebDriver driver){
        this.driver = driver;
    }
    // поле даты доставки
    private final By deliveryTimeField = By.cssSelector("[placeholder='* Когда привезти самокат']");
    // кнопка выбора даты
    private final String datePicked = ".//div[contains(@class,'day--";
    // закрытие xpath для datePicked
    private final String closerForDatePicked = "')]";

    // треугольник в поле выбора времени аренды справа
    private final By rentTimeField = By.xpath(".//span");
    // кнопка выбора времени аренды
    private final String rentTimePicked = ".//div[@class='Dropdown-menu']/div[";
    // закрытие xpath для rentTimePicked
    private final String closerForRentTimePicked = "]";

    // кнопка выбора цвета. черный
    private final String color = "[for='";
    // закрытие cssSelector для color
    private final String closerForColor = "']";

    // поле комментария для курьера
    private final By comment = By.cssSelector("[placeholder='Комментарий для курьера']");
    // кнопка "Заказать"
    private final By orderButton = By.xpath(".//div[contains(@class,'Order_Buttons')]/button[2]");


    public void fillDateField(String day){
        new WebDriverWait(driver, EnvConfig.BASE_DRIVER_WAIT_TIME).until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        driver.findElement(deliveryTimeField).click();
        driver.findElement(By.xpath(datePicked + day + closerForDatePicked)).click();
    }

    public void fillRentTimeField(String howMuchDays){
        driver.findElement(rentTimeField).click();
        new WebDriverWait(driver, EnvConfig.BASE_DRIVER_WAIT_TIME);//.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(rentTimePicked + howMuchDays + closerForRentTimePicked)));
        driver.findElement(By.xpath(rentTimePicked + howMuchDays + closerForRentTimePicked)).click();
    }

    public void fillColorField(String pickedColor){
        driver.findElement(By.cssSelector(color + pickedColor + closerForColor)).click();
    }

    public void fillCommentField(String commentForCourier){
        driver.findElement(comment).sendKeys(commentForCourier);
    }

    public void clickOrderButton(){
        driver.findElement(orderButton).click();
    }
}
