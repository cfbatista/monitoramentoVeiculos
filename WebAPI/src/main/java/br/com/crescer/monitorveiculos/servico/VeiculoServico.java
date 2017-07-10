package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.repositorio.VeiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diandra Rocha
 */
@Service
public class VeiculoServico {

    @Autowired
    private VeiculoRepositorio veiculoRepositorio;

    public long totalVeiculos() {
        return veiculoRepositorio.count();
    }
    
    public Veiculo pegarVeiculoPorId(Long id){
        return veiculoRepositorio.findOne(id);
    }
    
    public Veiculo pegarVeiculoPorPlaca(String placa){
        return veiculoRepositorio.findOne(placa);
    }
}
