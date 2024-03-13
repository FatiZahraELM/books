package fr.norsys.gestionlivresapi.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="books")
@Data
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;


    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(String title, int price, Author author) {
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public Book() {

    }
}


