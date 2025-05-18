package pe.edu.tecsup.springbootapp.services;

import pe.edu.tecsup.springbootapp.dtos.CategoriaDTO;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    List<CategoriaDTO> findAll() throws Exception;

    Optional<CategoriaDTO> findById(Long id) throws Exception;

}
