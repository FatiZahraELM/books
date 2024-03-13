package fr.norsys.gestionlivresapi.repositories;

import fr.norsys.gestionlivresapi.DTO.BookDto;
import fr.norsys.gestionlivresapi.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository <Book,Integer> {

}



