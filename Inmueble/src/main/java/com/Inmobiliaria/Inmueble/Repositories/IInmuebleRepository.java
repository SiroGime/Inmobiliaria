//ackage com.Inmobiliaria.Inmueble.Repositories;
//
//mport com.Inmobiliaria.Inmueble.Models.Inmueble;
//mport com.Inmobiliaria.Inmueble.Models.Operacion;
//mport org.springframework.data.jpa.repository.JpaRepository;
//mport org.springframework.stereotype.Repository;
//
//mport java.util.List;
//
//Repository
//ublic interface IInmuebleRepository extends JpaRepository<Inmueble, Integer> {
//   List<Inmueble> findByDisponible(boolean disponible);
//
//   List<Inmueble> findByOperacion(Operacion operacion);
//
//   // Método genérico para buscar inmuebles de un tipo específico
//   <T extends Inmueble> List<T> findByTipo(Class<T> tipo);
//
