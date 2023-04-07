package com.alexmik.arttesting.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ItemsPage extends BasePage{
    public ItemsPage(WebDriver driver) { super(driver); }
    public static String getMoreBtnGenreCss = "#genrebox > span.dot.control.float-l.showextra > span.openclose";

    @Step("Показать все жанры")
    public void clickGetMoreGenre(){
        WebElement getMoreBtnGenre = getDriver().findElement(By.cssSelector(getMoreBtnGenreCss));
        waitForElementEnable(getMoreBtnGenre);
        getMoreBtnGenre.click();
    }

    @Step("Выбрать необходимый фильтр жанра")
    public void clickPickCategory(String category){
        List<WebElement> categories = getDriver().findElements(By.cssSelector("#genrebox > div > label"));
        //для каждого элемента в категориях, если в их тексте содержится нужная
        for (WebElement el : categories)
            if (el.getText().contains(category)) {
                waitForElementEnable(el);
                el.click();
                break;
            }
        //Кнопка применения фильтров
        WebElement applyFilterBtn = getDriver().findElement(By.cssSelector("#applymsg"));
        waitForElementEnable(applyFilterBtn);
        applyFilterBtn.click();
    }
    @Step("Проверить, есть ли в каталоге такое имя и нажать на него, если нужно")
    public Boolean checkNameInCatalogClick(String name, Boolean click){
        timeSleep();
        List<WebElement> arts = getDriver().findElements(By.cssSelector("#sa_container > div.post"));
        for (WebElement el : arts){
            WebElement itemName = getDriver().findElement(By.cssSelector("#sa_container > div:nth-child(5) > a > div"));
            if (itemName.getText().contains(name)){
                if (click) {
                    waitForElementEnable(itemName);
                    itemName.click();
                    return true;
                }
                return true;
            }
        }
        return false;
    }
    @Step("Проверить, содержит ли N-й элемент такое имя")
    public Boolean checkNNameInCatalog(String name, int num){
        timeSleep();
        List<WebElement> arts = getDriver().findElements(By.cssSelector("#sa_container > div.post"));
        try {
            WebElement item = arts.get(num);
            if (item.getText().contains(name)){
                return true;
            }
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return false;
    }
    @Step("Нажать на элемент по номеру")
    public void clickOnItemByNumber(int number) {
        List<WebElement> arts = getDriver().findElements(By.cssSelector("#sa_container > .post"));
        WebElement art = arts.get(number);
        waitForElementEnable(art);
        art.click();
    }
}