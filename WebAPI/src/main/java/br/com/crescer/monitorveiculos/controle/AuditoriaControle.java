package br.com.crescer.monitorveiculos.controle;

import br.com.crescer.monitorveiculos.entidade.Auditoria;
import br.com.crescer.monitorveiculos.servico.AuditoriaServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diandra.rocha
 */
@RestController
@RequestMapping(value = "/auditoria")
public class AuditoriaControle {

    @Autowired
    AuditoriaServico auditoriaServico;

    @GetMapping(value = "/obterAuditorias")
    public List<Auditoria> obterTodasAuditorias() {
        return auditoriaServico.obterTodas();
    }

}
