package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;

public class Day06_NewWindowTabs extends TestBase {
    @Test
    public void newTabTest() throws InterruptedException {
        // Open 2 new tabs and verify their TITLES
        //LinkedIn
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        String window1Handle= driver.getWindowHandle();//will be used to switch back to this window
        System.out.println("WINDOW 1" + window1Handle);

        Thread.sleep(5000);
        //Ebay
        driver.switchTo().newWindow(WindowType.TAB);//creating and switching to a new TAB
        driver.get("https://www.ebay.com");
        String ebayWindowHandle = driver.getWindowHandle();
        System.out.println("WINDOW 2 "+ebayWindowHandle);
        Assert.assertTrue(driver.getTitle().contains("eBay"));
        Thread.sleep(5000);

        // At this point driver is on Ebay Tab
     // To switch back to LinkedIn tab, we use traditional switchTo().window(linked-en window handle)
        driver.switchTo().window(window1Handle);//switching LinkedIn
        Thread.sleep(5000);
        System.out.println("Linkedin Title "+driver.getTitle());
        driver.switchTo().window(ebayWindowHandle);//switching ebay
        Thread.sleep(5000);
        System.out.println("Ebay Title "+driver.getTitle());
        driver.switchTo().window(window1Handle);//switching LinkedIn
        Thread.sleep(5000);
        System.out.println("Linkedin Title "+driver.getTitle());
        driver.switchTo().window(ebayWindowHandle);//switching ebay
        Thread.sleep(5000);
        System.out.println("Ebay Title "+driver.getTitle());
    }
    @Test
    public void newWindowTest() throws InterruptedException {
        //Open 2 new tabs and verify their TITLES
        //LinkedIn
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        String window1Handle = driver.getWindowHandle();//will be used to switch back to this window
        System.out.println("WINDOW 1 " + window1Handle);
        Thread.sleep(5000);
//        Ebay
        driver.switchTo().newWindow(WindowType.WINDOW);//creating and switching to a new WINDOW
        driver.get("https://www.ebay.com");
        String ebayWindowHandle = driver.getWindowHandle();
        System.out.println("WINDOW 2 "+ebayWindowHandle);
        Assert.assertTrue(driver.getTitle().contains("eBay"));
        Thread.sleep(5000);
//        At this point driver is on Ebay Tab
//        To switch back to LinkedIn tab, we use traditional switchTo().window(linked-en window handle)
        driver.switchTo().window(window1Handle);//switching LinkedIn
        Thread.sleep(5000);
        System.out.println("Linkedin Title "+driver.getTitle());
        driver.switchTo().window(ebayWindowHandle);//switching ebay
        Thread.sleep(5000);
        System.out.println("Ebay Title "+driver.getTitle());
        driver.switchTo().window(window1Handle);//swithing LinkedIn
        Thread.sleep(5000);
        System.out.println("Linkedin Title "+driver.getTitle());
        driver.switchTo().window(ebayWindowHandle);//switching ebay
        Thread.sleep(5000);
        System.out.println("Ebay Title "+driver.getTitle());
    }
}
