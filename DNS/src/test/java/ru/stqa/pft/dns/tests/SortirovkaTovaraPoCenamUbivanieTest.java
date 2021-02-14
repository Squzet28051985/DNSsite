package ru.stqa.pft.dns.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;

public class SortirovkaTovaraPoCenamUbivanieTest extends TestBase {
    @BeforeMethod
    public void PredvoritelnyeDeystvia() {
        app.page().perehodV_DNS_Katalog();
        app.page().navedenieMyshiNaElementPervogoMenu("Смартфоны и гаджеты");
        app.page().clickPoElementyVtorogoMenu("Планшеты, электронные книги");
        app.page().clickPoIkonke("Планшеты");
    }

    @Test
    public void testSortirovkaTovaraPoCenamUbivanie(){
        app.page().sortirovkaPoCenamUbyvanie();
        ArrayList<WebElement> onyx = (ArrayList<WebElement>) app.driver.findElements(By.cssSelector(".product-min-price__current"));
        int n;
        ArrayList<Integer> pumo1 = new ArrayList<>();
        for (n = 0; n < onyx.size(); n++) {
            pumo1.add(Integer.parseInt(onyx.get(n).getText().replaceAll("[^0-9]", "")));
        }
        ArrayList<Integer> pumo2 = new ArrayList<>();
        for (n = 0; n < onyx.size(); n++) {
            pumo2.add(Integer.parseInt(onyx.get(n).getText().replaceAll("[^0-9]", "")));
        }
        Collections.sort(pumo2, Collections.reverseOrder());
        Assert.assertEquals(pumo1, pumo2);//Тест проверяет, что цены на планшеты находятся в порядке убывания

    }
}
