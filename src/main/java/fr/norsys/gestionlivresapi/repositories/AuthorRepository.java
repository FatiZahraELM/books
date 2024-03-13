package fr.norsys.gestionlivresapi.repositories;

import fr.norsys.gestionlivresapi.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {


}
