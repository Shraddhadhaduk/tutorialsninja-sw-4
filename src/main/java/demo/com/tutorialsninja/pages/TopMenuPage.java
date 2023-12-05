package demo.com.tutorialsninja.pages;

import demo.com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopMenuPage extends Utility {
    public void selectMenu(String menu){
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }
    By desktopLink = By.linkText("Desktops");
    By showAllDesktopLink = By.xpath("//a[normalize-space()='Show AllDesktops']");
    By desktopText = By.xpath("//h2[contains(text(),'Desktops')]");

    By laptopAndNotebooksLink = By.linkText("Laptops & Notebooks");
    By showAllLaptopAndNotebooksLink = By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']");

    By laptopAndNotebooksText = By.xpath("//h2[normalize-space()='Laptops & Notebooks']");
    By componentLink =  By.linkText("Components");
    By showAllComponentLink = By.xpath("//a[normalize-space()='Show AllComponents']");
    By componentText = By.xpath("//h2[normalize-space()='Components']");

    public void hoverDeskTopLink(){
        mouseHoverToElementAndClick(desktopLink);
    }
    public void clickOnShowAllDesktops(){
        clickOnElement(showAllDesktopLink);
    }
    public String verifyDesktopText(){
        return getTextFromElement(desktopText);
    }
    public void hoverLaptopAndNotebooks(){
        mouseHoverToElementAndClick(laptopAndNotebooksLink);
    }

    public void clickOnLaptopAndNotebooksLink(){
        clickOnElement(showAllLaptopAndNotebooksLink);
    }
    public String verifyLaptopAndNotebooksText(){
        return getTextFromElement(laptopAndNotebooksText);
    }
    public void hoverComponentLink(){
        mouseHoverToElementAndClick(componentLink);
    }
    public void clickOnComponentLink(){
        clickOnElement(showAllComponentLink);
    }
    public String verifyComponentText(){
        return getTextFromElement(componentText);
    }
}
