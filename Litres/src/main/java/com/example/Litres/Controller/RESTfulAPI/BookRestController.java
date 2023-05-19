package com.example.Litres.Controller.RESTfulAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.Litres.Model.Book;
import com.example.Litres.Repository.BooksRepository;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BookRestController {
    @Autowired
    BooksRepository repository;

    public void BookController(BooksRepository repository){
        this.repository = repository;
    }

    @GetMapping("/books")
    List<Book> all(){
        return repository.findAll();
    }
    
    // @GetMapping("/books")
    // public String Books(@RequestBody String param) {
    //     return repository.findAll();
    // }
    
}
