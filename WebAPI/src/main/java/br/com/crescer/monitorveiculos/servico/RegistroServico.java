package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Camera;
import br.com.crescer.monitorveiculos.repositorio.CameraRepositorio;
import br.com.crescer.monitorveiculos.repositorio.RegistroRepositorio;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diandra Rocha
 */
@Service
public class RegistroServico {

    @Autowired
    RegistroRepositorio registroRepositorio;
    @Autowired
    CameraRepositorio cameraRepositorio;

    public Long obterRegistrosPorCameraDataHora(long idcamera, Date dataInicial, Date dataFinal) {
        Camera camera = cameraRepositorio.findOne(idcamera);
        return registroRepositorio.countByIdcameraAndDataHoraBetween(camera, dataInicial, dataFinal);
    }
}
