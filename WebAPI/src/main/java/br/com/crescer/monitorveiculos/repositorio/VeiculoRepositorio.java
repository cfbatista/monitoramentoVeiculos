package br.com.crescer.monitorveiculos.repositorio;

import br.com.crescer.monitorveiculos.entidade.RetornoTopMarcasOcorrencia;
import br.com.crescer.monitorveiculos.entidade.Veiculo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Diandra Rocha
 */
public interface VeiculoRepositorio extends CrudRepository<Veiculo, Long> {

    public Veiculo findByPlacaIgnoreCase(String placa);
    
//    @Query("SELECT new br.com.crescer.monitorveiculos.entidade.RetornoTopMarcasOcorrencia "
//            + "COUNT(idocorrencia), nome "
//            + "FROM Ocorrencia "
//            + "GROUP BY Ocorrencia.Veiculo.Marca")
//    public List<RetornoTopMarcasOcorrencia> buscarTopOcorrenciasPorVeiculo();
    
//    @Query("SELECT new br.com.crescer.monitorveiculos.entidade.ConsultaVeiculosModel()")
//    List<ConsultaVeiculosModel> consultaVeiculos(@Param("placa") String placa);;
}
