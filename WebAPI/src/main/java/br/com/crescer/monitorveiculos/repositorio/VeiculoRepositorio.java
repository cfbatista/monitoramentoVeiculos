    package br.com.crescer.monitorveiculos.repositorio;

import br.com.crescer.monitorveiculos.entidade.ConsultaVeiculosModel;
import br.com.crescer.monitorveiculos.entidade.RetornoHeatMapModel;
import br.com.crescer.monitorveiculos.entidade.Veiculo;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Diandra Rocha
 */
public interface VeiculoRepositorio extends CrudRepository<Veiculo, Long> {

    public Veiculo findByPlacaIgnoreCase(String placa);
    
//    @Query("SELECT new br.com.crescer.monitorveiculos.entidade.ConsultaVeiculosModel()")
//    List<ConsultaVeiculosModel> consultaVeiculos(@Param("placa") String placa);;
}
