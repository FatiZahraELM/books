package fr.norsys.gestionlivresapi.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="authors")
@Data

public class Author {
    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "name should not be empty")
    @Column(name = "name")
    @Size(min=5, message = "name should be at least of 5 characters")
    private String name;

    @Column(name = "email")
    @Email(message = "should be valid email format")
    private String email;

    @OneToMany(mappedBy = "author", cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Book> books;

    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Author() {
    }


}
