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

    //Todos Objetos Cidade
    @GetMapping(value = "/obter/todas")
    public List<Cidade> pegarCidades() {
        return cidadeServico.listarCidades();
    }

    //Todos numrero de cidades
    @GetMapping(value = "/obter/numerocidades")
    public Long pegarNumeroCidades() {
        return cidadeServico.totalCidades();
    }

    //obter numero de cidades com registros
    @GetMapping(value = "obter/cidadescomregistro")
    public Long pegarNumeroCidadesComRegistros() {
        return cidadeServico.numeroCidadesComRegistros();
    }
}
