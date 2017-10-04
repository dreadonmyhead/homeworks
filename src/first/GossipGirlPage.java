package first;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

public class GossipGirlPage {

    private final WebDriver driver;

    public GossipGirlPage(WebDriver driver) {
        File file = new File("/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        this.driver = driver;
    }

    public void goToPage() {
        driver.get("http://www.imdb.com/");
    }

    public void find(String name) {
        WebElement firstInput = driver.findElement(By.id("navbar-query"));
        firstInput.sendKeys(name);

        WebElement searchIcon = driver.findElement(By.id("navbar-submit-button"));
        searchIcon.click();
    }

    public void clickOnFirstResultPhoto() {
        WebElement table = driver.findElement(By.cssSelector(".findList"));
        List<WebElement> allResultsPhotos = table.findElements(By.cssSelector(".primary_photo"));
        allResultsPhotos.get(0).click();
    }

    public void clickOnEpisodeGuide() {
        WebElement episodeGuide = driver.findElement(By.cssSelector(".np_episode_guide"));
        episodeGuide.click();
    }

    public void selectFirstSeason() {
        Select season = new Select(driver.findElement(By.id("bySeason")));
        season.selectByValue("1");
    }

    public void checkTitle(String title) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.cssSelector("div.loading_spinner"))));
        WebElement table = driver.findElement(By.cssSelector(".list.detail.eplist"));
        List<WebElement> allResults = table.findElements(By.cssSelector(".list_item.even"));
        Assert.assertEquals("Nope, wrong title!", title, allResults.get(0).findElement(By.cssSelector("div.info a")).getText());
    }
}
