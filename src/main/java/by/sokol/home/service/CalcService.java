package by.sokol.home.service;

import by.sokol.home.entity.CalcHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalcService {

    public String doCalc(double num1, double num2, String sign, CalcHistory calcHistory){
        double result = 0.0;
        String operator = "";
        String historyStep = "";
        switch (sign){
            case "sum":
                result = sum(num1, num2);
                operator = " + ";
                break;
            case "div":
                operator = " / ";
                if (num2!=0){
                    result = div(num1, num2);
                    break;
                }else{
                    historyStep = num1+operator+num2+" =\"Division by zero!\"";
                    calcHistory.addToHistory(historyStep);
                    return "Division by zero!";
                }
            case "dif":
                result = dif(num1, num2);
                operator = " - ";
                break;
            case "mul":
                result = mul(num1, num2);
                operator = " * ";
                break;
            default:
                historyStep = "Wrong type of arithmetic operation!";
                calcHistory.addToHistory(historyStep);
                return historyStep;
        }
        historyStep = num1+operator+num2+" = "+result+";";
        calcHistory.addToHistory(historyStep);
        return String.valueOf(result);
    }


    private double sum(double num1, double num2 ){
        return num1+num2;
    }

    private double div(double num1, double num2 ){
        return num1/num2;
    }

    private double dif(double num1, double num2 ){
        return num1-num2;
    }

    private double mul(double num1, double num2 ){
        return num1*num2;
    }

}

