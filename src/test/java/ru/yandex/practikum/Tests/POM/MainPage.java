package ru.yandex.practikum.Tests.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

public class MainPage {
    // драйвер
    private final WebDriver driver;
    // кнопка "Заказать" в шапке страницы
    private final By headerRequestButton = By.xpath(".//div[contains(@class,'Header_Nav')]/button[contains(@class,'Button_Button')]");
    // кнопка "Заказать" внизу страницы
    private final By bottomRequestButton = By.xpath(".//div[contains(@class,'Home_FinishButton')]/button[contains(@class,'Button_Button')]");
    // конструктор
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(EnvConfig.BASE_URL);
        new WebDriverWait(driver, EnvConfig.BASE_DRIVER_WAIT_TIME).until(ExpectedConditions.visibilityOfElementLocated(EnvConfig.BASE_COOKIE_PATH));
        driver.findElement(EnvConfig.BASE_COOKIE_PATH).click();
    }

    public void clickHeaderRequestButton(){
        driver.findElement(headerRequestButton).click();
    }

    public void clickBottomRequestButton(){
        WebElement element = driver.findElement(bottomRequestButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(bottomRequestButton).click();
    }

    public void clickRequestButtonHeaderOrBottom(String headOrBot){
        if ("header".equals(headOrBot)){
            clickHeaderRequestButton();
        } else if ("bottom".equals(headOrBot)){
            clickBottomRequestButton();
        }
    }
}
