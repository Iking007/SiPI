package com.example.Litres.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Litres.Model.Genre;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    List<Genre> findAll();
    Genre findById(long id);
}
