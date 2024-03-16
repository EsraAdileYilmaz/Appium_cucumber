package stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.AileButcemPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class aileButcem {

    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    AileButcemPage aileButcemPage=new AileButcemPage();//aldigimiz locate'lere ulasmak icin
    /*Aile Butcem=>"appPackage","com.ailebutcem"
      # "appActivity","com.ailebutcem.MainActivity"*/
    @Given("ilk ekran ayarlarini yapin {int} {int} {int} {int} {int} {int} {int} {int} ve ardindan login {string} sayfasina ulasin")
    public void ilk_ekran_ayarlarini_yapin_ve_ardindan_login_sayfasina_ulasin(int for1, int forSart, int xPress,
                                                                              int yPress, int waitAction, int xMoveTo,
                                                                              int yMoveTo, int bekleme, String girisText) throws InterruptedException {
       ReusableMethods.wait(4);
        //x1=947  y1=1019  wait action x2=125 y2=1019
       aileButcemPage.ilkEkranAyarlamalari(for1,forSart,xPress,yPress,waitAction,
                                           xMoveTo,yMoveTo,bekleme,girisText);//AileButcemPage class'indan method call yapildi.
       //bunun icindeki degerler (ilk ekran ayarlarini yapin 0 6 946 1019 500 125 1019 500 ve ardindan login "Giriş Yap" sayfasina ulasin) burdan gelen degerlerdir.
       //for1=0,forSart=6,xPress=946,yPress=1019,waitAction=500,xMoveTo=125,yMoveTo=1019,bekleme=500,girisText=Giriş Yap
        //ReusableMethods.wait(3);

    }

    @Given("{string} ve {string} bilgilerini girerek kullanici bilgileriyle {string} giris yapin")
    public void ve_bilgilerini_girerek_kullanici_bilgileriyle_giris_yapin(String mail, String sifre,String girisYap) {

        aileButcemPage.emailBox.sendKeys(ConfigReader.getProperty(mail));
        aileButcemPage.passwordBox.sendKeys(ConfigReader.getProperty(sifre));
        ReusableMethods.scrollWithUiScrollable(girisYap);//burdaki bilgi direk feature icinden aliniyor
    }

    @Given("uygulamaya kullanici bilgileriyle giris yapildigini dogrulayin")
    public void uygulamaya_kullanici_bilgileriyle_giris_yapildigini_dogrulayin() {
        Assert.assertTrue(aileButcemPage.girisYapildiText.isDisplayed());
    }

    @Given("sol kisimdaki menuden {string} bolumune gidin")
    public void sol_kisimdaki_menuden_hesabim_bolumune_gidin(String hesabim) throws InterruptedException {
    aileButcemPage.ucCizgiTiklamaMethodu();//method call yaparak Butcem yazisinin yanindaki uc cizgiye tikladik
    ReusableMethods.scrollWithUiScrollable(hesabim);

    }

    @Given("hesabim sayfasindaki bilgileri degistirerek {string} {string} {string} {string} {string} degisikleri kaydedin ve dogrulayin")
    public void hesabim_sayfasindaki_bilgileri_degistirerek_degisikleri_kaydedin(String isim,String soyisim,
                                                                                 String sehir,String yas,String meslek) {
    aileButcemPage.textBoxVeriGirme(ConfigReader.getProperty(isim),ConfigReader.getProperty(soyisim),ConfigReader.getProperty(sehir),ConfigReader.getProperty(yas),ConfigReader.getProperty(meslek));//burada varolan degerler once silinir sonra yeni degerler gonderilir
    aileButcemPage.textBoxKontrol(ConfigReader.getProperty(isim),ConfigReader.getProperty(soyisim),ConfigReader.getProperty(sehir),ConfigReader.getProperty(yas),ConfigReader.getProperty(meslek));//burada ise gonderdigimiz degerlerin gidip-gitmedigi kontrol edilir

    }

    @Given("kullanici uygulamayi kapatir")
    public void kullanici_uygulamayi_kapatir() {
        Driver.quitAppiumDriver();
    }

    //===================2.Scenario==============================================================

    @Given("anasayfadaki arti {int} {int} {int} butonuna tiklayin")
    public void anasayfadaki_arti_butonuna_tiklayin(Integer xKoordinat, Integer yKoordinat, Integer bekleme) throws InterruptedException {
    ReusableMethods.tiklamaMethodu(xKoordinat,yKoordinat,bekleme);//arti butonunun locate'ini koordinat ile aldik
    }

    @Given("{string} butonuna text uzerinden tiklanir")
    public void butonuna_text_uzerinden_tiklanir(String text) throws IOException {
    ReusableMethods.scrollWithUiScrollable(text);//"Gelir Ekle" textine tikladik
    ReusableMethods.getScreenshot("ilk");//screen shot aldik
    }


    @Given("Gelir Ekle sayfasinda aciklama kismina {string} deger girilir")
    public void gelir_ekle_sayfasinda_aciklama_kismina_deger_girilir(String ilkKutu) {
    aileButcemPage.aciklamaKutusu.sendKeys(ilkKutu);
    }


    @Given("Gelir Ekle sayfasinda {string} gelir tipi {string} secilir")
    public void gelir_ekle_sayfasinda_gelir_tipi_secilir(String gelirTipiButonu, String gelirTipi) {
    ReusableMethods.scrollWithUiScrollable(gelirTipiButonu);//Gelir butonuna tikladik
    ReusableMethods.wait(1);
    ReusableMethods.scrollWithUiScrollable(gelirTipi);//Cikan seceneklerden Düzensiz olani sectik
    }


    @Given("Gelir Ekle sayfasinda {string} kategori {string} secilir")
    public void gelir_ekle_sayfasinda_kategori_secilir(String kategori, String kategoriTuru) {
    ReusableMethods.scrollWithUiScrollable(kategori);
    ReusableMethods.wait(1);
    ReusableMethods.scrollWithUiScrollable(kategoriTuru);
    ReusableMethods.wait(1);
    }


    @Given("Gelir Ekle sayfasinda tarih belirlemesi {int} {int} {int} {int} {int} {int} {int} {int} ve gun secimi {string} {int} {int} {int} yapilir")
    public void gelir_ekle_sayfasinda_tarih_belirlemesi_ve_gun_secimi_yapilir(int for1,int forSart,int xPress,
                                                                              int yPress,int waitAction,int xMoveTo,
                                                                              int yMoveTo,int bekleme, String gun,
                                                                              int tiklamax1,int tiklamay1,int bekleme2) throws InterruptedException {
    //aileButcemPage.tarihIkonu.click();//kucuk tarih ikonuna tikladik.1.YOL
    aileButcemPage.setTarihKutusu(tiklamax1,tiklamay1,bekleme2);//kucuk tarih ikonuna tikladik.2.YOL
    //Oncelikle istedigimiz ay icin kaydirma yapmaliyiz.bunu icinda kaydirma methodunu kullanmaliyiz
    aileButcemPage.tarihEkranKaydirmaMethodu(for1,forSart,xPress,yPress,waitAction,xMoveTo,yMoveTo,bekleme);//istenilen ay icin kaydirma yaptik
    ReusableMethods.scrollWithUiScrollable(gun);//burada istedigimiz bir gun sectik
    aileButcemPage.okButonu.click();//OK butonuna bastik
    }


    @Given("Gelir Ekle sayfasinda tutar {string} bilgisi girilir")
    public void gelir_ekle_sayfasinda_tutar_bilgisi_girilir(String tutar) {
    aileButcemPage.tutarKutusu.sendKeys(tutar);
    }


    @Given("basariyla eklendigini dogrulayin")
    public void basariyla_eklendigini_dogrulayin() throws IOException {
    Assert.assertTrue(aileButcemPage.gelirEklemeCheck.isDisplayed());
    ReusableMethods.getScreenshot("Son");
    }



}
