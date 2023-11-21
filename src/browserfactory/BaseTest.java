package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Create the package ‘browserfactory’ and create the
 * class with the name ‘BaseTest’ inside the
 * ‘browserfactory’ package. And write the browser setup
 * code inside the class ‘Base Test’.
 */
public class BaseTest {
    static String baseUrl = "http://the-internet.herokuapp.com/login";

    static String browser ="Chrome";
    public WebDriver driver;

    public void openBrowser(){
        if(browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        } else if(browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        }else {
            System.out.println("Incorrect browser name");
        }

        driver.get(baseUrl);//Open the URL into the browser
        driver.manage().window().maximize();//maximise the browser
        //We give the wait to drive until load the browser completely
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closeBrowser(){
        driver.quit();//closing the browser
    }
}
