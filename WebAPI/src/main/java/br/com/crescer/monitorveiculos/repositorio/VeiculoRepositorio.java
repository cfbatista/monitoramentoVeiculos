package br.com.crescer.monitorveiculos.repositorio;

import br.com.crescer.monitorveiculos.entidade.Veiculo;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Diandra Rocha
 */
public interface VeiculoRepositorio extends CrudRepository<Veiculo, Long> {

    public Veiculo findByPlaca(String placa);

    @Query("select ca.idcamera, ca.latitude, ca.longitude,\n"
            + "       ca.nome,\n"
            + "       trunc(re.data_hora) data_hora,\n"
            + "       count(re.idregistro) total_registros\n"
            + "from   camera ca\n"
            + " inner join registro re on re.idcamera = ca.idcamera\n"
            + "where re.data_hora between to_date('28/03/2017', 'dd/mm/yyyy') and to_date('28/03/2017', 'dd/mm/yyyy') + .99999\n"
            + "and re.idcamera in (2, 4, 6, 8, 10, 12, 14, 16) -- INTERVALO DE IDs DE CAMERAS\n"
            + "group by ca.idcamera, ca.nome, trunc(re.data_hora), ca.latitude, ca.longitude;")


}
