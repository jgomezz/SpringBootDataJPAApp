## Proyecto Spring Boot con Spring Data JPA


### Migración

#### 1.- Relacionar las clases de los entities con las tablas
```
@Entity
@Table(name="categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="orden")
    private Integer orden;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos = new ArrayList<>();


    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", orden=" + orden +
                '}';
    }
}
```
```
@Entity
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categorias_id")
    private Categoria categoria;

    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String imagen_nombre;
    private String imagen_tipo;
    private Long imagen_tamanio;
    private Integer estado;
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime creado;

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", imagen_nombre='" + imagen_nombre + '\'' +
                ", imagen_tipo='" + imagen_tipo + '\'' +
                ", imagen_tamanio=" + imagen_tamanio +
                ", estado=" + estado +
                '}';
    }
}

```


#### 2.- En la capa de repositorio extender las interfases de JpaRepository y se paramétriza 

```
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

}
```
```
public interface ProductoRepository extends JpaRepository<Producto,Long> {

     List<Producto> findByNombre(String nombre) ;

     @Modifying
     @Query("UPDATE Producto p SET p.nombre = :nombreProducto WHERE p.id = :id")
     void update(@Param("id") Long id, @Param("nombreProducto") String nombreProducto);

}
```

#### 3.- En la capa de servicios hacerlo transaccional
```
@Slf4j
@Transactional
@Service
public class ProductoServiceImpl implements ProductoService {

   . . . 
   . . .

}
```