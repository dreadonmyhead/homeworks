package third;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

public class LitrailPage {

    private final WebDriver driver;

    public LitrailPage(WebDriver driver) {
        File file = new File("/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        this.driver = driver;
    }

    public void goToPage() {
        driver.get("http://www.litrail.lt/en/home");
    }

    public void clickOnTrainTicketImage() throws InterruptedException {
        WebElement ticketsLink = driver.findElement(By.cssSelector("img[alt='Traukinio bilietas']"));
        ticketsLink.click();
    }

    public void insertFrom(String fromLocation) {
        WebElement fromInput = driver.findElement(By.cssSelector("input[name=' front-from']"));
        fromInput.sendKeys(fromLocation);
    }

    public void insertTo(String toLocation) {
        WebElement toInput = driver.findElement(By.cssSelector("input[name=' front-to']"));
        toInput.sendKeys(toLocation);
    }

    public void clickSearch() {
        WebElement searchInput = driver.findElement(By.cssSelector("button.act.btn.btn-y"));
        searchInput.click();
    }

    public void clickOnTheNextDay() {
        WebElement table = driver.findElement(By.cssSelector("div.departure-date-scroller.date-scroller"));
        List<WebElement> allResults = table.findElements(By.cssSelector(".date-scroll-item"));
        allResults.get(1).click();
    }

    public void waitForSearchForm() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.act.btn.btn-y")));
    }

    public void findTheLastTrainDurationTime() {
        WebElement timeTable = driver.findElement(By.cssSelector("div.timetable-content.departure-table"));
        List<WebElement> allDurations = timeTable.findElements(By.cssSelector(
                "div.timetable-duration-value.departure-duration-value"));
        String lastTrainTime = allDurations.get(allDurations.size() - 1).getText();
        System.out.println("The last train duration time is " + lastTrainTime.substring(0, lastTrainTime.indexOf(':')) +
                " hour and " + lastTrainTime.substring(lastTrainTime.lastIndexOf(":") + 1) + " minutes");
    }
}
