package br.com.crescer.monitorveiculos.repositorio;

import br.com.crescer.monitorveiculos.entidade.Camera;
import br.com.crescer.monitorveiculos.entidade.Registro;
import br.com.crescer.monitorveiculos.modelo.VeiculoSuspeito;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Diandra Rocha
 */
public interface RegistroRepositorio extends CrudRepository<Registro, Long> {

    List<Registro> findByDataHoraBetween(Date dataInicial, Date dataFinal);

    Long countByCameraAndDataHoraBetween(Camera camera, Date dataInicial, Date dataFinal);

    Long countByPlaca(String placa);

    @Query("SELECT COUNT (DISTINCT ca.idcamera) FROM Registro re INNER JOIN re.camera ca WHERE re.placa = :placa")
    Long obterNumeroDeCamerasComRegistros(@Param("placa") String placa);

    @Query("SELECT COUNT(re.idregistro) FROM Registro re WHERE re.velocidade > re.camera.velocidadeMaxima AND re.placa = :placa")
    Long obterNumeroDeVezesQuePassouVelocidade(@Param("placa") String placa);

    @Query("SELECT new br.com.crescer.monitorveiculos.modelo.VeiculoSuspeito "
            + "( (DISTINCT re.veiculo), COUNT(re.idregistro), COUNT(DISTINCT re.cidade.uf)) "
            + "FROM Registro re GROUP BY re.veiculo.placa, re.dataHora "
            + "HAVING COUNT(DISTINCT re.cidade.uf) > 1")
    public List<VeiculoSuspeito> obterVeiculosSuspeitos();
}
