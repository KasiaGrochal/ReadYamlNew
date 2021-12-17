package configuration.browser;

import configuration.browser.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserFactory {

    public WebDriver getDriver(Browser browser) {
        WebDriver webDriver;
        switch (browser) {
            case CHROME:
                webDriver = getChrome();
                break;
            case FIREFOX:
                webDriver = getFirefox();
                break;
            case IE:
                webDriver = getIe();
                break;
            case EDGE:
                webDriver = getEdge();
                break;
            default:
                return getChrome();
        }
        return webDriver;

    }

    private WebDriver getEdge() {
        EdgeOptions options = new EdgeOptions();
        //add options
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(options);

    }

    private WebDriver getIe() {
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        //add options
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver(ieOptions);
    }

    private WebDriver getFirefox() {
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        optionsFirefox.addArguments("start-maximized");
        return new FirefoxDriver(optionsFirefox);
    }

    private WebDriver getChrome() {
        ChromeOptions optionsChrome = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        optionsChrome.addArguments("start-maximized");
        return new ChromeDriver(optionsChrome);
    }
}
