package br.com.crescer.monitorveiculos.servico;

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

    public long totalCidades() {
        return cidadeRepositorio.count();
    }

}
