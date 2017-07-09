
package br.com.crescer.monitorveiculos.repositorio;

import br.com.crescer.monitorveiculos.entidade.Ocorrencia;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author William
 */
public interface OcorrenciaRepositorio extends CrudRepository<Ocorrencia, Long>{
    
}
