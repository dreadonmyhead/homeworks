package second;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class RunningPage {

    private final WebDriver driver;

    public RunningPage(WebDriver driver) {
        File file = new File("/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        this.driver = driver;
    }

    public void goToPage() {
        driver.get("https://www.runnersworld.com/tools/race-time-predictor");
    }

    public void selectDistance(String distance) {
        Select distanceDropdown = new Select(driver.findElement(By.id("frace")));
        distanceDropdown.selectByValue(distance);
    }

    public void selectComplitedDistance(String complitedDistance) {
        Select distanceDropdown = new Select(driver.findElement(By.id("r1")));
        distanceDropdown.selectByValue(complitedDistance);
    }

    public void insertHours(String hours) {
        WebElement hoursInput = driver.findElement(By.id("r1t_hours"));
        hoursInput.sendKeys(hours);
    }

    public void insertMinutes(String minutes) {
        WebElement minutesInput = driver.findElement(By.id("r1t_minutes"));
        minutesInput.sendKeys(minutes);
    }

    public void insertSeconds(String seconds) {
        WebElement secondsInput = driver.findElement(By.id("r1t_seconds"));
        secondsInput.sendKeys(seconds);
    }

    public void calculate() {
        WebElement calculateButton = driver.findElement(By.cssSelector("#rwtoolcalcbtn"));
        calculateButton.click();
    }

    public void checkMarathonResult(String result) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#rwtoolmsg")));
        String outputText = driver.findElement(By.cssSelector("#rwtoolmsg")).getText();
        String marathonResult = outputText.substring(0, outputText.indexOf('.'));
        Assert.assertEquals("Nope, wrong result!", result, marathonResult.substring(marathonResult.lastIndexOf("is") + 3));
    }
}