package praktikum;

import org.openqa.selenium.By;
import java.time.Duration;

public class EnvConfig {
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final By BASE_COOKIE_PATH = By.xpath(".//button[@id='rcc-confirm-button']");
    public static final Duration BASE_DRIVER_WAIT_TIME = Duration.ofSeconds(3);
    public static final String FIRSTNAME_FOR_ORDER = "Максим";
    public static final String LASTNAME_FOR_ORDER = "Мирошкин";
    public static final String ADDRESS_FOR_ORDER = "г. Москва";
    public static final String PHONE_NUMBER_FOR_ORDER = "88005553535";
    public static final String COMMENT_FOR_COURIER = "Быстро доставили";
}
