package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class AileButcemPage {

    public AileButcemPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver(), Duration.ofSeconds(15)), this);
        //Page Factory.initElements((WebDriver)Driver.getAndroidDriver(),this)
    }//burasi yine selenium WebDriver'lerini kullaniyor ama farkli bir kutuphane (AppiumFieldDecorator)'den faydalaniyor.

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    public MobileElement emailBox;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    public MobileElement passwordBox;

    @FindBy(xpath = "//*[@text='Başarıyla giriş yapıldı.']")
    public MobileElement girisYapildiText;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    public MobileElement isimKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    public MobileElement soyisimKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[3]")
    public MobileElement sehirKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[4]")
    public MobileElement yasKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[5]")
    public MobileElement meslekKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    public MobileElement aciklamaKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    public MobileElement tutarKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.ImageView'])[5]")
    public MobileElement tarihIkonu;

    @FindBy(id = "android:id/button1")
    public MobileElement okButonu;

    @FindBy(xpath = "//*[@text='Gelir eklendi.']")
    public MobileElement gelirEklemeCheck;



    public void setTarihKutusu(int x1,int y1,int beklemeSuresi) throws InterruptedException {
        ReusableMethods.tiklamaMethodu(x1,y1,beklemeSuresi);

    }

    public void tarihEkranKaydirmaMethodu(int for1,int forSart,int xPress,
                                          int yPress,int waitAction,int xMoveTo,
                                          int yMoveTo,int bekleme) throws InterruptedException {
        for (int i = for1; i < forSart; i++) {
            ReusableMethods.screenScrollMethod(xPress,yPress,waitAction,xMoveTo,yMoveTo,bekleme);

        }//Bu methodla istedigimiz ayi secmek icin kaydirma yapiyoruz
    }

    public void bilgiSilme(){
        isimKutusu.clear();
        soyisimKutusu.clear();
        sehirKutusu.clear();
        yasKutusu.clear();
        meslekKutusu.clear();

    }


    public void textBoxVeriGirme(String isim,String soyisim,String sehir,String yas,String meslek){

        bilgiSilme();//burda once bilgileri silicez.Methodun icine methodu koyduk

        isimKutusu.sendKeys(isim);
        soyisimKutusu.sendKeys(soyisim);
        sehirKutusu.sendKeys(sehir);
        yasKutusu.sendKeys(yas);//sendKeys() methodu ile sadece String degerler gonderilir
        meslekKutusu.sendKeys(meslek);
        ReusableMethods.scrollWithUiScrollable("Kaydet");//girilen veriler kaydedilir

    }


    public void textBoxKontrol(String isim,String soyisim,String sehir,String yas,String meslek){
        Assert.assertTrue(isimKutusu.getText().contains(isim));//yani isim kutusundaki text isim'i iceriyormu? isim de feature'da girilen isim'den geliyor
        Assert.assertTrue(soyisimKutusu.getText().contains(soyisim));//yani soyisim kutusundaki text soyisim'i iceriyormu? soyisim de feature'da girilen soyisim'den geliyor
        Assert.assertTrue(sehirKutusu.getText().contains(sehir));//yani sehir kutusundaki text sehir'i iceriyormu? sehir de feature'da girilen sehir'den geliyor
        Assert.assertTrue(yasKutusu.getText().contains(yas));//yani yas kutusundaki text yas'i iceriyormu? yas da feature'da girilen yas'dan geliyor
        Assert.assertTrue(meslekKutusu.getText().contains(meslek));//yani meslek kutusundaki text meslek'i iceriyormu? meslek de feature'da girilen meslek'den geliyor
        //Girdigimiz degerlerin girilip-girilmedigini kontrol ediyoruz
    }


    public void ucCizgiTiklamaMethodu() throws InterruptedException {
        ReusableMethods.wait(4);
        ReusableMethods.tiklamaMethodu(112,135,500);
    }




    public void ilkEkranAyarlamalari(int for1,int forSart,int xPress,
                                     int yPress,int waitAction,int xMoveTo,
                                     int yMoveTo,int bekleme,String girisText) throws InterruptedException {

        ReusableMethods.wait(4);

        for (int i=for1; i<forSart; i++){
            ReusableMethods.screenScrollMethod(xPress,yPress,waitAction,xMoveTo,yMoveTo,bekleme);

        }
        ReusableMethods.scrollWithUiScrollable(girisText);

    }//bu method sayisal hicbir deger icermedigi icin tamamen dinamiktir



    public void ilkEkranAyarlama() throws InterruptedException {
        for (int i=0; i<6; i++){
            ReusableMethods.screenScrollMethod(946,1019,500,125,1019,500);

        }
        ReusableMethods.scrollWithUiScrollable("Giriş Yap");
    }//bu method tam dinamik deil cunku burada degerler parametre seklinde deil.


}
