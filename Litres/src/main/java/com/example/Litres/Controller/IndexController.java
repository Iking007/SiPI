/**
 * \defgroup Controllers Контроллеры приложения
 */
package com.example.Litres.Controller;

import com.example.Litres.Model.Book;
import com.example.Litres.Model.UserRole;
import com.example.Litres.Model.User;
import com.example.Litres.Repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Objects;


/**
 * \brief Главный контроллер роутинга
 * \details Класс контроллера, задающий основные маршруты поведения приложения и доставляющий в шаблонизатор данный из репозитория книг.
 * \authors Ivan, Pavel
 * \date 15 March 2023
 * \ingroup Controllers Главный контроллер
 */
@Controller
public class IndexController{
    @Autowired
    BooksRepository booksRepository;


    /**
     * \param[in] user Сущность пользователя
     * \param[in] model Объект изменяемой модели
     * \return[out] index Главная страница
     */
    @GetMapping("/")
    public String index(@AuthenticationPrincipal User user,Model model){
        model.addAttribute("namePage", "Главная");
        if(user == null){
            model.addAttribute("pr", null);
        }
        else if( Objects.equals(user.getRole(), Collections.singleton(UserRole.USER))){
            model.addAttribute("pr", 0);
        }
        else if(!Objects.equals(user.getRole(), Collections.singleton(UserRole.ADMIN))){
            model.addAttribute("pr", 1);
        }
        else {
            model.addAttribute("pr", 2);
        }
        return "index";
    }
    @GetMapping("/books")
    public String books(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("namePage", "Книги");
        if(user == null){
            model.addAttribute("pr", null);
        }
        else if( Objects.equals(user.getRole(), Collections.singleton(UserRole.USER))){
            model.addAttribute("pr", 0);
        }
        else if(!Objects.equals(user.getRole(), Collections.singleton(UserRole.ADMIN))){
            model.addAttribute("pr", 1);
        }
        else {
            model.addAttribute("pr", 2);
        }
        Iterable<Book> books = booksRepository.findAll();
        model.addAttribute("books", books);
        return "index";
    }
    @GetMapping("/books/query")
    public String books(@AuthenticationPrincipal User user,@RequestParam String filter, Model model){
        Iterable<Book> books = booksRepository.findByTitle(filter);

        if (books.toString().isEmpty()) {
            return "redirect:/books";
        }
        if(user == null){
            model.addAttribute("pr", null);
        }
        else if( Objects.equals(user.getRole(), Collections.singleton(UserRole.USER))){
            model.addAttribute("pr", 0);
        }
        else if(!Objects.equals(user.getRole(), Collections.singleton(UserRole.ADMIN))){
            model.addAttribute("pr", 1);
        }
        else {
            model.addAttribute("pr", 2);
        }
        model.addAttribute("namePage", "Книги");
        model.addAttribute("books", books);
        return "index";
    }

    @GetMapping("/books/{id}")
    public String bookId(@AuthenticationPrincipal User user, @PathVariable(value = "id") long id, Model model){
        Iterable<Book> book = booksRepository.findById(id);
        if (book == null){
            model.addAttribute("namePage", "404");
            return "index";
        }
        if(user == null){
            model.addAttribute("pr", null);
        }
        else if( Objects.equals(user.getRole(), Collections.singleton(UserRole.USER))){
            model.addAttribute("pr", 0);
        }
        else if(!Objects.equals(user.getRole(), Collections.singleton(UserRole.ADMIN))){
            model.addAttribute("pr", 1);
        }
        else {
            model.addAttribute("pr", 2);
        }
        model.addAttribute("namePage", "Книга");
        model.addAttribute("book", book);
        return "book";
    }
    @GetMapping("/prof")
    public String prof(@AuthenticationPrincipal User user, Model model){
        if(user == null){
            model.addAttribute("pr", null);
        }
        else if( Objects.equals(user.getRole(), Collections.singleton(UserRole.USER))){
            model.addAttribute("pr", 0);
        }
        else if(!Objects.equals(user.getRole(), Collections.singleton(UserRole.ADMIN))){
            model.addAttribute("pr", 1);
        }
        else {
            model.addAttribute("pr", 2);
        }
        model.addAttribute("username", user.getEmail());
        return "prof";
    }
    }
