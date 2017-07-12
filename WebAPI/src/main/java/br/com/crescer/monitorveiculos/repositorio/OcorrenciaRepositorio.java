package br.com.crescer.monitorveiculos.repositorio;

import br.com.crescer.monitorveiculos.entidade.Ocorrencia;
import br.com.crescer.monitorveiculos.entidade.Veiculo;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author William
 */
public interface OcorrenciaRepositorio extends CrudRepository<Ocorrencia, Long> {

    @Query("SELECT COUNT(idocorrencia) FROM Ocorrencia WHERE data_hora BETWEEN :datainicial AND :datafinal)")
    public Long getOcorrenciasTresUltimosMeses(@Param("datainicial") Date datainicial, @Param("datafinal") Date datafinal);

    public Long countByVeiculo(Veiculo veiculo);
}
