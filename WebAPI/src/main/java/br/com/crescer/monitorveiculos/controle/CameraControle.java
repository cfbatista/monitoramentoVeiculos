package br.com.crescer.monitorveiculos.controle;

import br.com.crescer.monitorveiculos.entidade.Camera;
import br.com.crescer.monitorveiculos.modelo.CalculoEnergiaModel;
import br.com.crescer.monitorveiculos.modelo.DiaSemanaRegistros;
import br.com.crescer.monitorveiculos.modelo.HeatMapModel;
import br.com.crescer.monitorveiculos.modelo.RegistroCountModel;
import br.com.crescer.monitorveiculos.modelo.RetornoHeatMapModel;
import br.com.crescer.monitorveiculos.seguranca.MonitoramentoVeiculosException;
import br.com.crescer.monitorveiculos.servico.CameraServico;
import br.com.crescer.monitorveiculos.servico.RegistroServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diandra.rocha
 */
@RestController
@RequestMapping(value = "/camera")
public class CameraControle {

    @Autowired
    CameraServico cameraServico;
    @Autowired
    RegistroServico registroServico;

    @GetMapping("buscarcameraporsentido/{direcao}")
    public List<Camera> buscarCamerasPorSentido(@PathVariable Character direcao) {
        return cameraServico.buscarCamerasPorDirecao(direcao);
    }

    @PostMapping(value = "/heatmap")
    public List<HeatMapModel> retornarHeatMap(@RequestBody RegistroCountModel registroCountModel) {
        List<RetornoHeatMapModel> models = cameraServico.retornarModel(registroCountModel.getData(),
                registroCountModel.getIdCameraInicial(), registroCountModel.getIdCameraFinal(), registroCountModel.getDirecao());
        return cameraServico.calcularFator(models);
    }

    @GetMapping(value = "obter/contagemtotal")
    public Long contagemTotal() {
        return cameraServico.contagemTotal();
    }

    @GetMapping(value = "obter/todascameras")
    public List<Camera> obterTodas() {
        return cameraServico.obterTodas();
    }

    @GetMapping(value = "/obterporid/{id}")
    public Camera obterPorId(@PathVariable long id) throws MonitoramentoVeiculosException {
        return cameraServico.obterPotId(id);
    }

    @PostMapping(value = "/energia")
    public CalculoEnergiaModel obterEnergia(@RequestBody RegistroCountModel registroCountModel) {
        return cameraServico.calculoEnergia(registroCountModel);
    }

    @PostMapping(value = "/obter/contagemdiassemana")
    public List<DiaSemanaRegistros> obterContagemPorDiaDaSemana(@RequestBody RegistroCountModel model) {
        return cameraServico.obterContagemPorDiaDaSemana(model);
    }

    @PostMapping(value = "/obter/numeroregistros")
    public Long contagemRegistros(@RequestBody RegistroCountModel registroCountModel) {
        return cameraServico.contagemRegistrosDeRota(registroCountModel.getData(),
                registroCountModel.getIdCameraInicial(),
                registroCountModel.getIdCameraFinal(),
                registroCountModel.getDirecao());
    }
    
    @PostMapping(value = "/obter/detalhescamera/numeroregistros")
    public Long contagemRegistrosCameraDetalhes(@RequestBody RegistroCountModel registroCountModel) throws MonitoramentoVeiculosException {
        Camera camera = cameraServico.obterPotId(registroCountModel.getIdCameraInicial());
        return cameraServico.contagemRegistrosDeRota(registroCountModel.getData(),
                camera.getIdcamera(),
                camera.getIdcamera(),
                camera.getDirecao());
    }

    @PostMapping(value = "/obter/mediavelocidade")
    public Double mediaVelocidade(@RequestBody RegistroCountModel model) {
        return cameraServico.mediaVelocidade(model);
    }

    @GetMapping(value = "/obter/foramaximovelocidade/{idCamera}")
    public List<String> obterPlacasQuePassaramVelocidade(@PathVariable Long idCamera) {
        return cameraServico.obterPlacasQuePassaramVelocidade(idCamera);
    }
}
