package by.sokol.home.entity.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class OperationDTO {
    @NotEmpty(message = "Can not be empty!")
    @Pattern(regexp = "^(-?\\d+\\.\\d+)|(-?\\d+)$", message = "Wrong digit format!\n" +
            "Use dot to separate!")
    private String num1;

    @NotEmpty(message = "Can not be empty!")
    @Pattern(regexp = "^(-?\\d+\\.\\d+)|(-?\\d+)$", message = "Wrong digit format!\n" +
            "Use dot to separate!")
    private String num2;

    @NotEmpty(message = "Can not be empty!")
    @Pattern(regexp = "^([a-z]{3})$",  message = "Only 3 characters put here!")
    private String operator;
    private String result;

    public OperationDTO() {
    }

    public OperationDTO(String num1, String num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public OperationDTO(String num1, String num2, String operator, String result) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
        this.result = result;
    }




    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

