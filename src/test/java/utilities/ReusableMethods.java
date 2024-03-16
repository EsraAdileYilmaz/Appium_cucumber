package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ReusableMethods {

    static TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
    public static void tiklamaMethodu(int xKoordinati,int yKoordinati,int beklemeSuresi) throws InterruptedException {

        //cep telefonunda herhangi bir yere tiklamak istedigimizde bu methodu kullanacagiz
        action.press(PointOption.point(xKoordinati,yKoordinati))
                .release()
                .perform();
        Thread.sleep(beklemeSuresi);//sayfalar arasinda rahat tiklama yapabilmek icin her tiklama arasinda beklettik.

    }

    public static void screenScrollMethod(int pressXkoordinati,int pressYkoordinati,int wait,
                                          int moveXkoordinati,int moveYkoordinati,int bekleme) throws InterruptedException {
        //Ekrani bir ekran boyutu kadar kaydirma methodu

        action.press(PointOption.point(pressXkoordinati,pressYkoordinati))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait))) //kaydirma isleminin hizini belirler
                .moveTo(PointOption.point(moveXkoordinati,moveYkoordinati))
                .release()
                .perform();
        Thread.sleep(bekleme);

    }

    public static void ekranAssagiKaydirma(int waitAction){

        action.press(PointOption.point(500,1500))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(waitAction)))
                .moveTo(PointOption.point(500,285))
                .release()
                .perform();
    }

    public static void ekranYukariKaydirma(int waitAction){

        action.press(PointOption.point(500,285))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(waitAction)))
                .moveTo(PointOption.point(500,1500))
                .release()
                .perform();
    }

    public static void scrollWithUiScrollable(String elementText){
        AndroidDriver driver=(AndroidDriver)Driver.getAndroidDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ elementText +"\"))");
        //bu satirda elementin textini gorene kadar ara demis oluyoruz.Text'in unique olmasi tercih edilir ,eger unique deilse ilk bulduguna tiklar
        driver.findElementByXPath("//*[@text='"+elementText+"']").click();//bu satirda bulunan elemente tiklanir
        //bu methodla bir elementin text'i varsa bulup tiklama islemi yapilir.

    }//bu method mobil test icin gecerli sadece.

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot)Driver.getAndroidDriver();

        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }//Screen shot cekme methodu
    public static void wait(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String GetAppPackage (){

        return ConfigReader.getProperty("AppPackage");
    }

    public static String GetAppActivity (){

        return ConfigReader.getProperty("AppActivity");
    }




}
