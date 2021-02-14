package ru.stqa.pft.dns.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TovarImeetOdnuChernuyuCenuTest extends TestBase{
    @BeforeMethod
    public void PredvoritelnyeDeystvia() {
        app.page().perehodV_DNS_Katalog();
        app.page().navedenieMyshiNaElementPervogoMenu("Смартфоны и гаджеты");
        app.page().clickPoElementyVtorogoMenu("Фототехника");
        app.page().clickPoIkonke("Видеокамеры");
    }

    @Test
    public void testTovarImeetOdnuCenu() {
        ArrayList<WebElement> oni = (ArrayList<WebElement>) app.driver.findElements(By.cssSelector(".n-catalog-product__main"));
        for (WebElement elements : oni) {
            Assert.assertEquals(elements.findElements(By.cssSelector(".product-min-price__current")).size(), 1);/*Тест проверяет, что у каждого товара есть только 1 цена, указанная черным цветом.*/
        }
    }
}
