package gradle.cucumber;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class WikipediaSteps {

    WebDriver driver;

    @After
    public void closeBrowser()
    {
        driver.quit();
    }

    @Given("I open {string}")
    public void i_open_browser(String string)
    {
        if (string.equals("firefox"))
            driver = new FirefoxDriver();
        if (string.equals("chrome"))
            driver = new ChromeDriver();
        if (string.equals("opera"))
            driver = new OperaDriver();
        if (string.equals("safari"))
            driver = new SafariDriver();
        if (string.equals("edge"))
            driver = new EdgeDriver();
        //else driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @And("I open the page {string}")
    public void i_open_url(String string)
    {
        driver.get(string);
    }

    @Then("I search {string}")
    public void i_search_keyword(String string)
    {
        WebElement recherche = driver.findElement(By.id("searchInput"));
        recherche.sendKeys(string + Keys.ENTER);
    }

    @Then("I should witness the magnificent {string}")
    public void i_should_see_in_the_title(String string) {
        WebElement title = driver.findElement(By.id("firstHeading"));
        Assert.assertEquals(title.getText(), string);
    }



}
