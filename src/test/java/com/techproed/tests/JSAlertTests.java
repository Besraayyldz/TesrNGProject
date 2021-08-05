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

public class JSAlertTests {
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
    public void JSAlertTest() {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        //eger sayfada bir alert varsa ilk once o alerte gecis yapmamiz lazim
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);
//        getText ile gecis yaptigimiz sayfanin mesajini alabiliriz
//        driver.switchTo().alert().dismiss();//driver alerte gecis yapsin ve cancel butonuna tiklasin
//        driver.switchTo().alert().accept();//driver alerte gecis yapsin ve okey butonuna tiklasin
//        driver.switchTo().alert().sendKeys("assssssss");//driver alerte gecis yapsin ve alert'e yazi gondersin

    }
    @Test
    public void jsConfirmTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        button.click();

        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        driver.switchTo().alert().dismiss();//cancel e tiklar
        driver.switchTo().alert().accept();//ok'a basar

    }
    @Test
    public void jsPromptTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        button.click();
        String promptMessage = driver.switchTo().alert().getText();
        System.out.println(promptMessage);
        driver.switchTo().alert().sendKeys("Merhaba TestNG");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().alert().accept();
    }
}