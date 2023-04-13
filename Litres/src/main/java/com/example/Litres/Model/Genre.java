package com.example.Litres.Model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "book_ganre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kind_of_literature;
    private String name_genre;
}
