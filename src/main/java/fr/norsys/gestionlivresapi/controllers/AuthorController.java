package fr.norsys.gestionlivresapi.controllers;

import fr.norsys.gestionlivresapi.entities.Author;
import fr.norsys.gestionlivresapi.exceptions.ResourceNotFoundException;
import fr.norsys.gestionlivresapi.exceptions.ResourceUsedException;
import fr.norsys.gestionlivresapi.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {


    @Autowired
    private AuthorService authorService;


    @GetMapping
    public ResponseEntity<List<Author>> findAll(){
        List<Author> authors=authorService.getAll();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable int id) {
        Author author = authorService.findById(id);
        if(author==null)
            throw new ResourceNotFoundException("Author with id:" + id + " does not exist");

        return ResponseEntity.ok().body(author);
    }

    @PostMapping
    public ResponseEntity<Void> createAuthor(@RequestBody @Valid Author author){
        Author author1=authorService.findById(author.getId());
        if(author1!=null) {
            throw new ResourceUsedException("Author with id: " + author1.getId() + " already exists");
        }
        authorService.save(author);
        return ResponseEntity.ok(null);
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public  ResponseEntity<Author> update(@PathVariable int id,@RequestBody Author authorDetails) {
        Author updatedAuthor=authorService.findById(id);
        if(updatedAuthor==null)
            throw new ResourceNotFoundException("Author with id:" + id + "does not exist");

        updatedAuthor.setEmail(authorDetails.getEmail());
        updatedAuthor.setName(authorDetails.getName());
        authorService.save(updatedAuthor);
        return ResponseEntity.ok().body(updatedAuthor);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        Author author = authorService.findById(id);
        if(author==null)
            throw new ResourceNotFoundException("Author with id:" + id + " does not exist");
        authorService.deleteById(id);
        return  ResponseEntity.ok(null);
    }


}




