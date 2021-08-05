package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertTestCalisma {

    protected WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown(){
//        driver.quit();
    }
    @Test
    public void hepsiBurada(){
        driver.get("http://hepsiburada.com");
        SoftAssert softAssert = new SoftAssert();
        String title = driver.getTitle();
        System.out.println(title);
        softAssert.assertTrue(title.contains("Online"));

        WebElement search = driver.findElement(By.xpath("//input"));
        Assert.assertTrue(search.isDisplayed());
        Assert.assertFalse(search.isSelected());
        Assert.assertTrue(search.isEnabled());
        search.sendKeys("telefon"+ Keys.ENTER);


        WebElement dortSira = driver.findElement(By.xpath("(//button[@rel='nofollow'])[2]"));
        dortSira.click();



        WebElement secileTelefon = driver.findElement(By.partialLinkText("Samsung Galaxy A02S 64 GB (Samsung Türkiye Garantili)"));
        secileTelefon.click();

        WebElement renkSecimi =driver.findElement(By.xpath("//label[@data-value='Mavi']"));
        renkSecimi.click();

        softAssert.assertAll();


    }




}
