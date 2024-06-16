package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class GoogleSteps {

    private WebDriver driver;

    @Given("^url \"([^\"]*)\" is launched$")
    public void urlIsLaunched(String url) {
        // Note: The ChromeDriver path is now set via the system property in the Maven command
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Optional: Run in headless mode
        driver = new ChromeDriver(options);
        driver.get(url);
    }

    @When("^About page is shown$")
    public void aboutPageIsShown() {
        driver.findElement(By.linkText("About")).click();
    }

    @Then("^page displays \"([^\"]*)\"$")
    public void pageDisplays(String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean pageContainsText = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), expectedText));
        Assert.assertTrue("Page does not display the expected text: " + expectedText, pageContainsText);
    }

    @When("^searching for \"([^\"]*)\"$")
    public void searchingFor(String searchText) {
        driver.findElement(By.name("q")).sendKeys(searchText);
        driver.findElement(By.name("q")).submit();
    }

    @Then("^results contain \"([^\"]*)\"$")
    public void resultsContain(String expectedLinkText) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean resultsContainLink = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h3"), expectedLinkText));
        Assert.assertTrue("Search results do not contain the expected link: " + expectedLinkText, resultsContainLink);
    }

    @And("^result stats are displayed$")
    public void resultStatsAreDisplayed() {
        boolean statsDisplayed = driver.findElement(By.id("result-stats")).isDisplayed();
        Assert.assertTrue("Result stats are not displayed", statsDisplayed);
    }

    @And("^number of \"([^\"]*)\" is more than (\\d+)$")
    public void numberOfItemsIsMoreThan(String itemType, int minCount) {
        // Assuming itemType could be "results" or "seconds"
        if (itemType.equals("results")) {
            String resultStatsText = driver.findElement(By.id("result-stats")).getText();
            int resultsCount = Integer.parseInt(resultStatsText.split(" ")[1].replace(",", ""));
            Assert.assertTrue("Number of results is less than " + minCount, resultsCount > minCount);
        } else if (itemType.equals("seconds")) {
            // Implement logic to validate seconds if needed
            Assert.fail("Validation for seconds count is not implemented");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
