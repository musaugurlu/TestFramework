package test.java;

import main.java.pageEvents.AboutPageEvents;
import main.java.pageEvents.HomePageEvents;
import org.testng.annotations.Test;

public class AboutpageTest extends BaseTest{
    @Test
    public void validateAboutPage(){
        HomePageEvents homePage = new HomePageEvents();
        homePage.clickOnAboutMenuLink();

        AboutPageEvents aboutPage = new AboutPageEvents();
        aboutPage.validateAboutPage();
    }
}
