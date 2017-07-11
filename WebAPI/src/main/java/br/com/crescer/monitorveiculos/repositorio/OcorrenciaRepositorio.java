package br.com.crescer.monitorveiculos.repositorio;

import br.com.crescer.monitorveiculos.entidade.Ocorrencia;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author William
 */
public interface OcorrenciaRepositorio extends CrudRepository<Ocorrencia, Long> {

    @Query("SELECT COUNT(idocorrencia) from Ocorrencia where data_hora between :datainicial and :datafinal)")
    public Long getOcorrenciasLasttresUltimosMeses(@Param("datainicial") Date datainicial, @Param("datafinal") Date datafinal);
}
