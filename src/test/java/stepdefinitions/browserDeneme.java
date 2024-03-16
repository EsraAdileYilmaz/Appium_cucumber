package stepdefinitions;

import io.cucumber.java.en.Given;
import utilities.BrowserDriver;

public class browserDeneme {

    @Given("Kullanici belirledigi {string} url e gider")
    public void kullanici_belirledigi_url_e_gider(String url) {
        BrowserDriver.getBrowserDriver().get(url);
    }

}
