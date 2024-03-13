package fr.norsys.gestionlivresapi.services;

import fr.norsys.gestionlivresapi.entities.Author;
import fr.norsys.gestionlivresapi.exceptions.ResourceNotFoundException;
import fr.norsys.gestionlivresapi.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(int id)  {
        Optional<Author> author=authorRepository.findById(id);
        if(author.isEmpty())
            return null;
        return  authorRepository.findById(id).get();
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    };

    @Override
    public Author updateAuthor(int id,Author newAuthor) {
        Author author = authorRepository.getById(id);
        author.setName(newAuthor.getName());
        author.setEmail( newAuthor.getEmail());

        return authorRepository.save(author);
    }


    @Override
    public void deleteById(int id) {

        authorRepository.deleteById(id);

    }
}
