package com.alexmik.arttesting.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ItemPage extends BasePage {
    public ItemPage(WebDriver driver) {
        super(driver);
    }
    @Step("Проверка стиля")
    public Boolean isThisStyle(String styleName) {
        WebElement style = getDriver().
                findElement(By.cssSelector("#main_container > div:nth-child(3) > div.infocontainer > div:nth-child(9) > a"));
        return style.getText().equals(styleName);
    }
    @Step("Название предмета")
    public String getItemName(){
        return getDriver().findElement(
                By.cssSelector("#main_container > div:nth-child(3) > div.imgcontainer > h1")).getText();
    }
    @Step("Автор предмета")
    public String getItemAuthor(){
        return getDriver().findElement(
                By.cssSelector("#main_container > div:nth-child(3) > div.imgcontainer > div:nth-child(3) > a")).getText();
    }
    @Step("Цена предмета")
    public String getItemPrice(){
        return getDriver().findElement(
                By.cssSelector("#main_container > div:nth-child(3) > div.infocontainer > div.sale-span > div:nth-child(4) > b:nth-child(2)")
        ).getText();
    }
    @Step("Доавить в избранное")
    public List<String> addToFavorite(){
        WebElement addToFavoriteButton = getDriver()
                .findElement(By
                        .cssSelector("#main_container > div:nth-child(3) > div.infocontainer > div.sale-span > span"));
        waitForElementEnable(addToFavoriteButton);
        addToFavoriteButton.click();
        List<String> item = new ArrayList<>();
        item.add(getItemName());
        item.add(getItemAuthor());
        item.add(getItemPrice());
        return item;
    }
    @Step("Доавить в корзину")
    public List<String> addToBasket(){
        WebElement addToBasketButton = getDriver()
                .findElement(By
                        .xpath("//*[starts-with(@id,\"CartButton\")]"));
        waitForElementEnable(addToBasketButton);
        addToBasketButton.click();
        List<String> item = new ArrayList<>();
        item.add(getItemName());
        item.add(getItemAuthor());
        item.add(getItemPrice());
        return item;
    }
    @Step("Перейти в корзину")
    public void goBasket(){
        WebElement basketBtn = getDriver().findElement(By.xpath("//*[@id=\"cmodal\"]/div/p/button[1]"));
        waitForElementVisible(basketBtn);
        waitForElementEnable(basketBtn);
        basketBtn.click();
    }
    @Step("Перейти в избранное")
    public void goFavorites(){
        WebElement favBtn = getDriver().findElement(By.cssSelector("body > div.topheader > span.fvtico"));
        waitForElementVisible(favBtn);
        waitForElementEnable(favBtn);
        favBtn.click();
    }
    @Step("Вернуться назад")
    public void goBack(){
        getDriver().navigate().back();
    }
}

