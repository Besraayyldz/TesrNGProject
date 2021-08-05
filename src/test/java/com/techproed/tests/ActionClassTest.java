package com.techproed.tests;

import com.techproed.utulities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClassTest extends TestBase {

    //mouse isaretcileri
    @Test
    public void sagTiklama() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
//        sag tiklama
//        Actions class ile islem yaparsaniz HER SEFERINDE ".perform()" yapmak zorundasiniz
        actions.contextClick(element).perform();//web elemente sag tiklar
    }

//        cift tiklama
    @Test
    public void ciftTiklama(){
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        WebElement element = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();

    }

//    mousu istedigimiz webelementin uzerine gorurmek istedigimizde
    @Test
    public void hoverOver(){
        driver.get("http://amazon.com");
        WebElement element = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        //    mousu istedigimiz webelementin uzerine gorurmek istedigimizde
        actions.moveToElement(element).perform();
    }

    //klawye isaretcileri
    @Test
    public void ssagiYukari(){
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();//BIR KERE DOWN TUSUNA BASAR
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.END).perform();//SAYFANIN SONUNA GIDER
        actions.sendKeys(Keys.PAGE_UP).perform();//BIR KERE UP TUSUNA BASAR
    }


}
