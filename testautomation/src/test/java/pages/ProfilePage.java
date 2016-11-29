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
public class ProfilePage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://myshows.me/profile/";
    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Profile page opened");
    }

    @FindBy(xpath = "/html/body/div/footer/div/div/div[1]/div/div[1]/div[1]")
    private WebElement buttonLanguage;

    @FindBy(xpath = "/html/body/div/footer/div/div/div[1]/div/div[2]/ul/li[2]")
    private WebElement buttonEng;

    @FindBy(xpath = "/html/body/div/header/div/div/div[2]/ul/li[1]/a")
    private WebElement buttonShows;

    @FindBy(xpath = "/html/body/div[1]/div/div/main/table/tbody/tr[21]/td[1]/a")
    private WebElement buttonShow;

    @FindBy(xpath = "/html/body/div/header/div/div/div[2]/ul/li[3]/a")
    private WebElement buttonCommunity;

    @FindBy(xpath = "/html/body/div[1]/div/div/main/div[4]/a[1]/span")
    private WebElement buttonFriend;

    @FindBy(xpath = "/html/body/div[1]/div/div/aside/p[3]/button")
    private WebElement buttonAdd;


    public void changeLang()
    {
        buttonLanguage.click();
        buttonEng.click();
        logger.info("Language changed");
    }
    public void addShow()
    {
        buttonShows.click();
        buttonShow.click();
        logger.info("Show added");
    }
    public void addFriend()
    {
        buttonCommunity.click();
        buttonFriend.click();
        buttonAdd.click();
        logger.info("Friend added");
    }
    public String getFriend() {  return buttonAdd.getText();}
}
