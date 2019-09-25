package com.example.atventurexp_spring;

import com.example.atventurexp_spring.Model.Home;
import com.example.atventurexp_spring.Repository.HomeRepo;
import com.example.atventurexp_spring.Service.HomeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Mockito {

    @Mock
    HomeRepo homeRepo;

    @InjectMocks
    HomeService homeService;

    @Before
    public void runThisBeforeEachTestMethod(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void someTestUsingMockito() {

        /*

        // Set up the mock repository to return mockHome when called as homeRepo.getOne(1L)
        Home mockHome = new Home();
        org.mockito.Mockito.when(homeRepo.getOne(1L)).thenReturn(mockHome);

        // Call the method we're testing
        Home home = homeService.getHome(1L);

        // Make sure we actually used the mock
        // And that we used it only once
        org.mockito.Mockito.verify(homeRepo).getOne(1L);

        // Check that we get the expected result from the method we're testing
        assertThat(home.getId()).isEqualTo(1L);


         */
        assert(false);

    }
}
