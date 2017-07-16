package br.com.crescer.monitorveiculos.controle;

import br.com.crescer.monitorveiculos.entidade.Horario;
import br.com.crescer.monitorveiculos.modelo.RegistroCountModel;
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

    @GetMapping(value = "obter/numeroveiculossuspeitos")
    public int obterNumeroVeiculosSuspeitos() {
        return registroService.obterNumeroDeVeiculosClonados();
    }

    @PostMapping(value = "/obter/veiculosporhorario")
    public List<RetornoHorariosModel> obterContagemPorHorario(@RequestBody RegistroCountModel model) {
        List<RetornoHorariosModel> lista = new ArrayList<>();

        lista.add(registroService.retornarPorHorarios(model, Horario.MADRUGADA));
        lista.add(registroService.retornarPorHorarios(model, Horario.INICIO_MANHA));
        lista.add(registroService.retornarPorHorarios(model, Horario.MANHA));
        lista.add(registroService.retornarPorHorarios(model, Horario.MEIO_DIA));
        lista.add(registroService.retornarPorHorarios(model, Horario.TARDE));
        lista.add(registroService.retornarPorHorarios(model, Horario.FINAL_TARDE));
        lista.add(registroService.retornarPorHorarios(model, Horario.NOITE));
        return lista;
    }

}
