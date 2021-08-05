package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

public class SoftAssertTest {

    /*
    SoftAssert kullanimi ve HardAssert kullanimi arasindaki farklari
    1. HardAssert'de eger test basarisizsa devami calismaz. SoftAssert ise calistirir.
    2. HardAssert'de nesne uretme zorunlulugu yoktur.SoftAssert'de ise uretmek zorundasindir.
    3. SoftAssert'de birden fazla dogrulama yapilabilir.
    Assert denir -> HardAssert icin kullanilir.(Assert.assertTrue());
    Verify denir -> SoftAssert icin kullanilir.(SoftAssert icin)
     */
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void amazonTest(){
        driver.get("http://amazon.com ");
        SoftAssert softAssert = new SoftAssert();//bu bir nesnedir
        String baslik = driver.getTitle();
        softAssert.assertFalse(baslik.contains("Amazon"));
        softAssert.assertTrue(baslik.contains("Car"));
        softAssert.assertEquals("Online",baslik);

//        yukarida yazdigimiztum dogrulamal
//        assertAll yapmazsak testimiz hep true olur
//        bunun icin;
        softAssert.assertAll();
//        tum testlere bak bir tane bile yanlis varsa false yoksa true dondur diyoruz
    }
    
}
