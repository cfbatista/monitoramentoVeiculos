package br.com.crescer.monitorveiculos.controle;

import br.com.crescer.monitorveiculos.entidade.Auditoria;
import br.com.crescer.monitorveiculos.entidade.Veiculo;
import br.com.crescer.monitorveiculos.modelo.ConsultaVeiculosModel;
import br.com.crescer.monitorveiculos.servico.AuditoriaServico;
import br.com.crescer.monitorveiculos.servico.ComponenteServico;
import br.com.crescer.monitorveiculos.servico.VeiculoServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
    @Autowired
    private ComponenteServico componenteServico;
    @Autowired
    private AuditoriaServico auditoriaServico;

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

    @GetMapping(value = "/numeroregistros/{placa}")
    public Long obterRegistros(@PathVariable String placa) {
        return veiculoServico.buscarNumeroRegistros(placa);
    }

    @GetMapping(value = "/numeroregistroscamera/{placa}")
    public Long obterRegistrosPorCamera(@PathVariable String placa) {
        return veiculoServico.obterNumeroeRegistrosPorCamera(placa);
    }

    @Secured("ROLE_ADMINISTRADOR")
    @GetMapping(value = "/consulta/{placa}")
    public ConsultaVeiculosModel consultarVeiculos(@PathVariable String placa) {
        Auditoria aud = Auditoria.builder()
                .usuario(componenteServico.getUserSession())
                .tipoconsulta("Consulta Veículo")
                .dadoconsultado(placa).build();
        auditoriaServico.salvar(aud);
        return veiculoServico.realizarBusca(placa);
    }
}
