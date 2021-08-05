package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class PriorityTest {
//    oncelik testidir oncelik vermek istedigimizi sirasi nerde olursa olsun once calistirir
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

//    (priority = sayi) koymazsak alfabe sirasina gore testi gerceklestirir
//    prourity ile ise yazdigimiz sayi sirasina gore testini yapar
    @Test(priority = 2)
    public void amazonTest(){
        driver.get("http://amazon.com ");
    }

    @Test(priority = 3)
    public void googleTest(){
        driver.get("http://google.com ");
    }

    @Test(priority = 0)
    public void facebookTesti(){
        driver.get("http://facebook.com ");
    }
//ilk once facebook
//          amazon
//          google calisir
}
