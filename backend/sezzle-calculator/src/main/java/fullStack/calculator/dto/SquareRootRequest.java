package fullStack.calculator.dto;

import jakarta.validation.constraints.NotNull;
public class SquareRootRequest {

    @NotNull
    private Double number;

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }


}

