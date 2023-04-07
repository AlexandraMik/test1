package com.alexmik.arttesting.tests;

import com.alexmik.arttesting.pages.CartPage;
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
public class TestFive {
    private Scenario scenario;
    @Before
    public void createScenario(Scenario scenarioVal) {
        this.scenario = scenarioVal;
        log.info("Scenario: " + scenario.getName());
    }
    MainPage mainPage = new MainPage(TestSettings.getDriver());
    ItemsPage itemsPage = new ItemsPage(TestSettings.getDriver());
    ItemPage itemPage = new ItemPage(TestSettings.getDriver());
    CartPage cartPage = new CartPage(TestSettings.getDriver());
    List<String> item;
    @When("user goes to jewelry")
    public void Step1(){
        TestSettings.getDriver().get("https://artnow.ru");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        mainPage.clickGetMore();
        mainPage.clickOnCategory("Ювелирное искусство");
    }
    @When("user adds first in basket")
    public void Step2(){
        itemsPage.clickOnItemByNumber(0);
        item = itemPage.addToBasket();
    }
    @When("user goes to basket")
    public void Step3(){
        itemPage.goBasket();
    }
    @Then("current item in basket and nothing changed")
    public void FinalStep(){ Assert.assertTrue(cartPage.checkBucketItems(item)); }
}
