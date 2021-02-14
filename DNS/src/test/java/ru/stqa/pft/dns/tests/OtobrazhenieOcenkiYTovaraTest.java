
package ru.stqa.pft.dns.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class OtobrazhenieOcenkiYTovaraTest extends TestBase {
    @BeforeMethod
    public void PredvoritelnyeDeysvia() throws InterruptedException {
        app.page().perehodV_DNS_Katalog();
        app.page().login("*******", "*******");//Сюда нужно вводить логин и пароль
        Thread.sleep(2000);
        app.page().navedenieMyshiNaElementPervogoMenu("Смартфоны и гаджеты");
        app.page().clickPoElementyVtorogoMenu("Фототехника");
        app.page().clickPoIkonke("Видеокамеры");
    }

    @Test(enabled = false)
    public void testOtobrazhenieOcenkiYTovara() throws InterruptedException {
        app.page().perehodKNapisaniuOtzyva();
        app.page().vystavlenieObsheyOcenki();
        app.page().zagruzkaFaila();
        app.page().otpravitOtzyv();
        assertTrue(app.driver.findElement(By.cssSelector(".ow-opinions__item")).getText().contains("Пришелец-BG51340"));

    }}