package com.example.atventurexp_spring;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class US1_Booking_Test {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setupTest() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        driver = new FirefoxDriver(options);
    }


    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    @DirtiesContext
    public void test() {
        WebElement element = null;
        /*
            driver.get("https://www.google.com");
            WebElement element = driver.findElement(By.name("q"));
            assertNotNull(element);
*/
        driver.get("http://localhost:6060/");
        element = driver.findElement(By.id("indexpage"));
        assertNotNull(element);

        /*
        hent forside
        check om det _er_ forsiden
        find 'book' knap
        tryk på 'book' knap
        check om vi kommer til booking siden
        udfyld aktivitetsfelt
        udfyld tidsfelt
        udfyld antal personer
        find book knap
        tryk book knap
        check at vi ikke kommer til en error-page

        tjek at booking er i database

         */


    }

}

