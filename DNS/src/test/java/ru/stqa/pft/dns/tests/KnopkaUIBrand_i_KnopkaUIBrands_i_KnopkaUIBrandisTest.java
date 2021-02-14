package ru.stqa.pft.dns.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class KnopkaUIBrand_i_KnopkaUIBrands_i_KnopkaUIBrandisTest extends TestBase {
    @BeforeMethod
    public void PredvoritelnyeDeysvia() {
        app.page().perehodV_DNS_Katalog();
        app.page().navedenieMyshiNaElementPervogoMenu("Смартфоны и гаджеты");
        app.page().clickPoElementyVtorogoMenu("Фототехника");
        app.page().clickPoIkonke("Видеокамеры");
    }

    @Test
    public void testKnopkaUIBrand_i_KnopkaUIBrands_i_KnopkaUIBrandis() {
        boolean a = app.isElementPresent(By.cssSelector(".button-ui_brand"));
        boolean b = app.isElementPresent(By.cssSelector(".button-ui_brands"));
        boolean c = app.isElementPresent(By.cssSelector(".button-ui_brandis"));
        SoftAssert s = new SoftAssert();
        s.assertEquals(a, true, "Элемент отсутствует");//ошибки не будет - такой элемент есть на странице
        s.assertEquals(b, true, "Элемент button-ui_brands отсутствует");//а здесь ошибка будет - такого элемента нет на странице(проверяется, что он будет найден на странице)
        s.assertEquals(c, false);//здесь ошибки нет(проверяется то, что элемента button-ui_brandis нет на странице), можно и без message - так тоже работает
        s.assertAll();
    }


}
