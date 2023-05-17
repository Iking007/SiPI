package com.example.Litres.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Litres.Model.BookAuthor;

import java.util.List;

public interface AuthorRepository extends JpaRepository<BookAuthor, Long> {

    List<BookAuthor> findAll();
    BookAuthor findById(long id);
}
