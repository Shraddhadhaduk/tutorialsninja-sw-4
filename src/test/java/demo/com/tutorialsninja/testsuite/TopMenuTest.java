package demo.com.tutorialsninja.testsuite;

import demo.com.tutorialsninja.pages.TopMenuPage;
import demo.com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {
  TopMenuPage topMenuPage = new TopMenuPage();

  @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
       //1.1 Mouse hover on “Desktops” Tab and click
      topMenuPage.hoverDeskTopLink();
      topMenuPage.clickOnShowAllDesktops();
      //1.2 call selectMenu method and pass the menu = “Show All Desktops”
      topMenuPage.selectMenu("Show All Desktops");
      //1.3 Verify the text ‘Desktops’
      String actualDesktopsText = topMenuPage.verifyDesktopText();
      Assert.assertEquals(actualDesktopsText,"Desktops","text not match");
  }

  @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
      //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
      topMenuPage.hoverLaptopAndNotebooks();
      topMenuPage.clickOnLaptopAndNotebooksLink();
      //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
      topMenuPage.selectMenu("Show All Desktops");
      //2.3 Verify the text ‘Laptops & Notebooks’
    Thread.sleep(2000);
      String actualLaptopAndNotebooksText = topMenuPage.verifyLaptopAndNotebooksText();
      Assert.assertEquals(actualLaptopAndNotebooksText,"Laptops & Notebooks");
  }

  @Test
  public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
    //3.1 Mouse hover on “Components” Tab and click
    topMenuPage.hoverComponentLink();
    topMenuPage.clickOnComponentLink();
    //3.2 call selectMenu method and pass the menu = “Show All Components”
    topMenuPage.selectMenu("Show All Desktops");
    //3.3 Verify the text ‘Components
    Thread.sleep(2000);
    String actualComponentText = topMenuPage.verifyComponentText();
    Assert.assertEquals(actualComponentText, "Components");

  }

}
