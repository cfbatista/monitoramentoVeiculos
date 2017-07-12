package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Camera;
import br.com.crescer.monitorveiculos.modelo.CalculoEnergiaModel;
import br.com.crescer.monitorveiculos.modelo.HeatMapModel;
import br.com.crescer.monitorveiculos.modelo.RegistroCountModel;
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

    private static final Double KWH = 0.66;

    public Camera findById(long id) {
        return cameraRepositorio.findOne(id);
    }

    public long contagemTotal() {
        return cameraRepositorio.count();
    }

    public List<Camera> obterTodas() {
        return (List<Camera>) cameraRepositorio.findAll();
    }

    public List<RetornoHeatMapModel> retornarModel(Date data, Long idcameraInicial, Long idcameraFinal, Character direcao) {

        return cameraRepositorio.retornarModel(data, idcameraInicial, idcameraFinal, direcao);
    }

    public List<HeatMapModel> calcularFator(List<RetornoHeatMapModel> lista) {
        List<HeatMapModel> retorno = new ArrayList<>();

        Long total = lista
                .stream()
                .mapToLong(e -> e.getCountRegistros())
                .sum();

        lista.stream().forEach(e -> {
            final Double fator = (e.getCountRegistros().doubleValue() / total) * 100;
            final HeatMapModel heatMapModel = new HeatMapModel(e.getCamera(), fator);
            retorno.add(heatMapModel);
        });

        return retorno;
    }

    public List<Camera> buscarCamerasPorDirecao(Character direcao) {
        return cameraRepositorio.findByDirecao(direcao);
    }

    public Long contagemRegistrosDeRota(Date data, Long idCameraInicial, Long idCameraFinal, Character direcao) {
        return cameraRepositorio.contagemRegistrosDeRota(data, idCameraInicial, idCameraFinal, direcao);
    }

    public Double calculoKilometragem(Double metros) {
        return metros / 1000;
    }

    public CalculoEnergiaModel calculoEnergia(RegistroCountModel model) {
        Double km = calculoKilometragem(model.getMetros());
        Long registros = contagemRegistrosDeRota(model.getData(), model.getIdCameraInicial(), model.getIdCameraFinal(), model.getDirecao());
        Double energia = km * KWH * registros;
        CalculoEnergiaModel retorno = CalculoEnergiaModel.builder().distancia(km).energia(energia).build();
        return retorno;
    }
}
