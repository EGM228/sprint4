package praktikum;

import org.openqa.selenium.By;
import java.time.Duration;

public class EnvConfig {
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final By BASE_COOKIE_PATH = By.xpath(".//button[@id='rcc-confirm-button']");
    public static final Duration BASE_DRIVER_WAIT_TIME = Duration.ofSeconds(3);
}
