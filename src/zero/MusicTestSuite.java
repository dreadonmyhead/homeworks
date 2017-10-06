package zero;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MusicTestSuite {

    private final static WebDriver driver = new ChromeDriver();
    public final static String MOVIE = "Psycho movie";

    @BeforeClass
    public static void setUpClass() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void musicListener() {
        MusicPage musicPage = new MusicPage(driver);
        musicPage.goToAllMusicPage();
        musicPage.findMovie(MOVIE);
        musicPage.goToYoutubePage();
        musicPage.findMusic();
        musicPage.playMusic();
    }
}
