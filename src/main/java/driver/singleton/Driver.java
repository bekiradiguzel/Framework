package driver.singleton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static driver.browser.options.BrowserOptions.*;


public class Driver {

    /*
     * static singleton driver, proje tanimlanacak yalniz bir driver ile yürütülecek ise
     * bu tür driver yeterlidir
     * Paralel islem yapilamaz.
     */

    /**
     * static webdriver
     */
    private static WebDriver driver;

    /**
     * default chrome driber üreten method
     * @return Webdriver
     */
    public static WebDriver getDriver(){
        return getDriver("chrome");
    }

    /**
     * String olarak aldigi browser'i olusturur
     * @param browser string olarak browser adi
     * @return webdriver
     */
    public static WebDriver getDriver(String browser){
        if (driver == null) {
            switch (browser){
                case "firefox"->{
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(firefoxOptions());
                }
                case "safary"->{
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver(safariOptions());
                }
                default -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions());
                }

            }
        }
        return driver;
    }

    /**
     * driver'i kapatir ve null yapar
     */
    public static void quitDriver(){
        if (driver != null)
            driver.quit();
    }




}
