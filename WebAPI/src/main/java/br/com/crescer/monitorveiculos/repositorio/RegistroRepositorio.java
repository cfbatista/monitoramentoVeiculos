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
    Long obterQuantidadeRegistrosVeiculo(@Param("placa") String placa);

    @Query("SELECT COUNT(idcamera) FROM Registro GROUP BY idcamera")
    Long obterNumeroDeCamerasComRegistros();

    @Query("SELECT COUNT(re.idregistro) FROM Registro re WHERE re.velocidade > re.camera.velocidadeMaxima AND re.placa = :placa")
    Long obterNumeroDeVezesQuePassouVelocidade(@Param("placa") String placa);

}
