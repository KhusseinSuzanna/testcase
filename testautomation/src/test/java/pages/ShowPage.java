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
public class ShowPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://myshows.me/view/30443/";
    public ShowPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Show page opened");
    }

    @FindBy(xpath = "/html/body/div[1]/div/div/main/div[1]/div/div[2]/a[1]")
    private WebElement buttonWatch;

    @FindBy(xpath = "/html/body/div[1]/div/div/main/div[1]/div/div[2]/a[1]/b")
    private WebElement titleWatch;

    @FindBy(xpath = "/html/body/div[1]/div/div/main/p[2]/span[2]/a[1]")
    private WebElement buttonStar;

    @FindBy(id = "user-rating-title")
    private WebElement rateTitle;

    @FindBy(xpath = "/html/body/div[1]/div/div/main/form/div[2]/div[2]/div/ul/li[1]/label/input")
    private WebElement checkboxEpisode;

    @FindBy(xpath = "/html/body/div[1]/div/div/main/form/div[1]/div[2]/div/button/b")
    private WebElement buttonSave;

    @FindBy(xpath = "/html/body/div[1]/div/div/main/form/div[4]/div[2]/div/ul/li[8]/label/span/span[3]/a")
    private WebElement linkEpisode;

    @FindBy(xpath = "/html/body/div[1]/div/div/main/div[1]/div/a")
    private WebElement buttonFave;

    public void watchShow()
    {
        logger.info("Show added to 'Watching' ");
        buttonWatch.click();
    }
    public String getAddedShow() { return titleWatch.getText();}
    public void rateShow()
    {
        logger.info("Show rated");
        buttonStar.click();
    }
    public String getRate() { return rateTitle.getText();}
    public void checkEpisode()
    {
        logger.info("Episode checked");
        checkboxEpisode.click();
        buttonSave.click();
    }
    public boolean isChecked() {
        return checkboxEpisode.isSelected();
    }
    public void openEpisode() {
        linkEpisode.click();
    }
    public void addFaves()
    {
        logger.info("Show added to favorites");
        buttonFave.click();
    }
    public String getFave() {logger.info(buttonFave.getAttribute("class")); return buttonFave.getAttribute("class"); }
}
