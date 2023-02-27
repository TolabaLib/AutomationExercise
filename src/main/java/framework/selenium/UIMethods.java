package framework.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UIMethods {
    private static final WebDriver driver = DriverManager.getInstance().getWebDriver();
    private static final JavascriptExecutor js = (JavascriptExecutor) driver;

    public static void moveToWebElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void clickWebElementJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void clickWebElementJs(String cssLocator) {
        js.executeScript("""
                clickWebElement(arguments[0]);
                function clickWebElement(cssLocator) {
                var element = document.querySelector(cssLocator);
                element.click();
                }""", cssLocator);
    }

    public static boolean isWebElementPresentJs(String cssLocator) {
        return (Boolean) js.executeScript("""
                return isWebElementPresent(arguments[0]);
                function isWebElementPresent(cssLocator) {
                var elements = document.querySelectorAll(cssLocator);
                return elements.length > 0;
                }""", cssLocator);
    }

    public static boolean isWebElementPresentByXpathJs(String xpathLocator) {
        return (Boolean) js.executeScript("""
                return isWebElementPresentByXpath(arguments[0]) > 0;
                function isWebElementPresentByXpath(path) {
                return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
                }""", xpathLocator);
    }

    public static boolean isWebElementNotPresentByXpathJs(String xpathLocator) {
        return (Boolean) js.executeScript("""
                return isWebElementPresentByXpath(arguments[0]) == null;
                function isWebElementPresentByXpath(path) {
                return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
                }""", xpathLocator);
    }

    public static boolean isWebElementVisibleJs(WebElement element) {
        return (Boolean) js.executeScript("return arguments[0].checkVisibility();", element);
    }

}
