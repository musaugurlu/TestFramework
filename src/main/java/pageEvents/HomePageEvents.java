package main.java.pageEvents;

import main.java.pageObjects.AboutPageElements;
import main.java.pageObjects.HomePageElements;
import main.java.utils.ElementFetch;
import main.java.utils.ElementType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomePageEvents {
    public void validateHomePage(String title) {
        ElementFetch elementFetch = new ElementFetch();
        String expectedTitle = "Welcome to North American University | Houston TX";
        Assert.assertEquals(title, expectedTitle);
    }

    public void validateSearchInput() {
        ElementFetch elementFetch = new ElementFetch();
        List<WebElement> searchInput = elementFetch.getWebElements(ElementType.CSS, HomePageElements.cssSearchInput);
        Assert.assertTrue(searchInput.size() > 0, "Homepage is not loaded correctly!");
    }

    public void validateSearch(){
        ElementFetch elementFetch = new ElementFetch();
        List<WebElement> searchResults = elementFetch.getWebElements(ElementType.CSS, HomePageElements.cssSearchResults);
        Assert.assertTrue(searchResults.size() > 0, "Search Results could not be validated!");
    }

    public void searchComputerScience() {
        ElementFetch elementFetch = new ElementFetch();
        WebElement searchInput = elementFetch.getWebElement(ElementType.CSS, HomePageElements.cssSearchInput);
        searchInput.sendKeys("Computer Science");
        searchInput.sendKeys(Keys.RETURN);
    }

    public void clickOnStudentsMenuLink(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement(ElementType.ID, HomePageElements.idStudentsLink).click();
    }

    public void clickOnAboutMenuLink(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement(ElementType.XPATH, HomePageElements.xpathAboutMenuLink).click();
    }

    public void clickOnAdmissionsLinkInFooter(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement(ElementType.CSS, HomePageElements.cssAdmissionsinFooter).click();
    }
}
