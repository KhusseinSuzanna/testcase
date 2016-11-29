package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Suzanna on 27.11.2016.
 */
public abstract class AbstractPage {
    protected WebDriver driver;

    public abstract void openPage();

    public AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }
}
