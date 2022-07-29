import pages.HomePage;
import pages.SignInPage;
import utilities.Constants;
import utilities.utils;

public class runTests {
    HomePage homePage;
    SignInPage signInPage;
    Constants constants;
    utils utils;




    utils.instantiate();
    utils.openPage();
    homePage.clickSignIn();
    signInPage.logIn(Constants.email, Constants.password);
    homePage.clickHome();
    homePage.addFirstElementToCart();
    utils.closeDriver();


}
