package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Veiculo;
import br.com.crescer.monitorveiculos.repositorio.CidadeRepositorio;
import br.com.crescer.monitorveiculos.repositorio.VeiculoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diandra Rocha
 */
@Service
public class VeiculoServico {

    @Autowired
    private VeiculoRepositorio veiculoRepositorio;
    @Autowired
    private CidadeRepositorio cidadeRepositorio;

    public List<Veiculo> obterTodosVeiculos() {
        return (List<Veiculo>) veiculoRepositorio.findAll();
    }

    public Long totalVeiculos() {
        return veiculoRepositorio.count();
    }

    public Veiculo obterVeiculoPorId(Long id) {
        return veiculoRepositorio.findOne(id);
    }

    public Veiculo obterVeiculoPorPlaca(String placa) {
        return veiculoRepositorio.findByPlaca(placa);
    }
   
    public List<Long> contarVeiculosPorCidades(){
        return veiculoRepositorio.countByCidadeGroupByCidade();
    }
}
