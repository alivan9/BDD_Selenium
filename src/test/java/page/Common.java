package page;

import lombok.Data;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.function.Function;

@Data
public class Common {


    //Thingsboard thingsboard = new Thingsboard();
    private WebDriver webDriver;
    private String webDriverChrome = "webdriver.chrome.driver";
    private String chromeDriverPath = "src/test/resources/chromedriver";

    public WebDriver initializeWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        webDriver = new ChromeDriver();
        return webDriver;
    }

//    public void startBrowser(CMSPortalWebElementsPath cmsPortalWebElementsPath, WebDriver webDriver) {
//        System.setProperty(webDriverChrome, chromeDriverPath);
//        webDriver = new ChromeDriver();
//        webDriver.manage().window().maximize();
//        webDriver.get(cmsPortalWebElementsPath.getBaseURL());
//    }

    public void startBrowserWithWait(WebDriver webDriver, String baseUrl) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        webDriver.get(baseUrl);
    }

    public WebElement initializeWebElementWithFluentWait(WebDriver webDriver, String elementXpath) throws InterruptedException {
        Wait<WebDriver> fwait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        WebElement webElement = fwait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.xpath(elementXpath));
            }
        });
        return webElement = webDriver.findElement(By.xpath(elementXpath));
    }

    public WebElement initializeWebElementExplicitWait(String elementXpath) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(35));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        return webDriver.findElement(By.xpath(elementXpath));
    }

    public void click(WebDriver webDriver, String elementPath) throws InterruptedException {
        WebElement webElement = initializeWebElementWithFluentWait(webDriver, elementPath);
        webElement.click();
    }

    public void fluentClick(String elementXpath, WebDriver webDriver) {
        Wait<WebDriver> fwait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        WebElement webElement = fwait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.xpath(elementXpath));
            }
        });
        webElement.click();
    }

    public void cssSelectorFluentClick(String elementCssSelector, WebDriver webDriver) {
        Wait<WebDriver> fwait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        WebElement webElement = fwait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.cssSelector(elementCssSelector));
            }
        });
        webElement.click();
        System.out.println(webElement.toString());
        //fluentJSClick(webElement.toString(),webDriver);
    }

    public void fluentJSClick(String elementXpath, WebDriver webDriver) {
        Wait<WebDriver> fwait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        WebElement webElement = fwait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.xpath(elementXpath));
            }
        });
        //webElement.click();
        clickUsingJSExecutor(webDriver, webElement);
    }

    public void cssSelectortfluentJSClick(String elementCssSelector, WebDriver webDriver) {
        Wait<WebDriver> fwait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        WebElement webElement = fwait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.cssSelector(elementCssSelector));
            }
        });
        //webElement.click();
        clickUsingJSExecutor(webDriver, webElement);
    }

    public void clickUsingJSExecutor(WebDriver webDriver, WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click()", webElement);
    }

    public void sendKeys(WebDriver webDriver, String elementPath, String keys) throws InterruptedException {
        WebElement webElement = initializeWebElementWithFluentWait(webDriver, elementPath);
        webElement.clear();
        webElement.sendKeys(keys);
    }

    public void clickOnElement(WebDriver webDriver, String elementXpath) {
        Wait<WebDriver> fwait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        WebElement webElement = fwait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.xpath(elementXpath));
            }
        });
        webElement.click();
    }

    public void fillTextBox(WebDriver webDriver, String elementXpath) {
        Wait<WebDriver> fwait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        WebElement webElement = fwait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.xpath(elementXpath));
            }
        });
        webElement.clear();
        webElement.sendKeys();
    }

    public void sendWords(WebElement webElement, String words) {
        webElement.clear();
        webElement.sendKeys(words);
    }

    public void fluentSendKeys(String elementXpath, String keys, WebDriver webDriver) {
        Wait<WebDriver> fwait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        WebElement webElement = fwait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.xpath(elementXpath));
            }
        });

        sendWords(webElement, keys);
    }

    public void cssSelectorFluentSendKeys(String elementCssSelector, String keys, WebDriver webDriver) {
        Wait<WebDriver> fwait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        WebElement webElement = fwait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.cssSelector(elementCssSelector));
            }
        });

        //sendKeyActions(keys, webDriver);
        sendWords(webElement, keys);
        //webElement.sendKeys(Keys.);
    }

    public void sendKeyActions(String keys, WebDriver webDriver) {
        Actions action = new Actions(webDriver);
        action.sendKeys(keys).perform();
    }

    public void sendArrowDownAndEnterAction(WebDriver webDriver) {
        Actions builder = new Actions(webDriver);
        Action drawAction = builder.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .build();
        drawAction.perform();
    }

    public String createNameBasedOnMonthAndDay(String option) {
        LocalDate currentDate = LocalDate.parse(LocalDate.now().toString());
        int day = currentDate.getDayOfMonth();
        Month month = currentDate.getMonth();
        String concatenatedName = "";
        if (option.equals("DEVICE")) {
            concatenatedName = concatenatedName.concat(month.name()).concat(" ").concat(String.valueOf(day)).concat(" DEVICE");
        } else if (option.equals("CAMPAIGN")) {
            concatenatedName = concatenatedName.concat(month.name()).concat(" ").concat(String.valueOf(day)).concat(" CAMPAIGN");
        }
        return concatenatedName;
    }
}
