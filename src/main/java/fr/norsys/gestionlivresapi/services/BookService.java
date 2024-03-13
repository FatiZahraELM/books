package fr.norsys.gestionlivresapi.services;

import fr.norsys.gestionlivresapi.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

        List<Book> getAll();

        Book getBookById(int id);

        Book save(Book book);

        Book updateBook(int id,Book newBook);


        void deleteById(int id);



    }


