package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;


public class Day07_Cookies extends TestBase {
    @Test
    public void cookiesTest() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Set<Cookie> allCookies =driver.manage().getCookies();
        int allCookiesSize = allCookies.size();
        System.out.println( allCookiesSize);
        for (Cookie eachCookies : allCookies){
            System.out.println("eachCookies = " + eachCookies);
            System.out.println("eachCookies.getValue() = " + eachCookies.getValue());
            System.out.println("eachCookies.getName() = " + eachCookies.getName());
            System.out.println("eachCookies.getDomain() = " + eachCookies.getDomain());
            System.out.println("eachCookies.getExpiry() = " + eachCookies.getExpiry());
        }
        System.out.println("Cookie By Name=>" +driver.manage().getCookieNamed("i18n-prefs"));

        Cookie mFavCookie = new Cookie("my-cookie","chocolate-cookie");
        driver.manage().addCookie(mFavCookie);
        Thread.sleep(3000);
        for (Cookie eachCookie : driver.manage().getCookies()){
            System.out.println(eachCookie);
        }

        driver.manage().deleteAllCookies();
        Thread.sleep(3000);
        int finalNumberOfCookies = driver.manage().getCookies().size();
        System.out.println("finalNumberOfCookies = " + finalNumberOfCookies);
        for (Cookie eachCookie : driver.manage().getCookies()){
            System.out.println("Delete All Cookies");
            System.out.println(eachCookie);
        }

    }
}
