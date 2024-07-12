package ru.yandex.practikum.Tests.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

public class InfoButtons {
    // драйвер
    private final WebDriver driver;
    private final String topHover = "accordion__heading-";
    private final String underText = "accordion__panel-";
    // конструктор
    public InfoButtons(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(EnvConfig.BASE_URL);
    }

    public void clickCookie(){
        new WebDriverWait(driver, EnvConfig.BASE_DRIVER_WAIT_TIME).until(ExpectedConditions.visibilityOfElementLocated(EnvConfig.BASE_COOKIE_PATH));
        driver.findElement(EnvConfig.BASE_COOKIE_PATH).click();
    }

    public void scrollDown(String locator){
        WebElement element = driver.findElement(By.id(topHover + locator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickHoverButton(String locator){
        new WebDriverWait(driver, EnvConfig.BASE_DRIVER_WAIT_TIME).until(ExpectedConditions.visibilityOfElementLocated(By.id(topHover + locator)));
        driver.findElement(By.id(topHover + locator)).click();
    }

    public void checkRightText(String expected){
        new WebDriverWait(driver, EnvConfig.BASE_DRIVER_WAIT_TIME).until(ExpectedConditions.visibilityOfElementLocated(By.id(underText+expected)));
        assert driver.findElement(By.id(underText+expected)).isDisplayed();
    }
}
