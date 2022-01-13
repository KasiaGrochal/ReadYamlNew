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
        return browser;
    }

    public static Browser getRemoteBrowser() {
        switch (getBrowserFromPom()) {
            case "chrome":
                logger.info("Browser set remotely: CHROME");
                return Browser.CHROME;
            case "firefox":
                logger.info("Browser set remotely: FIREFOX");
                return Browser.FIREFOX;
            case "edge":
                logger.info("Browser set remotely: EDGE");
                return Browser.EDGE;
            case "IE":
                logger.info("Browser set remotely: IE");
                return Browser.IE;
            default:
                return null;
        }
    }
}
