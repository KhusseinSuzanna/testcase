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
public class EpisodePage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://myshows.me/view/episode/1749459/";
    public EpisodePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Episode page opened");
    }

    @FindBy(xpath = "/html/body/div[1]/div/div/main/div[1]/span/a[1]")
    private WebElement starEpisode;

    @FindBy(xpath = "/html/body/div[1]/div/div/main/div[1]/span")
    private WebElement rateDiv;

    @FindBy(xpath = "//*[@id=\"comment\"]/p[1]/textarea")
    private WebElement inputComment;

    @FindBy(xpath = "//*[@id=\"comment\"]/p[2]/button/b")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//*[@id=\"comments\"]/div[29]/div/div[1]/p")
    private WebElement textComment;

    @FindBy(xpath = "//*[@id=\"comments\"]/div[1]/div/div[2]/a[1]")
    private WebElement likeComment;

    public void rateEpisode()
    {
        logger.info("Episode rated");
        starEpisode.click();
    }
    public String getRatedEpisode() { return rateDiv.getAttribute("class"); }
    public void addComment(String comment)
    {
        logger.info("Comment added");
        inputComment.sendKeys(comment);
        buttonSubmit.click();
    }
    public String getComment() { return textComment.getText(); }
    public void rateComment()
    {
        logger.info("Comment rated");
        likeComment.click();
    }
    public String getRatedComment() {  return likeComment.getAttribute("class"); }
}
