package br.com.crescer.monitorveiculos.controle;

import br.com.crescer.monitorveiculos.entidade.Veiculo;
import br.com.crescer.monitorveiculos.servico.VeiculoServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author camila.batista
 */
@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoControle {

    @Autowired
    private VeiculoServico veiculoServico;

    @GetMapping(value = "/obter/contagem")
    public Long contagemVeiculos() {
        return veiculoServico.totalVeiculos();
    }

    @GetMapping(value = "/obter/todos")
    public List<Veiculo> obterVeiculos() {
        return veiculoServico.obterTodosVeiculos();
    }

    @GetMapping(value = "/obter/{id}")
    public Veiculo obterPorId(@PathVariable Long id) {
        return veiculoServico.obterVeiculoPorId(id);
    }

    @GetMapping(value = "/obter/{placa}")
    public Veiculo obterPorPlaca(@PathVariable String placa) {
        return veiculoServico.obterVeiculoPorPlaca(placa);
    }
}
