import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebstaurantStepDefinitions {

    private WebDriver driver;

    @Given("User is on the Webstaurantstore website")
    public void userIsOnWebstaurantWebsite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.webstaurantstore.com/");
    }

    @When("User searches for {string}")
    public void userSearchesFor(String "stainless work table") {
        WebElement searchBox = driver.findElement(By.name("searchval"));
        searchBox.sendKeys(searchTerm);
        searchBox.submit();
    }

    @Then("Search results should contain products with the word 'Table' in the title")
    public void searchResultsContainTableInTitle() {
        List<WebElement> productTitles = driver.findElements(By.cssSelector(".description"));
        for (WebElement title : productTitles) {
            assert title.getText().toLowerCase().contains("table") : "Product title doesn't contain 'Table'";
        }
    }

    @Then("User adds the last found item to the Cart")
    public void userAddsLastItemToCart() {
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector(".add-to-cart"));
        if (!addToCartButtons.isEmpty()) {
            addToCartButtons.get(addToCartButtons.size() - 1).click();
        }
    }

    @Then("User empties the Cart")
    public void userEmptiesCart() {
        WebElement cartButton = driver.findElement(By.cssSelector(".cart-info"));
        cartButton.click();
        WebElement emptyCartButton = driver.findElement(By.cssSelector(".empty-cart"));
        emptyCartButton.click();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
