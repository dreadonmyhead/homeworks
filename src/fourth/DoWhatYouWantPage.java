package fourth;

import org.openqa.selenium.WebDriver;

import java.io.File;

public class DoWhatYouWantPage {

    private final WebDriver driver;

    public DoWhatYouWantPage(WebDriver driver) {
        File file = new File("/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        this.driver = driver;
    }

    public void goToPage() {
        driver.get("");
    }
}
