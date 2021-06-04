package by.sokol.home.controller;

import by.sokol.home.entity.exception.UserAlreadyExistsException;
import by.sokol.home.entity.exception.UserNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFound(UserNotFoundException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "errorPage";
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public String userAlreadyExists(UserAlreadyExistsException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "errorPage";
    }
}
