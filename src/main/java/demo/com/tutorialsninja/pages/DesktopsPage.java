package demo.com.tutorialsninja.pages;

import demo.com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DesktopsPage extends Utility {
    By desktopLink = By.linkText("Desktops");
    By showAllDesktopLink = By.xpath("//a[normalize-space()='Show AllDesktops']");

    By sortBy = By.xpath("(//select[@id='input-sort'])[1]");
    By currency = By.xpath("//span[normalize-space()='Currency']");

    By poundSterling = By.xpath("//button[normalize-space()='£Pound Sterling']");

    By sortByAtoZ = By.xpath("(//select[@id='input-sort'])[1]");
    By hpLp3065 = By.xpath("//a[normalize-space()='HP LP3065']");

    By verifyHp = By.xpath("//a[normalize-space()='HP LP3065']");
    By quantity = By.xpath("//input[@id='input-quantity']");
    By addToCart = By.xpath("//button[@id='button-cart']");
    By addMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By shoppingCartLink = By.xpath("//a[normalize-space()='shopping cart']");

    By verifyText = By.xpath("//a[normalize-space()='shopping cart']");
    By productName = By.xpath("(//a[contains(text(),'HP LP3065')])[2]");
    By deliveryDate = By.xpath("//small[normalize-space()='Delivery Date:2011-04-22']");
    By model = By.xpath("//td[normalize-space()='Product 21']");
    By total = By.xpath("(//td[contains(text(),'£74.73')])[4]");
    public void hoverDeskTopLink(){
        mouseHoverToElementAndClick(desktopLink);
    }
    public void clickOnShowAllDesktops(){
        clickOnElement(showAllDesktopLink);
    }

    public void clickOnSortBy(){
        clickOnElement(sortBy);
    }
    public void clickOnCurrency(){
        clickOnElement(currency);
    }
    public void clickOnPound(){
        clickOnElement(poundSterling);
    }
    public void clickOnAtoZ(){
        clickOnElement(sortByAtoZ);
    }

    public void clickOnHp(){
        clickOnElement(hpLp3065);
    }
    public String verifyLapTopText(){
        return getTextFromElement(verifyHp);
    }
    public void datePicker(){
        String year = "2023";
        String month = "November";
        String date = "27";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }
    public void enterQuality(){
        clickOnElement(quantity);
    }
    public void clickOnAddToCart(){
        clickOnElement(addToCart);
    }
    public String verifyAddText(){
        return getTextFromElement(addMessage);
    }
    public void clickOnShoppingLink(){
        clickOnElement(shoppingCartLink);
    }
    public String verifyTextShoppingCart(){
        return getTextFromElement(verifyText);
    }
    public String verifyProductName(){
        return getTextFromElement(productName);
    }

    public String verifyDeliveryDate(){
        return getTextFromElement(deliveryDate);
    }
    public String verifyModel(){
        return getTextFromElement(model);
    }
    public String verifyTotal(){
        return getTextFromElement(total);
    }



}
