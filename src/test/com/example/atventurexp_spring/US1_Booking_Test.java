package com.example.atventurexp_spring;

import com.example.atventurexp_spring.Model.Booking;
import com.example.atventurexp_spring.Repository.BookingJpaRepo;
import com.example.atventurexp_spring.Repository.BookingRepo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertNotNull;


@AutoConfigureTestDatabase
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class US1_Booking_Test {

    @Autowired
    BookingJpaRepo bookingRepo;

    private WebDriver driver;

    // Ready the FireFox stuff so we can use it in tests
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    // Before each test start a FireFox browser in headless mode
    @Before
    public void setupTest() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        driver = new FirefoxDriver(options);
        MockitoAnnotations.initMocks(this);
    }

    // Close FireFox after each test
    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /*
    Test that the homepage loads
    + that we can click on the link to the booking page
    + that when we book an activity there's no errors
    + that the booking is in the database
     */

    @Test
    @DirtiesContext
    public void test() {

        WebElement element;

        final int ACTIVITY_ID = 1;
        final int PARTICIPANTS = 5;
        final String DATE = "2019-10-10 17:30";

        // Get homepage
        driver.get("http://localhost:5050/");

        // Find element we know is on homepage and assert that is actually is found
        element = driver.findElement(By.id("ContentBox_Reserve"));
        assertNotNull(element);

        // Find the link to book activities
        element = driver.findElement(By.id("ClickToBook"));
        assertNotNull(element);

        // And click it
        element.click();

        // Find element that we know is on the page and assert that it is actually found
        element = driver.findElement(By.id("BookEvent_selectNumber"));
        assertNotNull(element);

        // Fill out activity input field in form
        Select selectActivity = new Select(driver.findElement(By.id("BookEvent_selectActivity")));
        assertNotNull(selectActivity);
        selectActivity.selectByIndex(ACTIVITY_ID - 1); // (index starts at zero, so subtract one)

        // Fill out time inut field in form
        element = driver.findElement(By.id("BookEvent_time"));
        assertNotNull(element);
        element.sendKeys(DATE);

        // Fill out participant number input field in form
        Select selectNumber = new Select(driver.findElement(By.id("BookEvent_selectNumber")));
        assertNotNull(selectNumber);
        selectNumber.selectByIndex(PARTICIPANTS - 1); // (index starts at zero, so subtract one)

        // Find submit button + assert that it is there
        element = driver.findElement(By.id("BookEvent_submit"));
        assertNotNull(element);

        // Click submit button
        element.click();

        // Assert that we are back on the home page
        element = driver.findElement(By.id("ContentBox_Reserve"));
        assertNotNull(element);

        // Now we need to test that the data we input on the web page is in the database

        // Get booking from database
        // It's a fake database so the id of the booking we just entered should always be 1
        Booking booking = bookingRepo.getOne(1L);

        // Assert that the id is indeed 1
        assertThat(booking.getBookingID()).isEqualTo(1);

        // Assert that the activity-id is 1
        assertThat(booking.getActivityID()).isEqualTo(ACTIVITY_ID);

        // Assert that the time is the one we entered
        assertThat(booking.getDate()).isEqualTo(DATE);

        // Assert that the number of participants is the one we entered
        assertThat(booking.getParticipants()).isEqualTo(PARTICIPANTS);
    }

}
