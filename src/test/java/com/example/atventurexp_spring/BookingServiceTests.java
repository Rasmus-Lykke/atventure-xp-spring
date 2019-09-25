package com.example.atventurexp_spring;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BookingServiceTests {

    @Mock
    BookingRepository bookingRepository;

    @InjectMocks
    BookingService bookingService;

    @Before
    public void init () {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void bookingServiceSavesBookingToRepository() {
        assert(false);


    }

}
