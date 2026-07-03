package fullStack.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {

        if (b == 0) {
            throw new IllegalArgumentException(
                    "Division by zero is not allowed");
        }

        return a / b;
    }

    public double power(double a, double b) {
        return Math.pow(a, b);
    }

    public double squareRoot(double number) {

        if(number < 0){
            throw new IllegalArgumentException(
                    "Cannot calculate square root of negative number");
        }

        return Math.sqrt(number);
    }

    public double percentage(double total,
                             double percent) {

        return (total * percent) / 100;
    }
}
