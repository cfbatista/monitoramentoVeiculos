package br.com.crescer.monitorveiculos.controle;

import br.com.crescer.monitorveiculos.entidade.Ocorrencia;
import br.com.crescer.monitorveiculos.servico.OcorrenciaServico;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ocorrencia")
public class OcorrenciaControle {
    @Autowired
    private OcorrenciaServico ocorrenciaServico;
    
    @GetMapping
    public Iterable<Ocorrencia> pegarTodasOcorrencias(){
        return ocorrenciaServico.todasOcorrencias();
    }
    
    @PostMapping
    public Ocorrencia salvarOcorrencia(@Valid @RequestBody Ocorrencia ocorrencia){
        return ocorrenciaServico.criarOcorrencia(ocorrencia);
    }
}
