package com.example.Litres.Model;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    private String title;
    private String img;
    private String download;
    @Column(columnDefinition = "TEXT")
    private String str;
    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author;
    @ManyToOne
    @JoinColumn(name = "id_genre")
    private Genre genre;

    public Book() {
    }

    public Book(String title, String str, Author writer, Genre genre) {
        this.title = title;
        this.str = str;
        // Дописать когда будет таблица писателей добавлена
        //this.id_author = (long) 0;
        //this.id_genre = (long) 0;
    }
    public Book(String title, String str) {
        this.title = title;
        this.str = str;
    }
}



