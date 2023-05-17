package com.example.Litres.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Litres.Model.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAll();
    Author findById(long id);
}
