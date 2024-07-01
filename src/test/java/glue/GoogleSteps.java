package glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSteps {

    @Given("url {string} is launched")
    public void url_is_launched(String url) {
        // Implementation to launch the URL
        System.out.println("Launching URL: " + url);
    }

    @When("searching for {string}")
    public void searching_for(String searchString) {
        // Implementation to perform search
        System.out.println("Performing search for: " + searchString);
    }

    @Then("results contain {string}")
    public void results_contain(String expectedText) {
        // Implementation to verify results contain expected text
        System.out.println("Verifying results contain: " + expectedText);
    }

    @Then("result stats are displayed")
    public void result_stats_are_displayed() {
        // Implementation to verify result stats are displayed
        System.out.println("Verifying result stats are displayed");
    }

    @Then("number of {string} is more than {int}")
    public void number_of_is_more_than(String element, Integer count) {
        // Implementation to verify number of elements is more than expected count
        System.out.println("Verifying number of '" + element + "' is more than " + count);
    }
     @When("About page is shown")
    public void about_page_is_shown() {
        // Implementation for when the About page is shown
        System.out.println("About page is shown");
    }

    @Then("page displays {string}")
    public void page_displays(String pageTitle) {
        // Implementation to verify page displays expected title
        System.out.println("Verifying page displays: " + pageTitle);
    }
}
