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
        driver.get("http://www.runningforfitness.org/calc/racepaces/rp");
    }

    public void selectDistance(String distance) {
        Select season = new Select(driver.findElement(By.name("metres")));
        season.selectByValue(distance);
    }

    public void insertHours(String hours) {
        WebElement hoursInput = driver.findElement(By.id("hr"));
        hoursInput.sendKeys(hours);
    }

    public void insertMinutes(String minutes) {
        WebElement hoursInput = driver.findElement(By.id("min"));
        hoursInput.sendKeys(minutes);
    }

    public void insertSeconds(String seconds) {
        WebElement hoursInput = driver.findElement(By.id("sec"));
        hoursInput.sendKeys(seconds);
    }

    public void selectAge(String age) {
        Select competitionDropDown = new Select(driver.findElement(By.name("age")));
        competitionDropDown.selectByValue(age);
    }

    public void selectGender(String gender) {
        Select competitionDropDown = new Select(driver.findElement(By.name("gender")));
        competitionDropDown.selectByValue(gender);
    }

    public void calculate() {
        WebElement hoursInput = driver.findElement(By.cssSelector("input[name='Submit']"));
        hoursInput.submit();
    }

    public void checkMarathonResult(String result) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".header")));
        WebElement marathonResult = driver.findElement(By.xpath("//b[text()='Marathon']/following-sibling::td"));
        Assert.assertEquals("Nope, wrong result!", result, marathonResult.getText());
    }
}
