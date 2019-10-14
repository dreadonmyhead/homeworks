package second;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class RunningPage {

    private final WebDriver driver;

    public RunningPage(WebDriver driver) {
        File file = new File("/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        this.driver = driver;
    }

    public void goToPage() {
        driver.get("https://www.strava.com/running-pace-calculator");
    }

    public void selectPaceMinutes() {
        Select minutesDropdown = new Select(driver.findElement(By.name("minutes")));
        minutesDropdown.selectByValue("5");
    }

    public void selectPaceSeconds() {
        Select minutesDropdown = new Select(driver.findElement(By.name("seconds")));
        minutesDropdown.selectByValue("30");
    }

    public void selectMetrics() {
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type=radio]"));
        for (WebElement radioButton : radioButtons) {
            if (radioButton.getAttribute("value").equals("metric")) {
                radioButton.click();
            }
        }
    }

    public void calculate() {
        WebElement calculateButton = driver.findElement(By.cssSelector(".btn.btn-primary.mt-sm"));
        calculateButton.click();
    }

    public void checkMarathonResult(String result) {
        String outputText = driver.findElement(By.cssSelector(".highlighted .text-right")).getText();
        String marathonResult = outputText.substring(0, outputText.indexOf('.'));
        Assert.assertEquals("Nope, wrong result!", result, marathonResult.substring(marathonResult.lastIndexOf("is") + 3));
    }
}
