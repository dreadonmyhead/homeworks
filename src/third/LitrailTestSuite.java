package third;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LitrailTestSuite {

    private final static WebDriver driver = new ChromeDriver();
    private final static String CITY_FROM = "Kaunas";
    private final static String CITY_TO = "Vilnius";

    @BeforeClass
    public static void setUpClass() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }

    @Test
    public void trainTimeFinder() throws InterruptedException {
        LitrailPage page = new LitrailPage(driver);
        page.goToPage();
        page.clickOnTrainTicketImage();
        page.waitForSearchForm();
        page.insertFrom(CITY_FROM);
        page.insertTo(CITY_TO);
        page.clickSearch();
        page.clickOnTheNextDay();
        page.findTheLastTrainDurationTime();
    }
}
