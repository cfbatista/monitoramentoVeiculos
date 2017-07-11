package br.com.crescer.monitorveiculos.repositorio;

import br.com.crescer.monitorveiculos.entidade.Ocorrencia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author William
 */
public interface OcorrenciaRepositorio extends CrudRepository<Ocorrencia, Long> {
    
    @Query("select count(idocorrencia) from Ocorrencia where data_hora between SYSDATE and add_months(sysdate,-3)")
    public Long getOcorrenciasLasttresUltimosMeses();

}
