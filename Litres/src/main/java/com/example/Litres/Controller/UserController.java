package com.example.Litres.Controller;

import com.example.Litres.Model.UserRole;
import com.example.Litres.Model.User;
import com.example.Litres.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * \brief Контроллер, отвечающий за работу с пользовательскими аккаунтами.
 * \author Ivan
 * \date 15 March 2023
 * \ingroup Controllers Контроллер пользователя.
 */
@Controller
@RequestMapping("menu/users")
public class UserController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public String userList(Model model){
        List<User> users = usersRepository.findAll();
        model.addAttribute("pr", 2);
        model.addAttribute("users", users);
        return "allUsers";
    }
    @GetMapping("{id}/del")
    public String bookId(@PathVariable(value = "id") long id, Model model){
        usersRepository.deleteById(id);
        return "redirect:/menu/users";
    }
    @PostMapping("{id}/update/{role}")
    public String bookIdEdit(@PathVariable(value = "id") long id, @PathVariable(value = "role") int role,
                              Model model){
        model.addAttribute("pr", 2);
        User user = usersRepository.findById(id).orElseThrow();
        switch (role) {
            case 0 -> {user.getRole(); user.setRole(Collections.singleton(UserRole.USER));}
            case 1 -> {user.getRole(); user.setRole(Collections.singleton(UserRole.MODER));}
            case 2 -> {user.getRole(); user.setRole(Collections.singleton(UserRole.ADMIN));}
            default -> {
            }
        }
        usersRepository.save(user);
        return "redirect:/menu/users";
    }
}
