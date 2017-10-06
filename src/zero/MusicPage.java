package zero;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

import static zero.MusicTestSuite.MOVIE;

public class MusicPage {

    private final WebDriver driver;
    private String artistName;

    public MusicPage(WebDriver driver) {
        File file = new File("/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        this.driver = driver;
    }

    public void goToAllMusicPage() {
        driver.get("https://www.allmusic.com/");
    }

    public void findMovie(String movie) {

        WebElement searchInput = driver.findElement(By.cssSelector(".site-search-input"));
        searchInput.sendKeys(movie);

        WebElement searchIcon = driver.findElement(By.cssSelector(".site-search-button"));
        searchIcon.click();
    }

    private void findArtist() {
        WebElement resultTable = driver.findElement(By.cssSelector(".search-results"));
        List<WebElement> allResults = resultTable.findElements(By.cssSelector(".album"));
        artistName = allResults.get(0).findElement(By.cssSelector(".artist")).getText();
    }

    public void goToYoutubePage() {
        driver.get("https://www.youtube.com/");
    }

    public void findMusic() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("search-input")));

        WebElement searchInput = driver.findElement(By.id("search"));
        findArtist();
        searchInput.sendKeys(artistName + " " + MOVIE);
        WebElement searchButton = driver.findElement(By.id("search-icon-legacy"));
        searchButton.click();
    }

    public void playMusic() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button > yt-icon")));

        WebElement resultTable = driver.findElement(By.cssSelector("#contents"));
        List<WebElement> allResults = resultTable.findElements(By.cssSelector("#dismissable"));
        allResults.get(0).findElement(By.cssSelector("#video-title")).click();
    }
}
