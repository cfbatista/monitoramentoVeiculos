package br.com.crescer.monitorveiculos.controle;

import br.com.crescer.monitorveiculos.entidade.Cidade;
import br.com.crescer.monitorveiculos.servico.CidadeServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeControle {

    @Autowired
    private CidadeServico cidadeServico;

    @GetMapping(value = "/obter/todas")
    public List<Cidade> pegarCidades() {
        List<Cidade> retorno = cidadeServico.listarCidades(); 
        return retorno;
    }

    @GetMapping(value = "/obter/numerocidades")
    public Long pegarNumeroCidades() {
        return cidadeServico.totalCidades();
    }

    @GetMapping(value = "/obter/cidadescomregistro")
    public Long pegarNumeroCidadesComRegistros() {
        return cidadeServico.numeroCidadesComRegistros();
    }
}
