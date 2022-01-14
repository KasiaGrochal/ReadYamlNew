package configuration.browser;


import configuration.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserProvider {
    private static Logger logger = LoggerFactory.getLogger(BrowserProvider.class);

    public static String getBrowserFromPom(){
        return System.getProperty("Browser_Value");
    }

    public static Browser getActiveBrowser(Config config){
        Browser browser = Browser.CHROME;
        try{
            browser = config.getBrowsers().getActiveBrowser();
        }catch (NullPointerException e){
            logger.info("No driver was specified. Running test on default browser: {}",browser);
            return browser;
        }
        logger.info("Driver specified in config.yaml: {}",browser);
        return browser;
    }

    public static Browser getRemoteBrowser() {
        String browserName= getBrowserFromPom();
        switch (browserName) {
            case "chrome":
                logger.info("Browser set in POM: {}",browserName);
                return Browser.CHROME;
            case "firefox":
                logger.info("Browser set in POM: {}",browserName);
                return Browser.FIREFOX;
            case "edge":
                logger.info("Browser set in POM: {}",browserName);
                return Browser.EDGE;
            case "IE":
                logger.info("Browser set in POM: {}",browserName);
                return Browser.IE;
            default:
                logger.info("Found browser set in POM: '{}' -invalid name for browser",browserName);
                return null;
        }
    }
}
