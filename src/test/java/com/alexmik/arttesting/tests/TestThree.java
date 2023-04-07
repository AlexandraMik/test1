package com.alexmik.arttesting.tests;

import com.alexmik.arttesting.pages.FavoritePage;
import com.alexmik.arttesting.pages.ItemPage;
import com.alexmik.arttesting.pages.ItemsPage;
import com.alexmik.arttesting.pages.MainPage;
import com.alexmik.arttesting.utils.TestSettings;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;

import java.util.List;

@Slf4j
public class TestThree {
    private Scenario scenario;
    @Before
    public void createScenario(Scenario scenarioVal) {
        this.scenario = scenarioVal;
        log.info("Scenario: " + scenario.getName());
    }
    MainPage mainPage = new MainPage(TestSettings.getDriver());
    ItemsPage itemsPage = new ItemsPage(TestSettings.getDriver());
    ItemPage itemPage = new ItemPage(TestSettings.getDriver());
    FavoritePage favoritePage = new FavoritePage(TestSettings.getDriver());
    List<String> item;
    @When("user goes to category batik")
    public void Step1(){
        TestSettings.getDriver().get("https://artnow.ru");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        mainPage.clickGetMore();
        mainPage.clickOnCategory("Батик");
    }

    @When("user adds first item in fav")
    public void Step2(){
        itemsPage.clickOnItemByNumber(0);
        item = itemPage.addToFavorite();
    }
    @When("user goes to fav")
    public void Step3(){
        itemPage.goFavorites();
    }
    @Then("current item in fav")
    public void FinalStep(){
        Assert.assertTrue(favoritePage.isInFavorites(item.get(0), item.get(1)));
    }
}
