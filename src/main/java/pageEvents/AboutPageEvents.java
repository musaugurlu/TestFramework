package main.java.pageEvents;

import main.java.pageObjects.AboutPageElements;
import main.java.utils.ElementFetch;
import main.java.utils.ElementType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AboutPageEvents {
    public void validateAboutPage(){
        ElementFetch fetch = new ElementFetch();
        WebElement header = fetch.getWebElement(ElementType.CSS,AboutPageElements.cssHeader);
        Assert.assertEquals(header.getText(), "About the University");
    }
}
