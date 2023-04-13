package com.example.Litres.Model;
import lombok.Data;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String surname_author;
    private String name_author;
    private String middle_name_author;
    private Date date_of_birth;
    @Column(columnDefinition="text")
    private String description_author;

    
}