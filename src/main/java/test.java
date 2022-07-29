import pages.HomePage;
import utilities.Constants;
import utilities.utils;
import pages.SignInPage;



public class test {

    public void main(String[] args) throws Exception {
        utils.instantiate();
        utils.openPage();
        HomePage.clickSignIn();
        SignInPage.logIn(Constants.email, Constants.password);
        HomePage.clickHome();
        HomePage.addFirstElementToCart();
        utils.closeDriver();
    }
}




