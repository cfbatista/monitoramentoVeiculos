package br.com.crescer.monitorveiculos.repositorio;

import br.com.crescer.monitorveiculos.entidade.Ocorrencia;
import br.com.crescer.monitorveiculos.entidade.Veiculo;
import br.com.crescer.monitorveiculos.modelo.RetornoTop;
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

    @Query("SELECT new br.com.crescer.monitorveiculos.modelo.RetornoTop "
            + "(oc.veiculo.marca.nome, COUNT(oc.idocorrencia)) "
            + "FROM Ocorrencia oc WHERE ROWNUM <= 10 GROUP BY oc.veiculo.marca.nome ORDER BY COUNT(oc.idocorrencia) DESC")
    public List<RetornoTop> topMarcasOcorrencia();

    @Query("SELECT new br.com.crescer.monitorveiculos.modelo.RetornoTop "
            + "(oc.veiculo.modelo, COUNT(oc.idocorrencia)) "
            + "FROM Ocorrencia oc WHERE ROWNUM <= 10 GROUP BY oc.veiculo.modelo ORDER BY COUNT(oc.idocorrencia) DESC")
    public List<RetornoTop> topModelosOcorrencia();

    @Query("SELECT new br.com.crescer.monitorveiculos.modelo.RetornoTop "
            + "(oc.veiculo.cidade.nome, COUNT(oc.idocorrencia)) "
            + "FROM Ocorrencia oc WHERE ROWNUM <= 10 GROUP BY oc.veiculo.cidade ORDER BY COUNT(oc.idocorrencia) DESC")
    public List<RetornoTop> topCidadesOcorrencia();

}
