package br.com.crescer.monitorveiculos.controle;

import br.com.crescer.monitorveiculos.entidade.HeatMapModel;
import br.com.crescer.monitorveiculos.entidade.RegistroCountModel;
import br.com.crescer.monitorveiculos.servico.RegistroServico;
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

    @PostMapping("/heatmap")
    public List<HeatMapModel> obterHeatMap(@RequestBody RegistroCountModel model) {
        return registroService.retornoParaHeatMap(model.getDataInicial(), model.getDataFinal());
    }
}
