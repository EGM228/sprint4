package ru.yandex.practikum.Tests.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

public class ConfirmOrderRequest {
    // драйвер
    private final WebDriver driver;
    // локатор всей формы
    private final By confirmForm = By.xpath(".//div[contains(@class,'Order_Overlay')]");
    //конструктор
    public ConfirmOrderRequest(WebDriver driver){
        this.driver = driver;
    }

    public void checkConfirmFormIsVisible(){
        new WebDriverWait(driver, EnvConfig.BASE_DRIVER_WAIT_TIME).until(ExpectedConditions.visibilityOfElementLocated(confirmForm));
        assert driver.findElement(confirmForm).isDisplayed();
    }
}
