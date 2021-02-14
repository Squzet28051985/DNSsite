package ru.stqa.pft.dns.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NahozhdenieSlovaVSpiskeMagazinovTest extends TestBase{
    @BeforeMethod
    public void PredvoritelnyeDeystvia() {
        app.page().perehodV_DNS_Katalog();
        app.page().navedenieMyshiNaElementPervogoMenu("Смартфоны и гаджеты");
        app.page().clickPoElementyVtorogoMenu("Фототехника");
        app.page().clickPoIkonke("Видеокамеры");
    }

    @Test
    public void testNahozhdenieSlovaVSpiskeMagazinov() {
        app.page().clickPoSpiskuSAdresami();
        WebElement jo = app.driver.findElement(By.cssSelector(".ui-checkbox-group"));
        assertTrue(jo.findElement(By.cssSelector("label:nth-child(50)")).getText().contains("Деревня"));/*Тест проверит есть ли слово "Деревня" у магазина, находящемся на 50-й позиции.*/
    }
}
