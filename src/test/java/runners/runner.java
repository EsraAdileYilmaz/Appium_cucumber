package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

   @RunWith(Cucumber.class)
   @CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber.json",},
        features = {"src/test/resources/features","src/test/resources/apiFeatures"},
        glue = "stepdefinitions",
        tags = "@obilet",
        dryRun =false
        /* Eger dryRun degerimiz true ise bu adim bize features'da bulunan tag ait olan kisimdaki eksik adimlari yani tanimlanmayan
       adimlari bize soyler. Eger adimlar tanimlanmissa tekrar calistirildiginda testimiz passed olur ama bu adimlarda eksik adim olmadigini
       gosterir yani aslinda testimizin passed oldugunu gostermez.

       Eger dryRun degerimiz false olursa tanimlanan eksik adimlardan sonra ilgili senaryolarin tanimlanmis TAG name'i olan
       senaryolarini harekete gecirip verilen emirleri test olarak kosturur.
        */

)
  public class runner {
     //Burasi projenin beynidir.yani runner class.
    //features = {"","",""}, => features'de birden fazla path eklemenin yolu


   }
