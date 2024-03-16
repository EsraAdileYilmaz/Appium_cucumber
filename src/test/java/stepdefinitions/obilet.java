package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ObiletPage;
import utilities.BrowserDriver;
import utilities.ReusableMethods;

public class obilet {

    ObiletPage obiletPage=new ObiletPage();

    @Given("{string} sayfasina gidilir")
    public void sayfasina_gidilir(String url) {
        BrowserDriver.getBrowserDriver().get(url);
    }

    @When("Sag ust koseden menu hamburgerine tiklanir")
    public void sagUstKosedenMenuHamburgerineTiklanir() {
    obiletPage.menuButton.click();
    }


    @Given("Dil olarak turkce secilir")
    public void dil_olarak_turkce_secilir() {
    obiletPage.languageButton.click();
    obiletPage.turkisLanguage.click();
    }

    @Given("Para birimi olarak tl secilir")
    public void para_birimi_olarak_tl_secilir() {
    obiletPage.currencySelect.click();
    obiletPage.turkishLira.click();
    }

    @Given("Otobus bileti bul a tiklanir")
    public void otobus_bileti_bul_a_tiklanir() {
    obiletPage.searchButton.click();
    ReusableMethods.wait(3);
    }

    @Given("Gelen bilet fiyatlarinin {string} oldugu dogrulanir")
    public void gelen_bilet_fiyatlarinin_tl_oldugu_dogrulanir(String paraBirimi) {
    ReusableMethods.wait(5);
    Assert.assertTrue(obiletPage.priceTypeResult.getText().contains(paraBirimi));
    }


    @When("Kullanici browser i kapatir")
    public void kullaniciBrowserIKapatir() {
        BrowserDriver.quitAppiumDriver();
    }
}
