package br.com.crescer.monitorveiculos.controle;

import br.com.crescer.monitorveiculos.entidade.Horario;
import br.com.crescer.monitorveiculos.modelo.DataModel;
import br.com.crescer.monitorveiculos.modelo.RetornoHorariosModel;
import br.com.crescer.monitorveiculos.modelo.VeiculoSuspeito;
import br.com.crescer.monitorveiculos.servico.RegistroServico;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "obter/veiculossuspeitos")
    public List<VeiculoSuspeito> obterVeiculosSuspeitos() {
        return registroService.obterVeiculosSuspeitos();
    }

    @PostMapping(value = "/obter/veiculosporhorario")
    public List<RetornoHorariosModel> obterContagemPorHorario(@RequestBody DataModel model) {
        List<RetornoHorariosModel> lista = new ArrayList<>();

        lista.add(registroService.retornarPorHorarios(model.getData(), Horario.MADRUGADA));
        lista.add(registroService.retornarPorHorarios(model.getData(), Horario.INICIO_MANHA));
        lista.add(registroService.retornarPorHorarios(model.getData(), Horario.MANHA));
        lista.add(registroService.retornarPorHorarios(model.getData(), Horario.MEIO_DIA));
        lista.add(registroService.retornarPorHorarios(model.getData(), Horario.TARDE));
        lista.add(registroService.retornarPorHorarios(model.getData(), Horario.FINAL_TARDE));
        lista.add(registroService.retornarPorHorarios(model.getData(), Horario.NOITE));
        return lista;
    }

}
