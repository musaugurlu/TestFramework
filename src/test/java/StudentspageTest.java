package test.java;

import main.java.pageEvents.HomePageEvents;
import main.java.pageEvents.StudentsPageEvents;
import org.testng.annotations.Test;

public class StudentspageTest extends BaseTest{
    @Test
    public void validateStudentsPage(){
        HomePageEvents homePage = new HomePageEvents();
        homePage.clickOnStudentsMenuLink();

        StudentsPageEvents studentPage = new StudentsPageEvents();
        studentPage.validateStudentsPage();
    }
}
