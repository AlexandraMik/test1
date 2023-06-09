package com.alexmik.arttesting.tests;

import com.alexmik.arttesting.pages.ItemsPage;
import com.alexmik.arttesting.pages.MainPage;
import com.alexmik.arttesting.utils.TestSettings;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TestFour {
    MainPage mainPage = new MainPage(TestSettings.getDriver());
    ItemsPage itemsPage = new ItemsPage(TestSettings.getDriver());

    @When("user search giraffe")
    public void Step1(){
        TestSettings.getDriver().get("https://artnow.ru");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        mainPage.stringSearch("Жираф");
    }
    @Then("name of first item contains giraffe")
    public void FinalStep(){
        Assert.assertTrue(itemsPage.checkNNameInCatalog("Жираф", 0));
    }
}
