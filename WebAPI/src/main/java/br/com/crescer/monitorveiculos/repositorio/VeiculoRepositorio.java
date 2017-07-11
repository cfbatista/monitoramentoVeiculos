    package br.com.crescer.monitorveiculos.repositorio;

import br.com.crescer.monitorveiculos.entidade.Veiculo;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Diandra Rocha
 */
public interface VeiculoRepositorio extends CrudRepository<Veiculo, Long> {

    public Veiculo findByPlacaIgnoreCase(String placa);

//    @Query("SELECT new br.com.crescer.monitorveiculos.entidade.RetornoHeatMapModel(re.camera, TRUNC(re.dataHora), COUNT(re.idregistro)) FROM"
//            + " Registro re WHERE re.dataHora BETWEEN :dataInicial AND :dataFinal"
//            + " GROUP BY re.camera, TRUNC(re.dataHora)")
//    List<RetornoHeatMapModel> retornarModel(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal);

    
//    @Query("SELECT new br.com.crescer.monitorveiculos.entidade.ConsultaVeiculosModel()")
//    List<ConsultaVeiculosModel> consultaVeiculos(@Param("placa") String placa);;
}
