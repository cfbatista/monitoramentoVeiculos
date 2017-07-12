package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Registro;
import br.com.crescer.monitorveiculos.repositorio.CameraRepositorio;
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
    @Autowired
    CameraRepositorio cameraRepositorio;

    private List<Registro> obterRegistrosPorDataHora(Date dataInicial, Date dataFinal) {
        return registroRepositorio.findByDataHoraBetween(dataInicial, dataFinal);
    }
    
    public Long obterTotalCameras() {
        return registroRepositorio.count();
    }

    public Long obterNumeroDeVezesQuePassouVelocidade(String placa) {
        return registroRepositorio.obterNumeroDeVezesQuePassouVelocidade(placa);
    }
}
