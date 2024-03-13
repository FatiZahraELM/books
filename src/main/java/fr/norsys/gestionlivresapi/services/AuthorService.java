package fr.norsys.gestionlivresapi.services;

import fr.norsys.gestionlivresapi.entities.Author;
import fr.norsys.gestionlivresapi.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AuthorService {


        List<Author> getAll();
        Author findById(int id) ;

        void save(Author author);

        Author updateAuthor(int id,Author newAuthor) ;


        void deleteById(int id);




}
