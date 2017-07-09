package br.com.crescer.monitorveiculos.controle;

import br.com.crescer.monitorveiculos.entidade.Camera;
import br.com.crescer.monitorveiculos.entidade.HeatMapModel;
import br.com.crescer.monitorveiculos.entidade.RegistroCountModel;
import br.com.crescer.monitorveiculos.servico.CameraServico;
import br.com.crescer.monitorveiculos.servico.RegistroServico;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diandra Rocha
 */
@RestController
@RequestMapping(value = "/registro")
public class RegistroControle {

    @Autowired
    RegistroServico registroService;
    @Autowired
    CameraServico cameraService;

    @PostMapping("/heatmap")
    public List<HeatMapModel> obterHeatMap(@RequestBody RegistroCountModel model) {
        List<HeatMapModel> lista = new ArrayList<>();
        long contagemCameras = cameraService.contagemTotal();

        for (int i = 0; i < contagemCameras; i++) {
            Camera camera = cameraService.findById(i);
            Long fator = registroService.obterFatorDeIntensidade(camera, model.getDataInicial(), model.getDataFinal());
            HeatMapModel heatObject = HeatMapModel.builder().camera(camera).fator(fator).build();
            lista.add(heatObject);
        }

        return lista;

    }
}
