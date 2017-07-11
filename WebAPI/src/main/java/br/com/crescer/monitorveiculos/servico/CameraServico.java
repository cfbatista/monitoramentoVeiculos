package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Camera;
import br.com.crescer.monitorveiculos.entidade.RetornoHeatMapModel;
import br.com.crescer.monitorveiculos.repositorio.CameraRepositorio;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diandra Rocha
 */
@Service
public class CameraServico {

    @Autowired
    private CameraRepositorio cameraRepositorio;

    public Camera findById(long id) {
        return cameraRepositorio.findOne(id);
    }

    public long contagemTotal() {
        return cameraRepositorio.count();
    }

    public List<Camera> obterTodas() {
        return (List<Camera>) cameraRepositorio.findAll();
    }

    public List<RetornoHeatMapModel> retornarModel(Date dataInicial, Date dataFinal, Long idcameraInicial, Long idcameraFinal, Character direcao) {

        return cameraRepositorio.retornarModel(dataInicial, dataFinal, idcameraInicial, idcameraFinal, direcao);
    }

}
