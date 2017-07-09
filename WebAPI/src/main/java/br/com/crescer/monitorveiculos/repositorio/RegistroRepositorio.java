package br.com.crescer.monitorveiculos.repositorio;

import br.com.crescer.monitorveiculos.entidade.Registro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Diandra Rocha
 */
public interface RegistroRepositorio extends CrudRepository<Registro, Long> {

    @Query("SELECT COUNT(u) FROM Registro r WHERE r.idcamera=:id")
    long buscarPorRegistros(@Param("id") long id);

}
