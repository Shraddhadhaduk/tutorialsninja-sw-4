package demo.com.tutorialsninja.testsuite;

import demo.com.tutorialsninja.pages.DesktopsPage;
import demo.com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends BaseTest {

    DesktopsPage desktopsPage = new DesktopsPage();
    @Test
    public void verifyProductArrangeInAlphabeticalOrder(){
        //1.1 Mouse hover on Desktops Tab.and click
        desktopsPage.hoverDeskTopLink();
        //1.2 Click on “Show All Desktops”
        desktopsPage.clickOnShowAllDesktops();
        //get list before filter name
        List<WebElement> beforeFilterNameZtoAList = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductName = new ArrayList<>();
        for (WebElement e : beforeFilterNameZtoAList){
            originalProductName.add(e.getText());
        }
        System.out.println(originalProductName);
        Collections.reverse(originalProductName);
        System.out.println(originalProductName);
        //1.3 Select Sort By position "Name: Z to A"
        desktopsPage.clickOnSortBy();
        // After filter Z -A Get all the products name and stored into array list
        List<WebElement> afterfilterNameZtoAList = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductName1 = new ArrayList<>();
        for (WebElement a : afterfilterNameZtoAList){
            originalProductName1.add(a.getText());
        }
        //1.4 Verify the Product will arrange in Descending order.
        Assert.assertEquals(originalProductName, originalProductName1);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Currency Dropdown and click
        desktopsPage.clickOnCurrency();
        //2.2 Mouse hover on £Pound Sterling and click
        desktopsPage.clickOnPound();
        //2.3 Mouse hover on Desktops Tab.
        desktopsPage.hoverDeskTopLink();
        //2.4 Click on “Show All Desktops”
        desktopsPage.clickOnShowAllDesktops();
        //2.5 Select Sort By position "Name: A to Z"
        desktopsPage.clickOnAtoZ();
        //2.6 Select product “HP LP3065”
        desktopsPage.clickOnHp();
        //2.7 Verify the Text "HP LP3065"
        String actualText = desktopsPage.verifyLapTopText();
        Assert.assertEquals(actualText, "HP LP3065");
        //2.8 Select Delivery Date "2023-11-27"
        desktopsPage.datePicker();
        //2.9.Enter Qty "1” using Select class
        desktopsPage.enterQuality();
        //2.10 Click on “Add to Cart” button
        desktopsPage.clickOnAddToCart();
        //2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Thread.sleep(2000);
        String actualMessage = desktopsPage.verifyAddText();
        Assert.assertEquals(actualMessage, "Success: You have added HP LP3065 to your shopping cart!\n×");
        //2.12 Click on link “shopping cart” display into success message
        desktopsPage.clickOnShoppingLink();
        //2.13 Verify the text "Shopping Cart"
        Thread.sleep(2000);
        String actualText1 = desktopsPage.verifyTextShoppingCart();
        Assert.assertEquals(actualText1, "Shopping Cart");
        //2.14 Verify the Product name "HP LP3065"
        Thread.sleep(2000);
        String actualText2 = desktopsPage.verifyProductName();
        Assert.assertEquals(actualText2, "HP LP3065");
        //2.15 Verify the Delivery Date "2023-11-27"
        Thread.sleep(2000);
        String actualDate = desktopsPage.verifyDeliveryDate();
        Assert.assertEquals(actualDate, "2023-11-27");
        //2.16 Verify the Model "Product21"
        Thread.sleep(2000);
        String actualModel = desktopsPage.verifyModel();
        Assert.assertEquals(actualModel, "Product21");
        //2.17 Verify the Total "£74.73"
        Thread.sleep(2000);
        String actualTotal = desktopsPage.verifyTotal();
        Assert.assertEquals(actualTotal, "£74.73");



    }
}
