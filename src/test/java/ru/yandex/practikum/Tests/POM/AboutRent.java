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
    // кнопка выбора даты. 30 число
    private final By datePicked = By.xpath(".//div[contains(@class,'day--030')]");
    // треугольник в поле выбора времени аренды справа
    private final By rentTimeField = By.xpath(".//span");
    // кнопка выбора времени аренды. 1 сутки
    private final By rentTimePicked = By.xpath(".//div[@class='Dropdown-menu']/div[1]");
    // кнопка выбора цвета. черный
    private final By color = By.cssSelector("[for='black']");
    // поле комментария для курьера
    private final By comment = By.cssSelector("[placeholder='Комментарий для курьера']");
    // кнопка "Заказать"
    private final By orderButton = By.xpath(".//div[contains(@class,'Order_Buttons')]/button[2]");

    public void fillDateField(){
        new WebDriverWait(driver, EnvConfig.BASE_DRIVER_WAIT_TIME).until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        driver.findElement(deliveryTimeField).click();
        driver.findElement(datePicked).click();
    }

    public void fillRentTimeField(){
        driver.findElement(rentTimeField).click();
        new WebDriverWait(driver, EnvConfig.BASE_DRIVER_WAIT_TIME).until(ExpectedConditions.visibilityOfElementLocated(rentTimePicked));
        driver.findElement(rentTimePicked).click();
    }

    public void fillColorField(){
        driver.findElement(color).click();
    }

    public void fillCommentField(){
        driver.findElement(comment).sendKeys(EnvConfig.COMMENT_FOR_COURIER);
    }

    public void clickOrderButton(){
        driver.findElement(orderButton).click();
    }
}
