package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Cidade;
import br.com.crescer.monitorveiculos.entidade.Veiculo;
import br.com.crescer.monitorveiculos.repositorio.CidadeRepositorio;
import br.com.crescer.monitorveiculos.repositorio.VeiculoRepositorio;
import java.util.List;
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
    @Autowired
    private VeiculoRepositorio veiculoRepositorio;

    public List<Cidade> listarCidades() {
        return (List<Cidade>) cidadeRepositorio.findAll();
    }

    public long totalCidades() {
        return cidadeRepositorio.count();
    }

    public Cidade pegarCidadePorId(Long id) {
        return cidadeRepositorio.findOne(id);
    }

    public Long numeroCidadesComRegistros() {
        return cidadeRepositorio.getNumeroCidadesComRegistros();
    }

    public String encontrarCidade(String placa) {
        Veiculo veiculo = veiculoRepositorio.findByPlacaIgnoreCase(placa);
        return veiculo.getCidade().getNome();
    }
}
