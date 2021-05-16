package main.java.pageEvents;

import main.java.pageObjects.StudentsPageElements;
import main.java.utils.ElementFetch;
import main.java.utils.ElementType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class StudentsPageEvents {
    public void validateStudentsPage() {
        ElementFetch elementFetch = new ElementFetch();
        WebElement header = elementFetch.getWebElement(ElementType.XPATH,StudentsPageElements.studentResources);
        Assert.assertTrue(header.getText().equals("Student Resources"),"Students page did not loaded correctly!");
    }
}
