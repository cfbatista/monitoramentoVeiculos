package br.com.crescer.monitorveiculos.repositorio;

import br.com.crescer.monitorveiculos.entidade.Camera;
import br.com.crescer.monitorveiculos.entidade.Cidade;
import br.com.crescer.monitorveiculos.entidade.Registro;
import br.com.crescer.monitorveiculos.entidade.Veiculo;
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
    
    @Query(value = "select count( distinct trunc(r.data_hora) ) " +
            "from registro r inner join " +
            "veiculo v on " +
            "r.placa = :placa " +
            "inner join camera c " +
            "on c.idcidade != v.idcidade where " +
            "r.data_hora BETWEEN :dataInicial and :dataFinal", nativeQuery = true)
    Long obterNumeroVezesVeiculoForaSuaCidade(
        @Param("placa") String placa,
        @Param("dataInicial") Date dataInicial,
        @Param("dataFinal") Date dataFinal);

    @Query("SELECT new br.com.crescer.monitorveiculos.modelo.VeiculoSuspeito "
            + "(re.placa, COUNT(re.idregistro), COUNT(DISTINCT re.camera.idcidade.uf)) "
            + "FROM Registro re GROUP BY re.placa "
            + "HAVING COUNT(DISTINCT re.camera.idcidade.uf) > 1")
    public List<VeiculoSuspeito> obterVeiculosSuspeitos();
}
