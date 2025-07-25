package test.Page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    // ===== WAITING HELPERS =====

    /** Chờ phần tử hiện diện, nhìn thấy, và sẵn sàng click */
    public void waitUntilVisibleAndStable(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /** Chờ overlay loading biến mất */
    protected void waitUntilOverlayGone(By overlayLocator) {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
    }

    /** Chờ tạm thời theo milliseconds */
    protected void waitForMilliseconds(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // ===== CLICK ACTIONS =====

    /** Click phần tử với đảm bảo ổn định, dùng JS nếu cần */
    public void clickToElement(By locator) {
        try {
            waitUntilVisibleAndStable(locator);
            WebElement element = driver.findElement(locator);
            scrollIntoView(element);
            try {
                element.click();
            } catch (Exception e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }
        } catch (TimeoutException e) {
            throw new RuntimeException("Không tìm thấy phần tử để click: " + locator.toString());
        }
    }

    /** Click phần tử dạng checkbox trong table/modal */
    public void clickCheckboxRow(By locator) {
        waitUntilVisibleAndStable(locator);
        WebElement checkbox = driver.findElement(locator);
        scrollIntoView(checkbox);
        checkbox.click();
    }

    /** Click dropdown + chọn option bên trong */
    protected void clickDropdownOption(By dropdownLocator, By optionLocator) {
        clickToElement(dropdownLocator);
        waitUntilVisibleAndStable(optionLocator);
        WebElement optionElement = driver.findElement(optionLocator);
        scrollIntoView(optionElement);
        try {
            optionElement.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
        }
    }

    /** Click ra ngoài popup để đóng */
    protected void clickOutsideToClosePopup() {
        new Actions(driver).moveByOffset(10, 10).click().perform();
        waitForMilliseconds(300);
    }

    /** Tìm phần tử đang hiển thị để click */
    protected void displayAndClick(By locator) {
        driver.findElements(locator).stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(btn -> {
                    scrollIntoView(btn);
                    btn.click();
                });
    }

    // ===== INPUT ACTIONS =====

    /** Gửi text vào input field */
    protected void sendKey(By locator, Object value) {
        waitUntilVisibleAndStable(locator);
        WebElement input = driver.findElement(locator);
        scrollIntoView(input);
        input.clear();
        input.sendKeys(value.toString());
    }

    /** Gửi dữ liệu vào trường ngày tháng và TAB để thoát */
    protected void inputDate(By locator, String value) {
        waitUntilVisibleAndStable(locator);
        WebElement input = driver.findElement(locator);
        scrollIntoView(input);
        input.clear();
        input.sendKeys(value);
        input.sendKeys(Keys.TAB);
    }

    // ===== SUPPORT =====

    /** Scroll phần tử vào giữa màn hình */
    protected void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    /** Force hiển thị phần tử bị ẩn bằng style */
    protected void makeVisible(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].style.display='block'; arguments[0].style.opacity='1';", element);
    }

    /** Tạo xpath động từ template */
    public By getDynamicLocator(String xpathTemplate, int index) {
        return By.xpath(xpathTemplate.replace("{{i}}", String.valueOf(index)));
    }
}
