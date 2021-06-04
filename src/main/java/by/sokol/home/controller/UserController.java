package by.sokol.home.controller;

import by.sokol.home.entity.User;
import by.sokol.home.entity.dto.UserDTO;
import by.sokol.home.service.UserService;
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
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/auth")
    public ModelAndView getAuthPage(ModelAndView modelAndView) {
        modelAndView.setViewName("authorization");
        modelAndView.addObject("newUserDTO", new UserDTO());
        return modelAndView;

    }

    @GetMapping(path = "/reg")
    public ModelAndView getRegPage(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        modelAndView.addObject("newUser",new User());
        return modelAndView;

    }

    @PostMapping(path = "/auth")
    public ModelAndView doAuth(@Valid @ModelAttribute("newUserDTO") UserDTO userDTO, BindingResult bindingResult,
                               HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.setViewName("authorization");
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("authorization");
        } else {
            User byLogin = userService.checkByLogin(userDTO.getLogin());
            if (userService.passwordCheck(byLogin, userDTO.getPassword())) {
                httpSession.setAttribute("isUser", true);
                httpSession.setAttribute("isGuest",false);
                modelAndView.setViewName("redirect:/");
            } else {
                modelAndView.addObject("answer", "Wrong login or password!");
            }
        }
        return modelAndView;
    }

    @PostMapping(path = "/reg")
    public ModelAndView doReg(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult,
                              ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.addToStorage(user);
            modelAndView.setViewName("redirect:/user/auth");
        }
        return modelAndView;
    }

    @GetMapping(path = "/out")
    public ModelAndView doLogOut(HttpSession httpSession, ModelAndView modelAndView) {
        httpSession.invalidate();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
