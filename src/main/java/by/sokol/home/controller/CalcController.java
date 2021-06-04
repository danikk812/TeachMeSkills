package by.sokol.home.controller;

import by.sokol.home.entity.CalcHistory;
import by.sokol.home.entity.Operation;
import by.sokol.home.entity.dto.OperationDTO;
import by.sokol.home.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/user/calc")
public class CalcController {

    @Autowired
    private CalcService calcService;

    @GetMapping
    public ModelAndView getCalcPage(ModelAndView modelAndView) {
        modelAndView.setViewName("calculator");
        modelAndView.addObject("newOperationDTO", new OperationDTO());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView doCalculate(@Valid @ModelAttribute("newOperationDTO") OperationDTO operationDTO,
                                    BindingResult bindingResult, HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.setViewName("calculator");
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("calculator");
        } else {
            Operation operation = new Operation();
            operation.setNum1(Double.parseDouble(operationDTO.getNum1()));
            operation.setNum2(Double.parseDouble(operationDTO.getNum2()));
            operation.setOperator(operationDTO.getOperator());
            CalcHistory calcHistory = (CalcHistory) httpSession.getAttribute("calcHistory");
            String result = calcService.doCalc(operation.getNum1(), operation.getNum2(),
                    operation.getOperator(),calcHistory);
            modelAndView.addObject("result", result);
        }
        return modelAndView;
    }
}
