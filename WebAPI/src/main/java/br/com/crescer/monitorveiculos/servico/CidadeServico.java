package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Cidade;
import br.com.crescer.monitorveiculos.repositorio.CidadeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diandra Rocha
 */
@Service
public class CidadeServico {

    @Autowired
    private CidadeRepositorio cidadeRepositorio;

    public Iterable<Cidade> listarCidades() {
        return cidadeRepositorio.findAll();
    }

    public long totalCidades() {
        return cidadeRepositorio.count();
    }

    public Cidade pegarCidadePorId(Long id) {
        return cidadeRepositorio.findOne(id);
    }
}
