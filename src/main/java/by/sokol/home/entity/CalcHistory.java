package by.sokol.home.entity;


import java.util.ArrayList;
import java.util.List;

public class CalcHistory {
    private List<String> calcHistory = new ArrayList<>();

    public List<String> getCalcHistory() {
        return new ArrayList<>(calcHistory);
    }

    public void addToHistory(String operation) {
        calcHistory.add(operation);
    }
}
