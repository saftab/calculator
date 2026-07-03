package fullStack.calculator.controller;


import fullStack.calculator.dto.CalculationRequest;
import fullStack.calculator.dto.CalculationResponse;
import fullStack.calculator.dto.SquareRootRequest;
import fullStack.calculator.service.CalculatorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(
            CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/add")
    public ResponseEntity<CalculationResponse> add(
            @Valid @RequestBody CalculationRequest request) {

        double result = calculatorService.add(
                request.getNum1(),
                request.getNum2());

        return ResponseEntity.ok(
                new CalculationResponse(result));
    }

    @PostMapping("/subtract")
    public ResponseEntity<CalculationResponse> subtract(
            @Valid @RequestBody CalculationRequest request) {

        double result = calculatorService.subtract(
                request.getNum1(),
                request.getNum2());

        return ResponseEntity.ok(
                new CalculationResponse(result));
    }

    @PostMapping("/multiply")
    public ResponseEntity<CalculationResponse> multiply(
            @Valid @RequestBody CalculationRequest request) {

        double result = calculatorService.multiply(
                request.getNum1(),
                request.getNum2());

        return ResponseEntity.ok(
                new CalculationResponse(result));
    }

    @PostMapping("/divide")
    public ResponseEntity<CalculationResponse> divide(
            @Valid @RequestBody CalculationRequest request) {

        double result = calculatorService.divide(
                request.getNum1(),
                request.getNum2());

        return ResponseEntity.ok(
                new CalculationResponse(result));
    }

    @PostMapping("/power")
    public ResponseEntity<CalculationResponse> power(
            @RequestBody CalculationRequest request) {

        double result = calculatorService.power(
                request.getNum1(),
                request.getNum2());

        return ResponseEntity.ok(
                new CalculationResponse(result));
    }

    @PostMapping("/sqrt")
    public ResponseEntity<CalculationResponse> squareRoot(
            @Valid @RequestBody SquareRootRequest request) {

        double result = calculatorService.squareRoot(
                request.getNumber());

        return ResponseEntity.ok(
                new CalculationResponse(result));
    }

    @PostMapping("/percentage")
    public ResponseEntity<CalculationResponse> percentage(
            @RequestBody CalculationRequest request) {

        double result = calculatorService.percentage(
                request.getNum1(),
                request.getNum2());

        return ResponseEntity.ok(
                new CalculationResponse(result));
    }


}
