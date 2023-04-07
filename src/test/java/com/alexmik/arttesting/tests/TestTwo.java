package com.alexmik.arttesting.tests;




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

@Slf4j
public class TestTwo {
    private Scenario scenario;
    @Before
    public void createScenario(Scenario scenarioVal) {
        this.scenario = scenarioVal;
        log.info("Scenario: " + scenario.getName());
    }
    MainPage mainPage = new MainPage(TestSettings.getDriver());
    ItemsPage itemsPage = new ItemsPage(TestSettings.getDriver());
    ItemPage itemPage = new ItemPage(TestSettings.getDriver());
//2.2
//   Перейти в "Вышитые картины", произвести поиск по жанру
//  "Городской пейзаж", открыть подробности картины "Трамвайный путь",
//  проверить, что стиль картины "Реализм".

    @When("user again goes to category1 category")
    public void Step1(){
        TestSettings.getDriver().get("https://artnow.ru");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        mainPage.clickGetMore();
        mainPage.clickOnCategory("Вышитые картины");
    }
    @When("user again picks genre genre1")
    public void Step2(){
        itemsPage.clickGetMoreGenre();
        itemsPage.clickPickCategory("Городской пейзаж");
    }
    @When("user clicks on picture")
    public void Step3(){
        itemsPage.checkNameInCatalogClick("Трамвайный путь", true);
    }
    @Then("current item style is correct")
    public void FinalStep(){ Assert.assertTrue(itemPage.isThisStyle("Реализм"));}
}
