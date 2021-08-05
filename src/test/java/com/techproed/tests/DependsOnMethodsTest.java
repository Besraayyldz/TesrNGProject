package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class DependsOnMethodsTest {
//methodlari birbirine baglamak icin kullanilir
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

    //dependsOnMethod = "" her zaman ilk once tirnak icinde yazan testi calistir
    @Test(dependsOnMethods = "googleTest")
    public void amazonTest(){
        driver.get("http://amazon.com"); }

    @Test(dependsOnMethods = "facebookTest")
    public void googleTest(){

        driver.get("http://google.com");
    }

    @Test
    public void facebookTest(){

        driver.get("http://facebook.com");
    }

//    bu testlerden alfabeye gire caliscagina gore ilk once amazon testi calistirmak isteyecektir
//    amazon testine geldiginde ilk once google testi calistirmak isteyecek
//    google testi isi oncelik facebook testini calistirmak istedigi icin
//    ilk once facebook
//    sonra google
//    sonra amazona gidecektir




}
