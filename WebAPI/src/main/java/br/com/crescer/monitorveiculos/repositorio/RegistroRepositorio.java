package br.com.crescer.monitorveiculos.repositorio;

import br.com.crescer.monitorveiculos.entidade.Camera;
import br.com.crescer.monitorveiculos.entidade.Registro;
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

    @Query("SELECT count(idocorrencia) FROM Registro r WHERE r.placa = :placa")
    Long countByRegistroWithVeiculo(@Param("placa") String placa);
    
    @Query("SELECT COUNT(idcamera) FROM Registro")
    Long getTotalCameras();
    
    @Query("SELECT COUNT(idcamera) FROM Registro GROUP BY idcamera")
    Long countByRegistroWithCameras();
  
    @Query("SELECT COUNT(re.idregistro) FROM Registro re WHERE re.dataHora BETWEEN :dataInicial AND :dataFinal "
            + "AND re.camera.idcamera BETWEEN :idCameraInicial AND :idCameraFinal "
            + "AND re.camera.direcao = :direcao ")
    public Long retornarContagemTotal(
            @Param("dataInicial") Date dataInicial,
            @Param("dataFinal") Date dataFinal,
            @Param("idCameraInicial") Long idCameraInicial,
            @Param("idCameraFinal") Long idCameraFinal,
            @Param("direcao") Character direcao
    );
}
