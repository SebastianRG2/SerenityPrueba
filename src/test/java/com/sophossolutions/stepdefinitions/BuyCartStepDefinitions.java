package com.sophossolutions.stepdefinitions;

import com.sophossolutions.exceptions.ExceptionError;
import com.sophossolutions.tasks.BuyProduct;
import com.sophossolutions.utilities.MsgError;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class BuyCartStepDefinitions {

    @Given("{word} select the {string}")
    public void selectThe(String actorName, String article) {
        theActorCalled(actorName).attemptsTo(BuyProduct.buy());
    }

    @When("Add to shopping cart the {string}")
    public void addToShoppingCartThe(String string) {
        System.out.println(string);
    }

    @Then("Check if the product was added to the cart {string}")
    public void checkIfTheProductWasAddedToTheCart(String string) {
        theActorInTheSpotlight().should(seeThat(BuyProduct.name(), equalTo(string))
                .orComplainWith(ExceptionError.class, MsgError.MSG_VALUE_ERROR.getMsg()));
    }

    @Given("Cantidate select the <article>")
    public void cantidateSelectTheArticle(String actorName, String article) {
        theActorCalled(actorName).attemptsTo(BuyProduct.buy());
    }
}
