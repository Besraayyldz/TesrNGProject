package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class IFrameTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown() {
//        driver.quit();
    }

    @Test
    public void IFrameIndexTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(0);//index ile gecis
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();//temizler
        paragraf.sendKeys("merhaba iframe");//yazar

    }

    @Test
    public void IFrameIdOrNameTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");//id veya name ile gecis
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();//temizler
        paragraf.sendKeys("merhaba iframe");//yazar

    }

    @Test
    public void IFrameWebElementTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);
        WebElement paragraf = driver.findElement(By.xpath("//p"));

        paragraf.clear();//temizler
        paragraf.sendKeys("merhaba iframe");//yazar

    }
    @Test
    public void IFrameTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(0);//index ile gecis
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();//temizler
        paragraf.sendKeys("merhaba iframe");//yazar

        driver.switchTo().defaultContent();//web sayfasinin ana govdesine geri doner (ilk acildigi gibi olu)
        driver.switchTo().parentFrame();//web sayfasinin parentine geri doner(ic ice farim varsa kullanilir bir adim geri gider)
        WebElement link = driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        link.click();
    }

}
