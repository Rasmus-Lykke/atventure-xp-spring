package com.example.atventurexp_spring;

import com.example.atventurexp_spring.Model.Booking;
import com.example.atventurexp_spring.Model.Equipment;
import com.example.atventurexp_spring.Repository.BookingJpaRepo;
import com.example.atventurexp_spring.Repository.EquipmentRepo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@AutoConfigureTestDatabase
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class US6_Equipment_Test{

    @Autowired
    BookingJpaRepo bookingRepo;

    @Autowired
    EquipmentRepo equipmentRepo;

    private WebDriver driver;

    // Ready the Chrome stuff so we can use it in tests
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    // Before each test start a Chrome browser in headless mode
    @Before
    public void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    // Close Chrome after each test
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
        Equipment testEquipmentOne = new Equipment();
        Equipment testEquipmentTwo = new Equipment();
        Equipment testEquipmentThree = new Equipment();
// 1
        testEquipmentOne.setActivityID(1L);
        testEquipmentOne.setEquipmentID(1L);
        testEquipmentOne.setEquipmentName("hjelm");
    //2
        testEquipmentTwo.setActivityID(1L);
        testEquipmentTwo.setEquipmentID(2L);
        testEquipmentTwo.setEquipmentName("Go Kart");

    //3
        testEquipmentThree.setActivityID(2l);
        testEquipmentThree.setEquipmentID(3L);
        testEquipmentThree.setEquipmentName("PaintBallGun");

        equipmentRepo.save(testEquipmentOne);
        equipmentRepo.save(testEquipmentTwo);
        equipmentRepo.save(testEquipmentThree);

        Booking testBookingOne = new Booking();
        Booking testBookingTwo = new Booking();

        testBookingOne.setActivityID(1L);
        testBookingOne.setBookingID(1L);
        testBookingOne.setParticipants(1);

        testBookingTwo.setActivityID(1L);
        testBookingTwo.setBookingID(2L);
        testBookingTwo.setParticipants(4);

        bookingRepo.save(testBookingOne);
        bookingRepo.save(testBookingTwo);

        driver.get("http://localhost:5050/ViewBooking/1");

        WebElement element;

        element = driver.findElement(By.id("ViewBooking_participants"));
        assertNotNull(element);

        assertEquals(element.getText(),"Der er tilmeldt 1 personer");
        assertNotEquals(element.getText(),"Negativ test");

        //

        List<WebElement> elementList = driver.findElements(By.className("ViewBooking_equipment"));
        assertNotNull(elementList);
        assertEquals(2,elementList.size());

        boolean foundHelmet = false;
        boolean foundGoKart = false;

        for (WebElement webElement : elementList) {
            if(webElement.getText().equals("hjelm") ){
                foundHelmet = true;
            }
            if(webElement.getText().equals("Go Kart") ){
                foundGoKart = true;
            }
        }

        assertTrue(foundHelmet);
        assertTrue(foundGoKart);

        driver.get("http://localhost:5050/ViewBooking/2");

        element = driver.findElement(By.id("ViewBooking_participants"));
        assertNotNull(element);

        assertEquals(element.getText(),"Der er tilmeldt 4 personer");
        assertNotEquals(element.getText(),"Negativ test");

        elementList = driver.findElements(By.className("ViewBooking_equipment"));
        assertNotNull(elementList);
        assertEquals(2,elementList.size());

        foundHelmet = false;
        foundGoKart = false;

        for (WebElement webElement : elementList) {
            if(webElement.getText().equals("hjelm") ){
                foundHelmet = true;
            }
            if(webElement.getText().equals("Go Kart") ){
                foundGoKart = true;
            }
        }

        assertTrue(foundHelmet);
        assertTrue(foundGoKart);
    }
}
