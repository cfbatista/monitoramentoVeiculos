package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Registro;
import br.com.crescer.monitorveiculos.modelo.VeiculoSuspeito;
import br.com.crescer.monitorveiculos.repositorio.RegistroRepositorio;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diandra Rocha
 */
@Service
public class RegistroServico {

    @Autowired
    RegistroRepositorio registroRepositorio;

    private List<Registro> obterRegistrosPorDataHora(Date dataInicial, Date dataFinal) {
        return registroRepositorio.findByDataHoraBetween(dataInicial, dataFinal);
    }

    public Long obterTotalCameras() {
        return registroRepositorio.count();
    }

    public Long obterNumeroDeVezesQuePassouVelocidade(String placa) {
        return registroRepositorio.obterNumeroDeVezesQuePassouVelocidade(placa);
    }

    public List<VeiculoSuspeito> obterVeiculosSuspeitos() {
        return registroRepositorio.obterVeiculosSuspeitos();
    }
}
