package com.etiya.northwind.businessTests;

import com.etiya.northwind.business.abstracts.MathService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathServiceTest {
    MathService mathService;

    @BeforeEach
    public void setup(){
        mathService = new MathService();
    }

    @Test
    public void five_plus_six_is_eleven(){
        //arrange//given
        int number1 = 5;
        int number2 = 6;
        int excepted = 11;

        //act//when

        int actual = mathService.add(number1,number2);

        //assert//then

        Assertions.assertEquals(excepted, actual);

    }

    @Test
    public void minus_ten_plus_six_is_eleven(){
        //arrange//given
        int number1 = -10;
        int number2 = 6;
        int excepted = -4;

        //act//when

        int actual = mathService.add(number1,number2);

        //assert//then

        Assertions.assertEquals(excepted, actual);

    }
}
