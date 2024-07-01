package glue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class W {

    private WebDriver driver;
    private static W instance = null;

    private W() {
        // Private constructor to prevent external instantiation
        String pathToDriver = "C:\\Chromedriver\\chromedriver.exe";
        if (pathToDriver == null || pathToDriver.isEmpty()) {
            throw new RuntimeException("Define a path to the chrome driver using system property 'webdriver.chrome.driver'");
        }
        System.setProperty("webdriver.chrome.driver", pathToDriver);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize browser window
        options.addArguments("--disable-extensions"); // Disable browser extensions

        driver = new ChromeDriver(options);
        setImplicitWait(Duration.ofSeconds(10)); // Set implicit wait using java.time.Duration
    }

    public static W getInstance() {
        if (instance == null) {
            instance = new W();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    private void setImplicitWait(Duration duration) {
        driver.manage().timeouts().implicitlyWait(duration.toMillis(), TimeUnit.MILLISECONDS);
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
