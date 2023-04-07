package com.alexmik.arttesting.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
public class MainPage extends BasePage {

    public static String getMoreBtnCss = "i[class ='fa fa-angle-down']";
    public static String searchInputCss ="#MainSearchForm > div > div:nth-child(1) > input.inp.scLarge";
    public static String searchBtnCss = "#MainSearchForm > div > div:nth-child(2) > button";

    public MainPage(WebDriver driver) { super(driver); }

    @Step("Показать все категории")
    public void clickGetMore(){
        WebElement getMoreBtn =  getDriver().findElement(By.cssSelector(getMoreBtnCss));
        waitForElementEnable(getMoreBtn);
        getMoreBtn.click();
    }
    @Step("Перейти в категорию")
    public void clickOnCategory(String category){
        List<WebElement> categories = getDriver().findElements(By.cssSelector(".left_bar > .main_menu > :nth-child(2) > li"));
        for (WebElement el : categories){
            if (el.getText().contains(category)){
                waitForElementEnable(el);
                el.click();
                break;
            }
        }
    }
    @Step("Ввести строку в поиск")
    public void stringSearch(String string){
        WebElement searchInput = getDriver().findElement(By.cssSelector(searchInputCss));
        WebElement searchBtn = getDriver().findElement(By.cssSelector(searchBtnCss));

        waitForElementEnable(searchInput);
        waitForElementEnable(searchBtn);

        searchInput.sendKeys(string);
        searchBtn.click();
    }
}
