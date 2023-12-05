package demo.com.tutorialsninja.testsuite;

import demo.com.tutorialsninja.pages.LaptopAndNotebooksPage;
import demo.com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends BaseTest {
    LaptopAndNotebooksPage laptopAndNotebooksPage = new LaptopAndNotebooksPage();
     @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
         //1.1 Mouse hover on Laptops & Notebooks Tab.and click
         laptopAndNotebooksPage.hoverLaptopAndNotebooks();
         //1.2 Click on “Show All Laptops & Notebooks”
         laptopAndNotebooksPage.clickOnLaptopAndNotebooksLink();
         // Before get price high to low
         List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
         List<Double> originalProductsPrice = new ArrayList<>();
         for (WebElement e : products) {
             System.out.println(e.getText());
             String[] arr = e.getText().split("Ex Tax:");
             originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
         }
         System.out.println(originalProductsPrice);
         // Sort By Reverse order
         Collections.sort(originalProductsPrice, Collections.reverseOrder());
         System.out.println(originalProductsPrice);
         //1.3 Select Sort By "Price (High > Low)"
         laptopAndNotebooksPage.sortByPrice("Price (High > Low)");
         //After get price High to low
         products = driver.findElements(By.xpath("//p[@class ='price']"));
         ArrayList<Double> afterSortByPrice = new ArrayList<>();
         for (WebElement e : products) {
             String[] arr = e.getText().split("Ex Tax:");
             afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
         }
         System.out.println(afterSortByPrice);

         //1.4 Verify the Product price will arrange in High to Low order.
         Assert.assertEquals(originalProductsPrice, afterSortByPrice);
     }
     @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
         //2.1 Mouse hover on Laptops & Notebooks Tab and click
         laptopAndNotebooksPage.hoverLaptopAndNotebooks();
         //2.2 Click on “Show All Laptops & Notebooks”
         laptopAndNotebooksPage.clickOnLaptopAndNotebooksLink();
         //2.3 Select Sort By "Price (High > Low)"
         laptopAndNotebooksPage.sortByPrice("Price (High > Low)");
         //2.4 Select Product “MacBook”
         laptopAndNotebooksPage.selectProductMacBook();
         //2.5 Verify the text “MacBook”
         String actualText = laptopAndNotebooksPage.verifyMacBook();
         Assert.assertEquals(actualText, "MacBook");
         //2.6 Click on ‘Add To Cart’ button
         laptopAndNotebooksPage.clickOnAddToCart();
         //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
         String actualText1 = laptopAndNotebooksPage.verifySuccessMessage();
         //2.8 Click on link “shopping cart” display into success message
         laptopAndNotebooksPage.clickOnShoppingCart();
         //2.9 Verify the text "Shopping Cart"
         String actualText2 = laptopAndNotebooksPage.verifyShoppingCartText();
         Assert.assertEquals(actualText2, "Shopping Cart");
         //2.10 Verify the Product name "MacBook"
         String actualText3 = laptopAndNotebooksPage.verifyMacbookText();
         //2.11 Change Quantity "2"
         laptopAndNotebooksPage.changeQty();
         //2.12 Click on “Update” Tab
         laptopAndNotebooksPage.clickOnUpdate();
         //2.13 Verify the message “Success: You have modified your shopping cart!”
         String actualText4 = laptopAndNotebooksPage.VerifyModifyText();
         Assert.assertEquals(actualText4, "Success: You have modified your shopping cart!");
         //2.14 Verify the Total £737.45
         String actualText5 = laptopAndNotebooksPage.verifyTotalAmount();
         Assert.assertEquals(actualText5, "£737.45");
         //2.15 Click on “Checkout” button
         laptopAndNotebooksPage.clickOnCheckOut();
         //2.16 Verify the text “Checkout”
         String actualText6 = laptopAndNotebooksPage.verifyCheckOut();
         Assert.assertEquals(actualText5, "Checkout");
         //2.17 Verify the Text “New Customer”
         String actualText7 = laptopAndNotebooksPage.verifyNewCustomerText();
         Assert.assertEquals(actualText7, "New Customer");
         //2.18 Click on “Guest Checkout” radio button
         laptopAndNotebooksPage.clickOnGuestCheckOut();
         //2.19 Click on “Continue” tab
         laptopAndNotebooksPage.clickOnContinue();
         //2.20 Fill the mandatory fields
         laptopAndNotebooksPage.enterFirstName("Shraddha");
         laptopAndNotebooksPage.enterLastName("Malaviya");
         laptopAndNotebooksPage.enterEmail("blue@gmail.com");
         laptopAndNotebooksPage.enterPhoneNumber("0987654321");
         laptopAndNotebooksPage.enterAddress1("27 epsom road");
         laptopAndNotebooksPage.enterCity("Kingston");
         laptopAndNotebooksPage.enterPostCode("sw190fv");
         laptopAndNotebooksPage.selectCountry("United Kingdom");
         laptopAndNotebooksPage.selectRegion("Hindu");
         //2.21 Click on “Continue” Button
         laptopAndNotebooksPage.clickOnContinueCheckOut();
         //2.22 Add Comments About your order into text area
         laptopAndNotebooksPage.enterComment("Thank you");
         //2.23 Check the Terms & Conditions check box
         laptopAndNotebooksPage.clickOnAgree();
         //2.24 Click on “Continue” button
         laptopAndNotebooksPage.clickOnGuestContinue();
         //2.25 Verify the message “Warning: Payment method required!”
         String actualText8 = laptopAndNotebooksPage.verifyPaymentWarning();
         Assert.assertEquals(actualText8, "Warning: Payment method required!");
     }

}
