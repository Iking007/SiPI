package com.example.Litres.Model;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Comment{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_book")
    private Book book;
    private Date date;
    @Column(columnDefinition="TEXT")
    private String text;
    @ManyToOne
    @JoinColumn(name = "id_author")
    private User author;
}