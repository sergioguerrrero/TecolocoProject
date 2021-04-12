package org.example;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import io.grpc.internal.JsonUtil;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class TestImplementation {

    WebDriver driver = new ChromeDriver();

    @Step("NavigateUrl <https://www.irishjobs.ie/>")
    public void implementation1(Object arg0) {
        System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
        String URL ="https://www.irishjobs.ie/";
        driver.get(URL);
        driver.manage().window().maximize();

    }

    @Step("AcceptCooking")
    public void implementation2() {
        WebElement clickCookingButton = driver.findElement(By.xpath("//button[normalize-space()='I accept']"));
        clickCookingButton.click();
    }

    @Step("Search the job")
    public void implementation3() {
        WebElement searchBox = driver.findElement(By.name("Keywords"));
        searchBox.sendKeys("RECOMMENDED JOBS FOR YOU");
    }

    @Step("ClickIntheSearchButton")
    public void implementation4() {
        WebElement clickButton = driver.findElement(By.id("btnSubmit"));
        clickButton.click();
    }

    @Step("NumberOfElementInThePage")
    public void implementation5() {
        List<WebElement> CountTheElement = driver.findElements(By.linkText("HSE (HEALTH SERVICES EXECUTIVE)"));
        System.out.println("");
        System.out.println("***************************");
        System.out.println("Total of JOB with the same atribute are: " + CountTheElement.size());
        for (int i = 0; i < CountTheElement.size(); i++) {
            System.out.println(CountTheElement.get(i).getAttribute("HSE (HEALTH SERVICES EXECUTIVE)"));
        }
    }

    @Step("BackHomePage")
    public void implementation6() {
        driver.navigate().back();
        //WebElement searchBoxclean = driver.findElement(By.name("Keywords"));
        //searchBoxclean.clear();
    }

    @Step("CleanSearch")
    public void implementation7() {

        WebElement CleanJ = driver.findElement(By.xpath("//span[contains(text(),'×')]"));
        CleanJ.click();

    }

    @Step("SeekNewJob")
    public void implementation8() {
        WebElement searchBox2 = driver.findElement(By.name("Keywords"));
        searchBox2.sendKeys("QA Specialist");
    }

    @Step("ClickSearch")
    public void implementation9() {
        WebElement clickButton2 = driver.findElement(By.id("btnSubmit"));
        clickButton2.click();

    }


    @Step("CountTheQaJOb")
    public void implementation10() {
        List<WebElement> JobNumber = driver.findElements(By.cssSelector("body > div:nth-child(9) > div:nth-child(5) > div:nth-child(3) > div:nth-child(2) > div:nth-child(5) > div:nth-child(1)"));
        System.out.println("*****************************");
        System.out.println("Quantity of Job: " + JobNumber.size());

    }

    @Step("JobNullback")
    public void implementation11() {
        driver.navigate().back();
        WebElement CleanSearch = driver.findElement(By.xpath("//span[contains(text(),'×')]"));
        CleanSearch.click();


    }

    @Step("SearchNullJob")
    public void implementation12() {
        WebElement searchBox3 = driver.findElement(By.name("Keywords"));
        searchBox3.sendKeys("Relaxing");

    }

    @Step("ClicButtonJobNull")
    public void implementation13() {
        WebElement clickButton3 = driver.findElement(By.id("btnSubmit"));
        clickButton3.click();

    }

    @Step("ValidateResultNull")
    public void  implementation14() {

        String ActualResult  = driver.findElement(By.xpath("//div[contains(text(),'No jobs were found to match your criteria, you can')]")).getText();
        String ExpectResult = "No jobs were found to match your criteria, you can however save this search as an alert and we will notify you by email as soon as suitable jobs are posted";
        //System.out.println("Test: " +ActualResult);
        System.out.println("Expect Result is : " +ExpectResult);
        assertThat(ActualResult).isEqualTo(ExpectResult);


    }
}
