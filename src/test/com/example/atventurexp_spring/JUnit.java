package com.example.atventurexp_spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

// Hvis der skal testes om flere layers arbejder sammen skal programmet startes ved hjælp af nedenstående to annotationer:
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class JUnit {

    @Test
    public void JUnitTest() {

        int expectedResult = 2 + 2;
        int actualResult = 4;

        assertEquals(expectedResult, actualResult);
        // eller
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
