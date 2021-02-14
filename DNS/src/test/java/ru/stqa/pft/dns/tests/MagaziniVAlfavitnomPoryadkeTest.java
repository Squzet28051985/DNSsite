package ru.stqa.pft.dns.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.Collator;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MagaziniVAlfavitnomPoryadkeTest extends TestBase {

    @BeforeMethod
    public void PredvoritelnyeDeystvia(){
        app.page().perehodV_DNS_Katalog();
        app.page().navedenieMyshiNaElementPervogoMenu("Смартфоны и гаджеты");
        app.page().clickPoElementyVtorogoMenu("Фототехника");
        app.page().clickPoIkonke("Видеокамеры");
    }

    @Test
    public void testMagaziniVAlfavitnomPoryadke() {
        app.page().clickPoSpiskuSAdresami();
        app.jo = app.driver.findElement(By.cssSelector(".ui-checkbox-group"));
        ArrayList<WebElement> element = (ArrayList<WebElement>) app.jo.findElements(By.cssSelector(".ui-checkbox"));
        String nemo = "ААААААААААААААААААААААААААААААААААААА";
        for (WebElement elements : element) {
            nemo += "><><><" + elements.getText();
        }
        ArrayList<String> jin = new ArrayList(Arrays.asList(nemo.split("><><><", 150)));
        jin.remove("ААААААААААААААААААААААААААААААААААААА");
        Collections.sort(jin, Collator.getInstance());
        ArrayList<String> jin2 = new ArrayList(Arrays.asList(nemo.split("><><><", 150)));
        jin2.remove("ААААААААААААААААААААААААААААААААААААА");
        Assert.assertEquals(jin2, jin);//Тест проверяет, что во всплывающем меню адреса расположены в алфавитном порядке
    }
}
