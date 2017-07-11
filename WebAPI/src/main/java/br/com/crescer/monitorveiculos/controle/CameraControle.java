package br.com.crescer.monitorveiculos.controle;

import br.com.crescer.monitorveiculos.modelo.HeatMapModel;
import br.com.crescer.monitorveiculos.modelo.RegistroCountModel;
import br.com.crescer.monitorveiculos.modelo.RetornoHeatMapModel;
import br.com.crescer.monitorveiculos.servico.CameraServico;
import br.com.crescer.monitorveiculos.servico.RegistroServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(value = "/heatmap")
    public List<HeatMapModel> retornarHeatMap(@RequestBody RegistroCountModel registroCountModel) {
        List<RetornoHeatMapModel> models = cameraServico.retornarModel(registroCountModel.getDataInicial(), registroCountModel.getDataFinal(),
                registroCountModel.getIdCameraInicial(), registroCountModel.getIdCameraFinal(), registroCountModel.getDirecao());
        Long contagem = registroServico.retornarContagemTotal(registroCountModel.getDataInicial(), registroCountModel.getDataFinal(),
                registroCountModel.getIdCameraInicial(), registroCountModel.getIdCameraFinal(), registroCountModel.getDirecao());

        return cameraServico.calcularFator(models, contagem);
    }

}
