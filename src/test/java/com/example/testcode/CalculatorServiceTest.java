package com.example.testcode;

import com.example.testcode.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("plusTest")
    public void plusTest(int num1, int num2,int result){
        Assertions.assertEquals(result,calculatorService.plus(num1,num2));
    }
    @ParameterizedTest
    @MethodSource("minusTest")
    public void minusTest(int num1, int num2,int result){
        Assertions.assertEquals(result,calculatorService.minus(num1,num2));
    }
    @ParameterizedTest
    @MethodSource("multiplyTest")
    public void multiplyTest(int num1, int num2,int result){
        Assertions.assertEquals(result,calculatorService.multiply(num1,num2));
    }
    @ParameterizedTest
    @MethodSource("divideTest")
    public void divideTest(int num1, int num2,int result){
        Assertions.assertEquals(result,calculatorService.divide(num1,num2));
    }

    @Test
    public void divideByZeroThrowsException(){
       assertThrows(IllegalArgumentException.class,()-> calculatorService.divide(1,0));
    }

    /**
     * Метод д б статик(требование JUnit)
     * @return - набор аргументов для теста
     */
    public static List<Arguments> plusTest(){
        return List.of(
                Arguments.of(10,7,17),
                Arguments.of(0,-7,-7),
                Arguments.of(0,0,0)
        );
    } public static List<Arguments> minusTest(){
        return List.of(
                Arguments.of(10,7,3),
                Arguments.of(0,-7,7),
                Arguments.of(0,0,0)
        );
    } public static List<Arguments> multiplyTest(){
        return List.of(
                Arguments.of(10,7,70),
                Arguments.of(0,-7,0),
                Arguments.of(0,0,0)
        );
    } public static List<Arguments> divideTest(){
        return List.of(
                Arguments.of(21,7,3),
                Arguments.of(-8,-8,1),
                Arguments.of(0,1,0)
        );
    }
}
