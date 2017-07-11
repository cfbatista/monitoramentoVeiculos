package br.com.crescer.monitorveiculos.repositorio;

import br.com.crescer.monitorveiculos.entidade.RetornoHeatMapModel;
import br.com.crescer.monitorveiculos.entidade.Veiculo;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Diandra Rocha
 */
public interface VeiculoRepositorio extends CrudRepository<Veiculo, Long> {

    public Veiculo findByPlaca(String placa);

    @Query("SELECT new br.com.crescer.monitorveiculos.entidade.RetornoHeatMapModel(re.camera, TRUNC(re.dataHora), COUNT(re.idregistro)) FROM"
            + " Registro re WHERE re.dataHora BETWEEN :dataInicial AND :dataFinal"
            + " GROUP BY re.camera, TRUNC(re.dataHora)")
    List<RetornoHeatMapModel> retornarModel(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal);
}
