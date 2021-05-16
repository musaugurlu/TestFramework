package test.java;

import main.java.pageEvents.HomePageEvents;
import main.java.pageEvents.StudentsPageEvents;
import org.testng.annotations.Test;

public class HomepageTest extends BaseTest{
    @Test
    public void validateHomePage(){
        HomePageEvents homePage = new HomePageEvents();
        homePage.validateHomePage(driver.getTitle());
    }

    @Test
    public void validateSearchInput(){
        HomePageEvents homePage = new HomePageEvents();
        homePage.validateSearchInput();
    }

    @Test
    public void searchInHomePage(){
        HomePageEvents homePage = new HomePageEvents();
        homePage.searchComputerScience();
        homePage.validateSearch();
    }
}
