import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.Steps;

/**
 * Created by Suzanna on 27.11.2016.
 */
public class TestAutomation {
    private Steps steps;
    private final String USERNAME = "fortesting";
    private final String PASSWORD = "12345678";
    private final String COMMENT = "Отличная серия!";

    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description = "Login to Myshows")
    public void oneCanLoginMyshows()
    {
        steps.loginMyshows(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }
    @Test(description = "Change language")
    public void oneCanChangeLanguage()
    {
        steps.loginMyshows(USERNAME, PASSWORD);
        steps.changeLanguage();
        Assert.assertTrue(steps.isChanged("New episodes"));
    }
    @Test(description = "Add show to profile")
    public void oneCanAddShow()
    {
        steps.loginMyshows(USERNAME, PASSWORD);
        steps.addShow();
        Assert.assertTrue(steps.isAdded());
    }
    @Test(description = "Rate a show")
    public void oneCanRateShow()
    {
        steps.loginMyshows(USERNAME, PASSWORD);
        steps.addShow();
        steps.rateShow();
        Assert.assertTrue(steps.isRated("Отличный сериал"));
    }
    @Test(description = "Check watched episodes")
    public void oneCanCheckEpisode()
    {
        steps.loginMyshows(USERNAME, PASSWORD);
        steps.addShow();
        steps.checkEpisode();
        Assert.assertTrue(steps.isChecked());
    }
    @Test(description = "Add a friend")
    public void oneCanAddFriend()
    {
        steps.loginMyshows(USERNAME, PASSWORD);
        steps.addFriend();
        Assert.assertTrue(steps.isAddedFriend());
    }
    @Test(description = "Rate an episode")
    public void oneCanRateEpisode()
    {
        steps.loginMyshows(USERNAME, PASSWORD);
        steps.addShow();
        steps.rateEpisode();
        Assert.assertTrue(steps.isRatedEpisode());
    }
    @Test(description = "Add a comment")
    public void oneCanAddComment()
    {
        steps.loginMyshows(USERNAME, PASSWORD);
        steps.addShow();
        steps.addComment(COMMENT);
        Assert.assertTrue(steps.isCommentAdded(COMMENT));
    }
    @Test(description = "Rate a comment")
    public void oneCanRateComment()
    {
        steps.loginMyshows(USERNAME, PASSWORD);
        steps.addShow();
        steps.rateComment();
        Assert.assertTrue(steps.isCommentRated());
    }
    @Test(description = "Add show to favorites")
    public void oneCanAddToFaves()
    {
        steps.loginMyshows(USERNAME, PASSWORD);
        steps.addShow();
        steps.addFaves();
        Assert.assertTrue(steps.isFave());
    }
    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
