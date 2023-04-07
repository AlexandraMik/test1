package com.alexmik.arttesting.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.alexmik.arttesting.utils.TestSettings.getDriver;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) { super(driver); }

    @Step("Проверить есть ли этот предмет в корзине")
    public Boolean checkBucketItems(List<String> item) {

        List<WebElement> artList = getDriver().findElements(By.cssSelector("#main_container > div.c_row"));

        elLoop:
        for (WebElement el : artList) {
            String name = el.findElement(By.cssSelector(".c_cell > :nth-child(1)")).getText();
            String price = el.findElement(By.cssSelector(".c_cell > .shop > .price")).getText();

            if (item.get(0).contains(name) || item.get(2).equals(price)) {
                return true;
            }
        }
        return false;
    }
}
