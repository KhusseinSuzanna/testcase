package steps;

import driver.DriverWorker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.*;

/**
 * Created by Suzanna on 27.11.2016.
 */
public class Steps {
    private WebDriver driver;

    private final Logger logger = LogManager.getRootLogger();

    public void initBrowser()
    {   driver = DriverWorker.getDriver(); }

    public void closeDriver()
    {
        DriverWorker.closeDriver();
    }

    public void loginMyshows(String username, String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);
    }

    public boolean isLoggedIn(String username)
    {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.getLoggedInUserName().trim().toLowerCase().equals(username));
    }
    public void changeLanguage() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openPage();
        profilePage.changeLang();
    }
    public boolean isChanged(String title)
    {
        EngProfilePage engProfilePage = new EngProfilePage(driver);
        engProfilePage.openPage();
        return (engProfilePage.getChangedLanguage().trim().equals(title));
    }

    public void addShow() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.addShow();
        ShowPage showPage = new ShowPage(driver);
        showPage.watchShow();
    }
    public boolean isAdded() {
        ShowPage showPage = new ShowPage(driver);
        return (showPage.getAddedShow().trim().equals("Смотрю"));
    }
    public void rateShow()
    {
        ShowPage showPage = new ShowPage(driver);
        showPage.rateShow();
    }
    public boolean isRated(String title)
    {
        ShowPage showPage = new ShowPage(driver);
        return (showPage.getRate().trim().equals(title));
    }
    public void checkEpisode()
    {
        ShowPage showPage = new ShowPage(driver);
        showPage.checkEpisode();
    }
    public boolean isChecked() {
        ShowPage showPage = new ShowPage(driver);
        return showPage.isChecked();
    }
    public void addFriend()
    {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.addFriend();
    }
    public boolean isAddedFriend() {
        ProfilePage profilePage = new ProfilePage(driver);
        return profilePage.getFriend().trim().equals("УДАЛИТЬ ИЗ ДРУЗЕЙ");
    }
    public void rateEpisode()
    {
        ShowPage showPage = new ShowPage(driver);
        showPage.openEpisode();
        EpisodePage episodePage = new EpisodePage(driver);
        episodePage.openPage();
        episodePage.rateEpisode();
    }
    public boolean isRatedEpisode()
    {
        EpisodePage episodePage = new EpisodePage(driver);
        return episodePage.getRatedEpisode().equals("elementRate  _rate5");
    }
    public void addComment(String comment)
    {
        ShowPage showPage = new ShowPage(driver);
        showPage.openEpisode();
        EpisodePage episodePage = new EpisodePage(driver);
        episodePage.openPage();
        episodePage.addComment(comment);
    }
    public boolean isCommentAdded(String comment)
    {
        EpisodePage episodePage = new EpisodePage(driver);
        return (episodePage.getComment().trim().equals(comment));
    }
    public void rateComment()
    {
        ShowPage showPage = new ShowPage(driver);
        showPage.openEpisode();
        EpisodePage episodePage = new EpisodePage(driver);
        episodePage.openPage();
        episodePage.rateComment();
    }
    public boolean isCommentRated()
    {
        EpisodePage episodePage = new EpisodePage(driver);
        return episodePage.getRatedComment().equals("_plus _pass");
    }
    public void addFaves()
    {
        ShowPage showPage = new ShowPage(driver);
        showPage.addFaves();
    }
    public boolean isFave() {
        ShowPage showPage = new ShowPage(driver);
        return showPage.getFave().trim().equals("presentBlockBookmark  _active");
    }
}
