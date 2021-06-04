package by.sokol.home.controller;

import by.sokol.home.entity.CalcHistory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path = "/user/history")
public class HistoryController {

    @GetMapping
    public ModelAndView getCalcHistory(HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.setViewName("history");
        CalcHistory calcHistory = (CalcHistory) httpSession.getAttribute("calcHistory");
        List<String> historyList = calcHistory.getCalcHistory();
        modelAndView.addObject("userCalcHistory", historyList);
        return modelAndView;
    }
}
