package com.techproed.tests;

import com.techproed.utulities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.util.Set;

public class WindowHandleTests extends TestBase {

    @Test
    public void CokluPencereTest() {
        driver.get("https://the-internet.herokuapp.com/windows");
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println(sayfa1Handle);
        driver.findElement(By.partialLinkText("Click Here")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> tumPencereler = driver.getWindowHandles(); //Set return eder
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (String handle : tumPencereler  ){
            System.out.println(handle);
        }
        Object[] array = tumPencereler.toArray();
        String sayfa2Handle = array[array.length-1].toString();//son elemanin handle'ini alir
        System.out.println(sayfa2Handle);
        driver.switchTo().window(sayfa1Handle);
        System.out.println(sayfa1Handle);
    }

}
