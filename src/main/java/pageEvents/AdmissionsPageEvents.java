package main.java.pageEvents;

import main.java.pageObjects.AdmissionsPageElements;
import main.java.utils.ElementFetch;
import main.java.utils.ElementType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class AdmissionsPageEvents {
    public void validateAdmissionsPage() {
        ElementFetch fetch = new ElementFetch();
        WebElement header = fetch.getWebElement(ElementType.CSS, AdmissionsPageElements.cssHeader);
        Assert.assertEquals(header.getText(), "Admissions");
    }

    public void validateIDsUnique(){
        ElementFetch fetch = new ElementFetch();
        List<WebElement> robotoslabH = fetch.getWebElements(ElementType.ID, AdmissionsPageElements.IdHeader);
        Assert.assertEquals(robotoslabH.size(), 1);
    }
}
