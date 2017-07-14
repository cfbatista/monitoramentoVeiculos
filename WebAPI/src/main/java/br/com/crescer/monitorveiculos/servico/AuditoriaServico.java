package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Auditoria;
import br.com.crescer.monitorveiculos.repositorio.AuditoriaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diandra.rocha
 */
@Service
public class AuditoriaServico {

    @Autowired
    AuditoriaRepositorio auditoriaRepositorio;

    public Auditoria salvar(Auditoria auditoria) {
        return auditoriaRepositorio.save(auditoria);
    }

    public List<Auditoria> obterTodas() {
        return (List<Auditoria>) auditoriaRepositorio.findAll();
    }

}
