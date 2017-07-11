package br.com.crescer.monitorveiculos.repositorio;

import br.com.crescer.monitorveiculos.entidade.RetornoHeatMapModel;
import br.com.crescer.monitorveiculos.entidade.Veiculo;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Diandra Rocha
 */
public interface VeiculoRepositorio extends CrudRepository<Veiculo, Long> {

    public Veiculo findByPlaca(String placa);

    @Query("select new br.com.crescer.monitorveiculo.entidade.RetornoHeatMapModel(ca.idcamera, ca.latitude, ca.longitude, ca.nome,"
            + " trunc(re.data_hora), "
            + " count(re.idregistro))"
            + " from camera ca"
            + " inner join registro re on re.idcamera = ca.idcamera"
            + "where re.data_hora between to_date(:dataInicial, 'dd/mm/yyyy') and to_date(:dataFinal, 'dd/mm/yyyy') + .99999"
            + "and re.direcao = :direcao"
            + "group by ca.idcamera, ca.nome, trunc(re.data_hora), ca.latitude, ca.longitude;")
    public RetornoHeatMapModel retornarModel(@Param("dataIncial") Date dataInicial, @Param("dataFinal") Date dataFinal, @Param("direcao") String direcao);

}
