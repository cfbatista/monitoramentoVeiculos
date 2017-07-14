package br.com.crescer.monitorveiculos.controle;

import br.com.crescer.monitorveiculos.entidade.Ocorrencia;
import br.com.crescer.monitorveiculos.modelo.RetornoTop;
import br.com.crescer.monitorveiculos.servico.OcorrenciaServico;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ocorrencia")
public class OcorrenciaControle {

    @Autowired
    private OcorrenciaServico ocorrenciaServico;

    @GetMapping(value = "/obter/todas")
    public List<Ocorrencia> pegarTodasOcorrencias() {
        return ocorrenciaServico.todasOcorrencias();
    }

    @PostMapping
    public Ocorrencia salvarOcorrencia(@Valid @RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaServico.criarOcorrencia(ocorrencia);
    }

    @GetMapping(value = "/obter/tresultimosmeses")
    public Long pegarTresUltimosMesesOcorrencias() {
        return ocorrenciaServico.listarOcorrenciasUltimosTresMeses();
    }

    @GetMapping(value = "/obter/topmarcas")
    public List<RetornoTop> topMarcasOcorrencia() {
        return ocorrenciaServico.topMarcasOcorrencia();
    }

    @GetMapping(value = "/obter/topmodelos")
    public List<RetornoTop> topModelosOcorrencia() {
        return ocorrenciaServico.topModelosOcorrencia();
    }

    @GetMapping(value = "/obter/topcidades")
    public List<RetornoTop> topCidadesOcorrencia() {
        return ocorrenciaServico.topCidadesOcorrencia();
    }

    @GetMapping(value = "/obter/ocorrenciasusuario/{idusuario}")
    public List<Ocorrencia> listarPorUsuario(@PathVariable("idusuario") Long idusuario) {
        return ocorrenciaServico.listarPorUsuario(idusuario);
    }

    @Secured({"ROLE_ADMINISTRADOR", "ROLE_AUTORIDADE"})
    @GetMapping(value = "/obter/obtertodasocorrencias")
    public List<Ocorrencia> listarTodas() {
        return ocorrenciaServico.listarTodas();
    }

}
