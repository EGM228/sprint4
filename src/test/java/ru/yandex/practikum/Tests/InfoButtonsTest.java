package ru.yandex.practikum.Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.practikum.Tests.POM.InfoButtons;

@RunWith(Parameterized.class)
public class InfoButtonsTest {
    // фабрика
    private final DriverFactory driverFactory = new DriverFactory();
    // кнопка из FAQ
    private final String locator;
    // текст под кнопой FAQ
    private final String expected;

    public InfoButtonsTest(String locator, String expected){
        this.locator = locator;
        this.expected = expected;
    }

    @Before
    public void startUp(){
        driverFactory.initDriver();
    }

    @Parameterized.Parameters
    public static Object[][] dataForTests() {
        return new Object[][] {
                { ".//div[contains(@id,'accordion__heading-0')]", ".//div[@id='accordion__panel-0']"},
                { ".//div[contains(@id,'accordion__heading-1')]", ".//div[@id='accordion__panel-1']"},
                { ".//div[contains(@id,'accordion__heading-2')]", ".//div[@id='accordion__panel-2']"},
                { ".//div[contains(@id,'accordion__heading-3')]", ".//div[@id='accordion__panel-3']"},
                { ".//div[contains(@id,'accordion__heading-4')]", ".//div[@id='accordion__panel-4']"},
                { ".//div[contains(@id,'accordion__heading-5')]", ".//div[@id='accordion__panel-5']"},
                { ".//div[contains(@id,'accordion__heading-6')]", ".//div[@id='accordion__panel-6']"},
                { ".//div[contains(@id,'accordion__heading-7')]", ".//div[@id='accordion__panel-7']"},
        };
    }

    @Test
    public void checkInfoButton(){
        WebDriver driver = driverFactory.getDriver();
        InfoButtons info = new InfoButtons(driver);

        info.open();
        info.clickCookie();
        info.scrollDown(locator);
        info.clickHoverButton(locator);
        info.checkRightText(expected);
    }

    @After
    public void tearDown(){
        driverFactory.getDriver().quit();
    }
}
