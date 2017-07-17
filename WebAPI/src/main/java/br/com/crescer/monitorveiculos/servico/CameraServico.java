package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Camera;
import br.com.crescer.monitorveiculos.modelo.CalculoEnergiaModel;
import br.com.crescer.monitorveiculos.modelo.DiaSemanaRegistros;
import br.com.crescer.monitorveiculos.modelo.HeatMapModel;
import br.com.crescer.monitorveiculos.modelo.RegistroCountModel;
import br.com.crescer.monitorveiculos.modelo.RetornoHeatMapModel;
import br.com.crescer.monitorveiculos.repositorio.CameraRepositorio;
import br.com.crescer.monitorveiculos.repositorio.RegistroRepositorio;
import br.com.crescer.monitorveiculos.seguranca.MonitoramentoVeiculosException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
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

    public Camera obterPotId(long id) throws MonitoramentoVeiculosException {
        Camera camera = cameraRepositorio.findOne(id);

        if (camera == null) {
            throw new MonitoramentoVeiculosException("Camera não encontrada");
        }

        return camera;
    }

    public long contagemTotal() {
        return cameraRepositorio.count();
    }

    public List<Camera> obterTodas() {
        return (List<Camera>) cameraRepositorio.findAll();
    }

    public List<RetornoHeatMapModel> retornarModel(Date data, Long idcameraInicial, Long idcameraFinal, Character direcao) {
        List<Date> datas = calculaData(data);
        return cameraRepositorio.retornarModel(datas.get(0), datas.get(1), idcameraInicial, idcameraFinal, direcao);
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

        return retorno.stream().
                sorted(Comparator.comparing(e -> e.getCamera().getIdcamera()))
                .collect(Collectors.toList());
    }

    public List<Camera> buscarCamerasPorDirecao(Character direcao) {
        return cameraRepositorio.findByDirecao(direcao);
    }

    public Long contagemRegistrosDeRota(Date data, Long idCameraInicial, Long idCameraFinal, Character direcao) {
        List<Date> datas = calculaData(data);
        return cameraRepositorio.contagemRegistrosDeRota(datas.get(0), datas.get(1), idCameraInicial, idCameraFinal, direcao);
    }

    public Double calculoKilometragem(Double metros) {
        return metros / 1000;
    }

    public CalculoEnergiaModel calculoEnergia(RegistroCountModel model) {
        Double km = calculoKilometragem(model.getMetros());
        Long registros = contagemRegistrosDeRota(model.getData(), model.getIdCameraInicial(), model.getIdCameraFinal(), model.getDirecao());
        Double energia = (km * KWH * registros) / 1000;
        CalculoEnergiaModel retorno = CalculoEnergiaModel.builder().distancia(km).energia(energia).numeroVeiculos(registros).build();
        return retorno;
    }

    public List<Date> calculaData(Date data) {
        LocalDateTime dataInicial = converterData(data).with(LocalTime.of(0, 0, 0, 0));
        LocalDateTime dataFinal = converterData(data).with(LocalTime.of(23, 59, 59, 59));

        return Arrays.asList(converterLocalDate(dataInicial), converterLocalDate(dataFinal));

    }

    private LocalDateTime converterData(Date data) {
        return LocalDateTime.ofInstant(data.toInstant(), ZoneId.systemDefault());
    }

    private Date converterLocalDate(LocalDateTime data) {
        ZonedDateTime zonaData = data.atZone(ZoneId.systemDefault());
        return Date.from(zonaData.toInstant());
    }

    public LocalDateTime dataInicioSemana(Date data) {

        LocalDateTime dataAux = converterData(data);

        return dataAux.with(DayOfWeek.SUNDAY);

    }

    public List<DiaSemanaRegistros> obterContagemPorDiaDaSemana(RegistroCountModel model) {
        List<DiaSemanaRegistros> retorno = new ArrayList<>();
        LocalDateTime primeiroDia = dataInicioSemana(model.getData());
        
        for (int i = 0; i < 7; i++) {
            LocalDateTime dias = primeiroDia.plusDays(i);
            List<Date> datas = calculaData(converterLocalDate(dias));
            Long count = cameraRepositorio.contagemRegistrosDeRota(
                    datas.get(0), datas.get(1), model.getIdCameraInicial(),
                    model.getIdCameraFinal(), model.getDirecao());
           
            String diaSemana = dias.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
            retorno.add(new DiaSemanaRegistros(diaSemana, count));
        }
        return retorno;
    }

    public Long somaVelocidades(RegistroCountModel model) {
        List<Date> datas = calculaData(model.getData());
        Camera camera = cameraRepositorio.findOne(model.getIdCameraInicial());
        return cameraRepositorio.somaVelocidades(datas.get(0), datas.get(1),
                camera.getIdcamera(), camera.getDirecao());
    }

    public Double mediaVelocidade(RegistroCountModel model) {
        List<Date> datas = calculaData(model.getData());
        Camera camera = cameraRepositorio.findOne(model.getIdCameraInicial());
        Long contagem = registroRepositorio.countByCameraAndDataHoraBetween(camera, datas.get(0), datas.get(1));
        Long soma = somaVelocidades(model);

        return soma / contagem.doubleValue();
    }

    public List<String> obterPlacasQuePassaramVelocidade(Long idCamera) {
        return cameraRepositorio.obterPlacasQuePassaramVelocidade(idCamera);
    }

}
