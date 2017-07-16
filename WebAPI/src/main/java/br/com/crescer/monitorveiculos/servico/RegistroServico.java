package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Horario;
import br.com.crescer.monitorveiculos.modelo.RegistroCountModel;
import br.com.crescer.monitorveiculos.modelo.RetornoHorariosModel;
import br.com.crescer.monitorveiculos.modelo.VeiculoSuspeito;
import br.com.crescer.monitorveiculos.repositorio.CameraRepositorio;
import br.com.crescer.monitorveiculos.repositorio.RegistroRepositorio;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
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

    public Long obterTotalCameras() {
        return registroRepositorio.count();
    }

    public Long obterNumeroDeVezesQuePassouVelocidade(String placa) {
        return registroRepositorio.obterNumeroDeVezesQuePassouVelocidade(placa);
    }

    public List<VeiculoSuspeito> obterVeiculosSuspeitos() {
        return registroRepositorio.obterVeiculosSuspeitos();
    }

    public int obterNumeroDeVeiculosClonados() {
        return registroRepositorio.obterVeiculosSuspeitos().size();
    }

    public RetornoHorariosModel retornarPorHorarios(RegistroCountModel model, Horario horario) {
        LocalDateTime dataAux = LocalDateTime.ofInstant(model.getData().toInstant(), ZoneId.systemDefault());

        List<LocalTime> horarios = horario.getHorarios();
        LocalDateTime dataInicial = dataAux.with(horarios.get(0));
        LocalDateTime dataFinal = dataAux.with(horarios.get(1));

        ZonedDateTime zonedDate = dataInicial.atZone(ZoneId.systemDefault());
        Date dataInicialD = Date.from(zonedDate.toInstant());

        ZonedDateTime zonedDate2 = dataFinal.atZone(ZoneId.systemDefault());
        Date dataFinalD = Date.from(zonedDate2.toInstant());

        Long contagem = cameraRepositorio.contagemRegistrosDeRota(dataInicialD, dataFinalD,
                model.getIdCameraInicial(), model.getIdCameraFinal(), model.getDirecao());

        return new RetornoHorariosModel(horario, contagem);

    }
}
