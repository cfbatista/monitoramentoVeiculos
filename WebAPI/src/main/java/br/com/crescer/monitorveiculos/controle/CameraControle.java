package br.com.crescer.monitorveiculos.controle;

import br.com.crescer.monitorveiculos.entidade.RegistroCountModel;
import br.com.crescer.monitorveiculos.entidade.RetornoHeatMapModel;
import br.com.crescer.monitorveiculos.servico.CameraServico;
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

    @PostMapping(value = "/heatmap")
    public List<RetornoHeatMapModel> retornarModel(@RequestBody RegistroCountModel registroCountModel) {
        return cameraServico.retornarModel(registroCountModel.getDataInicial(), registroCountModel.getDataFinal(),
                registroCountModel.getIdCameraInicial(), registroCountModel.getIdCameraFinal(), registroCountModel.getDirecao());
    }
}
