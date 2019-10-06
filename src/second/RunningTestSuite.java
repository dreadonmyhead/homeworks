package second;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RunningTestSuite {

    private final static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setUpClass() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }

    @Test
    public void marathonTimeCalculator() {
        RunningPage page = new RunningPage(driver);
        page.goToPage();
        page.selectPaceMinutes();
        page.selectPaceSeconds();
        page.selectMetrics();
        page.calculate();
        page.checkMarathonResult("3:37:07");
    }
}
