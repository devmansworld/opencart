import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartStepDefinitions {
    private CartTest cartTest;

    @Given("I am on the cart page")
    public void iAmOnTheCartPage() {
        cartTest = new CartTest();
        cartTest.setup();
        cartTest.openCartPage();
    }

    @When("I search for {string}")
    public void iSearchFor(String searchText) {
        cartTest.scrollPage();
        int occurrences = cartTest.searchAndCountOccurrences(searchText);
        Assert.assertEquals(3, occurrences);
    }

    @When("I add {string} to the cart")
    public void iAddToCart(String product) {
        cartTest.addToCart(product);
    }

    @When("I go to the cart")
    public void iGoToTheCart() {
        cartTest.openCart();
    }

    @Then("I should see {string} in the cart")
    public void iShouldSeeInTheCart(String product) {
        int occurrences = cartTest.searchAndCountOccurrences(product);
        Assert.assertTrue(occurrences > 0);
    }

    @Then("I should not see {string} in the cart")
    public void iShouldNotSeeInTheCart(String product) {
        int occurrences = cartTest.searchAndCountOccurrences(product);
        Assert.assertEquals(0, occurrences);
    }

    @Then("close the browser")
    public void closeTheBrowser() {
        cartTest.tearDown();
    }
}
