package fullStack.calculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    void shouldAddPositiveNumbers() {
        assertEquals(5, calculatorService.add(2, 3));
    }

    @Test
    void shouldAddNegativeNumbers() {
        assertEquals(-5, calculatorService.add(-2, -3));
    }

    @Test
    void shouldAddPositiveAndNegativeNumbers() {
        assertEquals(1, calculatorService.add(3, -2));
    }

    @Test
    void shouldSubtractNumbers() {
        assertEquals(3, calculatorService.subtract(5, 2));
    }

    @Test
    void shouldSubtractNegativeNumbers() {
        assertEquals(-3, calculatorService.subtract(-5, -2));
    }

    @Test
    void shouldMultiplyNumbers() {
        assertEquals(12, calculatorService.multiply(3, 4));
    }

    @Test
    void shouldMultiplyByZero() {
        assertEquals(0, calculatorService.multiply(100, 0));
    }

    @Test
    void shouldMultiplyNegativeNumbers() {
        assertEquals(12, calculatorService.multiply(-3, -4));
    }

    @Test
    void shouldDivideNumbers() {
        assertEquals(5, calculatorService.divide(10, 2));
    }

    @Test
    void shouldDivideDecimalNumbers() {
        assertEquals(2.5, calculatorService.divide(5, 2));
    }

    @Test
    void shouldThrowExceptionForDivisionByZero() {

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> calculatorService.divide(10, 0)
                );

        assertEquals(
                "Division by zero is not allowed",
                exception.getMessage()
        );
    }

    @Test
    void shouldCalculatePower() {
        assertEquals(8, calculatorService.power(2, 3));
    }

    @Test
    void shouldCalculatePowerOfZero() {
        assertEquals(1, calculatorService.power(5, 0));
    }

    @Test
    void shouldCalculateSquareRoot() {
        assertEquals(5, calculatorService.squareRoot(25));
    }

    @Test
    void shouldCalculateSquareRootOfZero() {
        assertEquals(0, calculatorService.squareRoot(0));
    }

    @Test
    void shouldThrowExceptionForNegativeSquareRoot() {

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> calculatorService.squareRoot(-25)
                );

        assertEquals(
                "Cannot calculate square root of negative number",
                exception.getMessage()
        );
    }

    @Test
    void shouldCalculatePercentage() {
        assertEquals(
                20,
                calculatorService.percentage(100, 20)
        );
    }

    @Test
    void shouldCalculateZeroPercentage() {
        assertEquals(
                0,
                calculatorService.percentage(100, 0)
        );
    }

    @Test
    void shouldCalculatePercentageForDecimalValues() {
        assertEquals(
                10.5,
                calculatorService.percentage(42, 25)
        );
    }
}


