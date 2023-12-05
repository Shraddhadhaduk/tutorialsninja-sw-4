package demo.com.tutorialsninja.pages;

import demo.com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class LaptopAndNotebooksPage extends Utility {
    By laptopAndNotebooksLink = By.linkText("Laptops & Notebooks");
    By showAllLaptopAndNotebooksLink = By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']");
    By price = By.id("input-sort");
    By selectProduct =By.linkText("MacBook");
    By macBookText = By.xpath("//h1[contains(text(),'MacBook')]");
    By addToCart =  By.xpath("//button[@id='button-cart']");
    By successText = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");
    By shoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");
    By shoppingCartText = By.xpath("//div[@id='content']//h1");

    By macBookText1 = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    By changeQty = By.xpath("//input[contains(@name, 'quantity')]");
    By updateQty = By.xpath("//button[contains(@data-original-title, 'Update')]");

    By modifiedText =  By.xpath("//div[@id='checkout-cart']/div[1]");
    By total = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");
    By checkOut = By.xpath("//a[@class='btn btn-primary']");
    By checkOutText = By.xpath("//h1[normalize-space()='Checkout']");
    By newCustomerText = By.xpath("//h2[normalize-space()='New Customer']");
    By guestCheckOut = By.xpath("//input[@value='guest']");
    By continueButton = By.xpath("//input[@id='button-account']");
    By firstName = By.xpath("//input[@id='input-payment-firstname']");
    By lastName = By.xpath("//input[@id='input-payment-lastname']");
    By email = By.xpath("//input[@id='input-payment-email']");
    By telephone = By.xpath("//input[@id='input-payment-telephone']");
    By address1 = By.xpath("//input[@id='input-payment-address-1']");
    By city = By.xpath("//input[@id='input-payment-city']");
    By postcode = By.xpath("//input[@id='input-payment-postcode']");
    By country = By.xpath("//select[@id='input-payment-country']");
    By region = By.xpath("//select[@id='input-payment-zone']");
    By continueButtonLast = By.xpath("//input[@id='button-guest']");
    By comments = By.xpath("//textarea[@name='comment']");
    By agree = By.xpath("//input[@type='checkbox']");
    By guestContinueButton = By.xpath("//input[@name = 'agree']");
    By warningText = By.xpath("//div[@class='alert alert-warning alert-dismissible']");

    public void hoverLaptopAndNotebooks(){
        mouseHoverToElementAndClick(laptopAndNotebooksLink);
    }
    public void clickOnLaptopAndNotebooksLink(){
        clickOnElement(showAllLaptopAndNotebooksLink);
    }
    public void sortByPrice(String sortBy){
        selectByVisibleTextFromDropDown(price, sortBy);
    }
    public void selectProductMacBook(){
        clickOnElement(selectProduct);
    }
    public String verifyMacBook(){
        return getTextFromElement(macBookText);
    }
    public void clickOnAddToCart(){
        clickOnElement(addToCart);
    }
    public String verifySuccessMessage(){
        return getTextFromElement(successText);
    }
    public void clickOnShoppingCart(){
        clickOnElement(shoppingCart);
    }
    public String verifyShoppingCartText(){
        return getTextFromElement(shoppingCartText);
    }
    public String verifyMacbookText(){
        return getTextFromElement(macBookText1);
    }
    public void changeQty(){
        driver.findElement(changeQty).clear();
        sendTextToElement(changeQty,"2");
    }
    public void clickOnUpdate(){
        clickOnElement(updateQty);
    }
    public String VerifyModifyText(){
        return getTextFromElement(modifiedText);
    }
    public String verifyTotalAmount(){
        return getTextFromElement(total);
    }
    public void clickOnCheckOut(){
        clickOnElement(checkOut);
    }
    public String verifyCheckOut(){
        return getTextFromElement(checkOutText);
    }
    public String verifyNewCustomerText(){
        return getTextFromElement(newCustomerText);
    }
    public void clickOnGuestCheckOut(){
        clickOnElement(guestCheckOut);
    }
    public void clickOnContinue(){
        clickOnElement(continueButton);
    }
    public void enterFirstName(String first){
        sendTextToElement(firstName, first);
    }

    public void enterLastName(String last){
        sendTextToElement(lastName, last);
    }
    public void enterEmail(String mail){
        sendTextToElement(email, mail);
    }
    public void enterPhoneNumber(String number){
        sendTextToElement(telephone, number);
    }
    public void enterAddress1(String address){
        sendTextToElement(address1, address);
    }
    public void enterCity(String town){
        sendTextToElement(city, town);
    }
    public void enterPostCode(String code){
        sendTextToElement(postcode, code);
    }
    public void selectCountry(String value){
        selectByVisibleTextFromDropDown(country, value);
    }
    public void selectRegion(String value){
        selectByVisibleTextFromDropDown(region, value);
    }
    public void clickOnContinueCheckOut(){
        clickOnElement(continueButtonLast);
    }
    public void enterComment(String comment){
        sendTextToElement(comments, comment);
    }
    public void clickOnAgree(){
        clickOnElement(agree);
    }
    public void clickOnGuestContinue(){
        clickOnElement(guestContinueButton);
    }
    public String verifyPaymentWarning(){
        return getTextFromElement(warningText);
    }

}
