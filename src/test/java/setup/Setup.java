package setup;

import io.cucumber.java.eo.Se;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class Setup {

    static private Setup instance = null;
    public WebDriver driver;

    private Setup(){
     /*   WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));*/
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            //   WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            DesiredCapabilities cp = new DesiredCapabilities();
            cp.setCapability(ChromeOptions.CAPABILITY, options);
            options.merge(cp);
            driver = new ChromeDriver(options);
            System.out.println("driver padre:"+driver);

            //   webDriver = new ChromeDriver();
            driver.manage().window().maximize();
    }
    public static Setup getInstance(){
        if(instance == null){
            instance = new Setup();
        }
        return instance;
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
