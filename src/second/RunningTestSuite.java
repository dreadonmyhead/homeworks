package second;

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

//    @AfterClass
//    public static void tearDownClass() {
//        driver.quit();
//    }

    @Test
    public void testCalculator() {
        RunningPage page = new RunningPage(driver);
        page.goToPage();
        page.selectDistance("21100");
        page.insertHours("1");
        page.insertMinutes("44");
        page.insertSeconds("8");
        page.selectAge("33");
        page.selectGender("F");
        page.calculate();
        page.checkMarathonResult("03:37:17");
    }
}
