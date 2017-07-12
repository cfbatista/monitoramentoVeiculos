package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Camera;
import br.com.crescer.monitorveiculos.modelo.HeatMapModel;
import br.com.crescer.monitorveiculos.modelo.RetornoHeatMapModel;
import br.com.crescer.monitorveiculos.repositorio.CameraRepositorio;
import br.com.crescer.monitorveiculos.repositorio.RegistroRepositorio;
import java.util.ArrayList;
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
    @Autowired
    private RegistroRepositorio registroRepositorio;

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

    public List<HeatMapModel> calcularFator(List<RetornoHeatMapModel> lista, Long total) {
        List<HeatMapModel> retorno = new ArrayList<>();

        lista.stream().forEach(e -> {
            final Double fator = (e.getCountRegistros().doubleValue() / total) * 100;
            final HeatMapModel heatMapModel = new HeatMapModel(e.getCamera(), fator);
            retorno.add(heatMapModel);
        });

        return retorno;
    }
    
    public List<Camera> buscarCamerasPorDirecao(Character direcao){
        return cameraRepositorio.findByDirecao(direcao);
    }
}
