package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Suzanna on 28.11.2016.
 */
public class EngProfilePage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://en.myshows.me/profile/";
    public EngProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("English profile page opened");
    }

    @FindBy(xpath = "/html/body/div/div[1]/div/main/h1")
    private WebElement titleEnglish;

    public String getChangedLanguage() { return titleEnglish.getText(); }
}
