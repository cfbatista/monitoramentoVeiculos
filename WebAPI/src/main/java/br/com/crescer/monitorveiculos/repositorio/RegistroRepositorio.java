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

    public List<Registro> findByDataHoraBetween(Date dataInicial, Date dataFinal);

    public Long countByCameraAndDataHoraBetween(Camera camera, Date dataInicial, Date dataFinal);

    public Long countByPlaca(String placa);

    @Query("SELECT COUNT (DISTINCT ca.idcamera) FROM Registro re INNER JOIN re.camera ca WHERE re.placa = :placa")
    public Long obterNumeroDeCamerasComRegistros(@Param("placa") String placa);

    @Query("SELECT COUNT(re.idregistro) FROM Registro re WHERE re.velocidade > re.camera.velocidadeMaxima AND re.placa = :placa")
    public Long obterNumeroDeVezesQuePassouVelocidade(@Param("placa") String placa);

    @Query(value = "SELECT COUNT( DISTINCT TRUNC(re.data_hora) ) "
            + "FROM Registro re INNER JOIN "
            + "Veiculo v ON "
            + "re.placa = :placa "
            + "INNER JOIN Camera c "
            + "ON c.idcidade != v.idcidade WHERE "
            + "re.data_hora BETWEEN :dataInicial AND :dataFinal", nativeQuery = true)
    public Long obterNumeroVezesVeiculoForaSuaCidade(
            @Param("placa") String placa,
            @Param("dataInicial") Date dataInicial,
            @Param("dataFinal") Date dataFinal);

    @Query("SELECT new br.com.crescer.monitorveiculos.modelo.VeiculoSuspeito "
            + "(re.placa, COUNT(re.idregistro), COUNT(DISTINCT re.camera.cidade.uf)) "
            + "FROM Registro re GROUP BY re.placa "
            + "HAVING COUNT(DISTINCT re.camera.cidade.uf) > 1")
    public List<VeiculoSuspeito> obterVeiculosSuspeitos();

    @Query("SELECT COUNT(re.idregistro) "
            + "FROM Registro re WHERE re.dataHora BETWEEN :dataInicial AND :dataFinal")
    public Long contagemRegistrosHorario(
            @Param("dataInicial") Date dataInicial,
            @Param("dataFinal") Date dataFinal);

    public Long countByDataHoraBetween(Date data1, Date data2);

}
