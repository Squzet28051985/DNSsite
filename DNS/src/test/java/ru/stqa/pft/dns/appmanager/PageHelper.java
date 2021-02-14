package ru.stqa.pft.dns.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.pft.dns.tests.TestBase;

import java.io.IOException;
import java.time.Duration;

public class PageHelper extends TestBase {
    private WebDriver driver;

    public PageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String TelephoneOrEmail, String Password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        boolean a = app.isElementPresent(By.cssSelector(".header-profile__avatar"));
        if (a == false) {
            driver.findElement(By.cssSelector(".header__login_button")).click();
            WebElement dmx = driver.findElement((By.cssSelector(".form-entry-or-registry")));
            dmx.findElement(By.cssSelector(".block-other-login-methods__password-caption")).click();
            WebElement vsp = driver.findElement((By.cssSelector(".form-entry-with-password")));
            vsp.findElement(By.xpath("//input[contains(@id,'ir')][1]")).sendKeys(TelephoneOrEmail);
            vsp.findElement(By.xpath("//input[@type='password']")).sendKeys(Password);
            vsp.findElement(By.cssSelector(".base-ui-button_big-flexible-width")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }}


    public void clickPoIkonke(String Nazvanie) {
        driver.findElement(By.linkText(Nazvanie)).click();
    }

    public void perehodKNapisaniuOtzyva() {
        driver.findElement(By.cssSelector(".product-info__opinions-count")).click();
        driver.findElement(By.cssSelector(".ow-header__button")).click();
    }

    public void clickPoElementyVtorogoMenu(String ElementNazyvaetsya) {
        WebElement element3 = driver.findElement(By.linkText(ElementNazyvaetsya));
        new Actions(driver)
                .moveToElement(element3)
                .click()
                .perform();
    }

    public void navedenieMyshiNaElementPervogoMenu(String ElementNazyvaetsya) {
        WebElement element2 = driver.findElement(By.linkText(ElementNazyvaetsya));
        new Actions(driver)
                .moveToElement(element2)
                .perform();
    }

    public void vystavlenieObsheyOcenki(){
        driver.findElement(By.cssSelector(".star-rating__star:nth-child(5)")).click();
        driver.findElement(By.cssSelector(".add-opinion__user-ratings-list-item:nth-child(3) .star-rating__star:nth-child(4)")).click();
        driver.findElement(By.xpath("//p[text()='Качество звука']/following-sibling::div/descendant::span[3][@class='star-rating__star']")).click();
        driver.findElement(By.xpath("//section/button")).click();
    }

    public void perehodV_DNS_Katalog() {
        driver.get("https://www.dns-shop.ru");
    }

    public void clickPoSpiskuSAdresami() {
        driver.findElement(By.cssSelector(".ui-checkbox-dropdown__label")).click();
    }

    public void sortirovkaPoCenamUbyvanie() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        By cena = By.cssSelector(".product-min-price__current");
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(cena));
        driver.findElement(By.cssSelector(".top-filter__selected")).click();
        driver.findElement(By.xpath("//*[.='По убыванию цены']")).click();
        wait.until(ExpectedConditions.stalenessOf(element));
        wait.until(ExpectedConditions.presenceOfElementLocated(cena));
    }
    public void zagruzkaFaila(){
        ((JavascriptExecutor) app.driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element8 = app.driver.findElement(By.cssSelector(".dz-message"));
        new Actions(app.driver)
                .moveToElement(element8)
                .click()
                .perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Runtime.getRuntime().exec("D:\\FileUpload.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void otpravitOtzyv(){
        WebElement fileinput2 = app.driver.findElement(By.xpath("//div/button"));
        JavascriptExecutor javascriptExecutor =(JavascriptExecutor)app.driver;
        javascriptExecutor.executeScript("arguments[0].click();", fileinput2);
    }

}


