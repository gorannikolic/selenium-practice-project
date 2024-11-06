package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

    @Test(groups = {"Sanity", "Master"})
    public void verify_login() {
        logger.info("****** Starting TC_002_LoginTest *****");

        try {
            //HomePage
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();

            //Login
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmail(p.getProperty("email"));
            loginPage.setPassword(p.getProperty("password"));
            loginPage.clickLogin();

            //MyAccount
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean targetPage = myAccountPage.isMyAccountPageExists();

            Assert.assertTrue(targetPage);//Assert.assertEquals(targetPage, true,"Login failed");
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("****** Finished TC_002_LoginTest *****");
    }

}
