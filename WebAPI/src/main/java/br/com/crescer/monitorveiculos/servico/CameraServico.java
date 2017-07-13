package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Camera;
import br.com.crescer.monitorveiculos.modelo.CalculoEnergiaModel;
import br.com.crescer.monitorveiculos.modelo.HeatMapModel;
import br.com.crescer.monitorveiculos.modelo.RegistroCountModel;
import br.com.crescer.monitorveiculos.modelo.RetornoHeatMapModel;
import br.com.crescer.monitorveiculos.modelo.VeiculosPorSemanaModel;
import br.com.crescer.monitorveiculos.repositorio.CameraRepositorio;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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
        
        return retorno;
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
        Double energia = km * KWH * registros;
        CalculoEnergiaModel retorno = CalculoEnergiaModel.builder().distancia(km).energia(energia).numeroVeiculos(registros).build();
        return retorno;
    }
   
    public List<VeiculosPorSemanaModel> calcularNumeroVeiculosPorDiaSemana(RegistroCountModel model){
        List<Date> diasSemana = pegarDiasSemana(model.getData());
        VeiculosPorSemanaModel veiculosModel = new VeiculosPorSemanaModel();
        List<VeiculosPorSemanaModel> retorno = null;
        for(int i = 0; i < diasSemana.size()-2; i++){
            Long NumeroVeiculos  = cameraRepositorio.contagemRegistrosDeRota(diasSemana.get(i), diasSemana.get(i+1), model.getIdCameraInicial(), model.getIdCameraFinal(), model.getDirecao());
            veiculosModel.setDiaSemana(diasSemana.get(i));
            veiculosModel.setNumeroCarros(NumeroVeiculos);
            retorno.add(veiculosModel);
        }
        return retorno;
    }
    
    public static List<Date> calculaData(Date data) {
        LocalDateTime dataInicial = LocalDateTime.ofInstant(data.toInstant(), ZoneId.systemDefault()).with(LocalTime.of(0, 0, 0, 0));
        ZonedDateTime zonaDataInicial = dataInicial.atZone(ZoneId.systemDefault());
        
        LocalDateTime dataFinal = LocalDateTime.ofInstant(data.toInstant(), ZoneId.systemDefault()).with(LocalTime.of(23, 59, 59, 59));
        ZonedDateTime zonaDataFinal = dataFinal.atZone(ZoneId.systemDefault());
        
        return Arrays.asList(Date.from(zonaDataInicial.toInstant()), Date.from(zonaDataFinal.toInstant()));
    }
    
     public List<Date> pegarDiasSemana(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dia = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DAY_OF_MONTH, -dia+1);
        List<Date> retorno = null;
        for(int i = 0; i<8; i++){ 
            cal.add(Calendar.DAY_OF_WEEK, i);
            retorno.add(cal.getTime());
        }
        return retorno;
    }
    
}
