package pe.edu.tecsup.springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.tecsup.springbootapp.entities.Categoria;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    // List<Categoria> findAll() ;
}
