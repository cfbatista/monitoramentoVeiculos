package br.com.crescer.monitorveiculos.repositorio;

import br.com.crescer.monitorveiculos.entidade.Camera;
import br.com.crescer.monitorveiculos.modelo.RetornoHeatMapModel;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Diandra Rocha
 */
public interface CameraRepositorio extends CrudRepository<Camera, Long> {

    @Query("SELECT new br.com.crescer.monitorveiculos.modelo.RetornoHeatMapModel "
            + "(re.camera, COUNT(re.idregistro)) "
            + "FROM Registro re "
            + "WHERE re.dataHora BETWEEN :dataInicial AND :dataFinal "
            + "AND re.camera.idcamera BETWEEN :idCameraInicial AND :idCameraFinal "
            + "AND re.camera.direcao = :direcao "
            + "GROUP BY re.camera")
    public List<RetornoHeatMapModel> retornarModel(
            @Param("dataInicial") Date dataInicial,
            @Param("dataFinal") Date dataFinal,
            @Param("idCameraInicial") Long idCameraInicial,
            @Param("idCameraFinal") Long idCameraFinal,
            @Param("direcao") Character direcao
    );

    public List<Camera> findByDirecao(Character direcao);

    @Query("SELECT COUNT(re.idregistro) FROM Registro re "
            + "WHERE re.dataHora BETWEEN :dataInicial AND :dataFinal "
            + "AND re.camera.idcamera BETWEEN :idCameraInicial AND :idCameraFinal "
            + "AND re.camera.direcao = :direcao")
    public Long contagemRegistrosDeRota(
            @Param("dataInicial") Date dataInicial,
            @Param("dataFinal") Date dataFinal,
            @Param("idCameraInicial") Long idCameraInicial,
            @Param("idCameraFinal") Long idCameraFinal,
            @Param("direcao") Character direcao
    );

    @Query("SELECT SUM(re.velocidade) FROM Registro re "
            + "WHERE re.dataHora BETWEEN :dataInicial AND :dataFinal "
            + "AND re.camera.idcamera = :idCamera "
            + "AND re.camera.direcao = :direcao")
    public Long somaVelocidades(
            @Param("dataInicial") Date dataInicial,
            @Param("dataFinal") Date dataFinal,
            @Param("idCamera") Long idCamera,
            @Param("direcao") Character direcao
    );

    @Query("SELECT re.placa FROM Registro re WHERE re.velocidade > re.camera.velocidadeMaxima AND re.camera.idcamera = :idCamera")
    public List<String> obterPlacasQuePassaramVelocidade(@Param("idCamera") Long idCamera);

}
