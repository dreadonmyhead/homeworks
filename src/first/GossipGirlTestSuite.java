package first;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GossipGirlTestSuite {

    private final static WebDriver driver = new ChromeDriver();
    private final static String NAME = "gossip girl";
    private final static String EPISODE_NAME = "Pilot";

    @BeforeClass
    public static void setUpClass() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }

    @Test
    public void gossipGirlFirstEpisodeCheck() {
        GossipGirlPage page = new GossipGirlPage(driver);
        page.goToPage();
        page.find(NAME);
        page.clickOnFirstResultPhoto();
        page.clickOnEpisodeGuide();
        page.selectFirstSeason();
        page.checkTitle(EPISODE_NAME);
    }
}
