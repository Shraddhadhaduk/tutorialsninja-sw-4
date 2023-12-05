package demo.com.tutorialsninja.testsuite;

import demo.com.tutorialsninja.pages.MyAccountPage;
import demo.com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class MyAccountsTest extends BaseTest {
    MyAccountPage myAccountPage = new MyAccountPage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        //1.1 Click on My Account Link.
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        String option = "Register";
        myAccountPage.selectMyAccount(option);

        //1.3 Verify the text “Register Account”.
        String expectedText1 = "Register Account";
        String actualText1 = myAccountPage.verifyRegisterAccountText();
        Assert.assertEquals(actualText1, expectedText1);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        //2.1 Click on My Account Link.
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        String option = "Login";
        myAccountPage.selectMyAccount(option);
        //2.3 Verify the text “Returning Customer”.
        String expectedMessage = "Returning Customer";
        String actualMessage = myAccountPage.getReturningCustomerText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link.
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        String option = "Register";
        myAccountPage.selectMyAccount(option);
        //3.3 Enter First Name
        myAccountPage.enterFirstName("Shraddha");
        //3.4 Enter Last Name
        myAccountPage.enterSecondName("Malaviya");
        //3.5 Enter Email
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        myAccountPage.enterEmail("Happy" + randomInt + "@gmail.com");
        //3.6 Enter Telephone
        myAccountPage.enterTelephone("0987654321");
        //3.7 Enter Password
        myAccountPage.enterPassword("Gate@1234");
        //3.8 Enter Password Confirm
        myAccountPage.enterConfirmPassword("Gate@1234");
        //3.9 Select Subscribe Yes radio button
        myAccountPage.selectSubscribeButton("Yes");
        //3.10 Click on Privacy Policy check box
        myAccountPage.clickOnAgree();
        //3.11 Click on Continue button
        myAccountPage.clickOnContinue();
        //3.12 Verify the message “Your Account Has Been Created!”
        String expectedText2 = "Your Account Has Been Created!";
        String actualText2 = myAccountPage.getAccountCreatedText();
        Assert.assertEquals(actualText2, expectedText2);
        //3.13 Click on Continue button
        myAccountPage.clickOnContinueButton2();
        //3.14 Click on My Account Link.
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        Thread.sleep(2000);
        option = "Logout";
        myAccountPage.getAccountLogoutText();
        //3.16 Verify the text “Account Logout”
        Thread.sleep(2000);
        String expectedText3 = "Account Logout";
        String actualText3 = myAccountPage.getAccountLogoutText();
        Assert.assertEquals(actualText3, expectedText3);
        //3.17 Click on Continue button
        myAccountPage.clickOnContinueButton2();
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //4.1 Click on My Account Link. 4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        String option = "Login";
        myAccountPage.selectMyAccount(option);

        //4.3 Enter Email address
        myAccountPage.enterEmailId("Prime1234568@gmail.com");

        // 4.5 Enter password
        myAccountPage.enterPassword("Prime@123");

        //4.6 Click on Login button
        myAccountPage.clickOnLogin();

        //4.7 Verify text “My Account”
        String expectedText = "My Account";
        String actualText = myAccountPage.getMyAccountText();
        Assert.assertEquals(actualText,expectedText);

        //4.8 Click on My Account Link. 4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout
        option = "Logout";
        myAccountPage.selectMyAccount(option);

        // 4.10 Verify the text “Account Logout
        Thread.sleep(2000);
        String expectedText1 = "Account Logout";
        String actualText1 = myAccountPage.getAccountLogoutText();
        Assert.assertEquals(actualText1,expectedText1);

        //4.11 Click on Continue button
        Thread.sleep(2000);
        myAccountPage.clickOnContinueButton2();
    }

}
