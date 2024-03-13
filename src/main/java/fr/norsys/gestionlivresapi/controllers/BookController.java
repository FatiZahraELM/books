package fr.norsys.gestionlivresapi.controllers;


import fr.norsys.gestionlivresapi.entities.Book;
import fr.norsys.gestionlivresapi.exceptions.ResourceNotFoundException;
import fr.norsys.gestionlivresapi.exceptions.ResourceUsedException;
import fr.norsys.gestionlivresapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> books= bookService.getAll();
        return ResponseEntity.ok(books);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable int id) {
        Book updatedBook = bookService.getBookById(id);
        if(updatedBook==null)
            throw new ResourceNotFoundException("Book with id:" + id + " does not exist");
        return ResponseEntity.ok().body(updatedBook);
    }

    @PostMapping
    public ResponseEntity<Void> createBook(@RequestBody Book book){
        Book checkBook=bookService.getBookById(book.getId());
        if(checkBook!=null) {
            throw new ResourceUsedException("Book with id: " + book.getId() + " already exists");
        }
        bookService.save(book);
        return ResponseEntity.ok(null);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable int id, @RequestBody Book bookDetails) {

        Book updatedBook = bookService.getBookById(id);
        if(updatedBook==null)
            throw new ResourceNotFoundException("Book with id:" + id + " does not exist");
        updatedBook.setTitle(bookDetails.getTitle());
        updatedBook.setPrice(bookDetails.getPrice());
        updatedBook.setAuthor(bookDetails.getAuthor());
        bookService.save(updatedBook);

        return ResponseEntity.ok().body(updatedBook);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        if(book==null)
            throw new ResourceNotFoundException("Book with id:" + id + " does not exist");
        bookService.deleteById(id);
        return  ResponseEntity.ok(null);
    }

}
