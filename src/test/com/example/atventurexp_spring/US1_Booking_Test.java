package com.example.atventurexp_spring;

import com.example.atventurexp_spring.Model.Booking;
import com.example.atventurexp_spring.Repository.BookingRepo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;


@DataJpaTest
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class US1_Booking_Test {

    @Autowired
    BookingRepo bookingRepo;

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
        MockitoAnnotations.initMocks(this);
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
        Select select = null;
        /*
            driver.get("https://www.google.com");
            WebElement element = driver.findElement(By.name("q"));
            assertNotNull(element);

        driver.get("http://localhost:6060/");
        element = driver.findElement(By.id("indexpage"));
        assertNotNull(element);
*/

        driver.get("http://localhost:5050/");

        element = driver.findElement(By.id("ContentBox_Reserve"));
        assertNotNull(element);

        element = driver.findElement(By.id("ContentBox_Reserve"));
        assertNotNull(element);
        element.click();
        element = driver.findElement(By.id("BookEvent_selectNumber"));
        assertNotNull(element);

        Select selectActivity = new Select(driver.findElement(By.id("BookEvent_selectActivity")));
        assertNotNull(selectActivity);
        selectActivity.selectByIndex(1); // Udfyld aktivitetsfelt

        element = driver.findElement(By.id("BookEvent_time"));
        assertNotNull(element);
        element.sendKeys("2019-10-10 17:30");

        Select selectNumber = new Select(driver.findElement(By.id("BookEvent_selectNumber")));
        assertNotNull(selectNumber);
        selectNumber.selectByIndex(5); // Udfyld antal personer

        element = driver.findElement(By.id("BookEvent_submit"));
        assertNotNull(element);
        element.click();

        element = driver.findElement(By.id("ContentBox_Reserve"));
        assertNotNull(element);

        Booking booking = bookingRepo.get(1);
        assertThat(booking.getActivity()) .isEqualTo(1);
        assertThat(booking.getTime()) .isEqualTo("2019-10-10 17:30");
        assertThat(booking.getNumber()) .isEqualTo(5);


        /*
        x hent forside
        x check om det _er_ forsiden // id = ContentBox_Reserve
        x find 'book' knap // id = ContentBox_Reserve
        x tryk på 'book' knap
        x check om vi kommer til booking siden  // id = BookeEvent_selectNumber
        x udfyld aktivitetsfelt // id =  BookEvent_selectActivity
        x udfyld tidsfelt  // id = BookEvent_time
        x udfyld antal personer  // id = BookEvent_selectNumber
        x find book knap // id = BookEvent_submit   // form id = BookEvent_contact
        x tryk book knap
        x check at vi ikke kommer til en error-page

        tjek at booking er i database

         */


    }

}

