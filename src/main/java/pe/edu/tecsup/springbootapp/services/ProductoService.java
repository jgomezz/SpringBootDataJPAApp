package pe.edu.tecsup.springbootapp.services;

import pe.edu.tecsup.springbootapp.dto.ProductoDTO;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<ProductoDTO> findAll() throws Exception;

    List<ProductoDTO> findByNombre(String nombre) throws Exception;

    Optional<ProductoDTO> findById(Long id) throws Exception;

    void save(ProductoDTO productoDTO) throws Exception;

    void deleteById(Long id) throws Exception;

    void update(Long id, String nombreProducto) throws Exception;

}
