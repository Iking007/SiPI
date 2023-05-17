package com.example.Litres.Controller;

import com.example.Litres.Model.UserRole;
import com.example.Litres.Model.User;
import com.example.Litres.Repository.UsersRepository;

import java.util.Calendar;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * \brief Контроллер регистрации
 * \details Класс, отвечающий за роутинг методов регистрации
 * \author Ivan
 * \date 16 March 2023
 * \ingroup Controllers Контроллер регистрации.
 */
@Controller
public class RegController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/reg")
    public String reg(@AuthenticationPrincipal User user, Model model){
        if (user != null){
            return "redirect:/prof";
        }
        model.addAttribute("pr", null);
        return "reg";
    }

    @PostMapping("/reg")
    public String bookAdd(@RequestParam String password, @RequestParam String username, @RequestParam String email, @RequestParam String surname, @RequestParam String name, @RequestParam String middle_name, @RequestParam Calendar birth_date,
                          @RequestParam String password2, Model model){
        User user = new User(password, username, email, surname, name, middle_name, birth_date);
        User userFromBD = usersRepository.findByEmail(user.getUsername());
        if(userFromBD != null) {
            model.addAttribute("error", "Ошибка, пользователь с такой почтой существует");
            return "reg";
        }
        else if (!password.equals(password2)){
            model.addAttribute("error", "Ошибка, пароли не совпадают");
            return "reg";
        }

        user.setRole(Collections.singleton(UserRole.USER));
        usersRepository.save(user);

        return "redirect:/login";
    }
}
