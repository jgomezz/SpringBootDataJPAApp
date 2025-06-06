package pe.edu.tecsup.springbootapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoriaDTO {
    private Long id;
    private String nombre;
    private Integer orden;
}
