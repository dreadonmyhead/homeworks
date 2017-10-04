package first;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GossipGirlTestSuite {

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
    public void testCalculator() {
        GossipGirlPage page = new GossipGirlPage(driver);
        page.goToPage();
        page.find("gossip girl");
        page.clickOnFirstResultPhoto();
        page.clickOnEpisodeGuide();
        page.selectFirstSeason();
        page.checkTitle("Pilot");
    }
}
