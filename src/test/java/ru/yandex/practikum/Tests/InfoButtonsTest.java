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
                { "0", "0"},
                { "1", "1"},
                { "2", "2"},
                { "3", "3"},
                { "4", "4"},
                { "5", "5"},
                { "6", "6"},
                { "7", "7"},
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
