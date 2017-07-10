package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Camera;
import br.com.crescer.monitorveiculos.repositorio.RegistroRepositorio;
import java.util.Date;
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

    public Long obterRegistrosPorCameraDataHora(Camera camera, Date dataInicial, Date dataFinal) {
        return registroRepositorio.countByIdcameraAndDataHoraBetween(camera, dataInicial, dataFinal);
    }

    public Long obterSomaRegistrosPorCameraDataHora(Camera camera, Date dataInicial, Date dataFinal) {
        //return registroRepositorio.sumByIdcameraAndDataHoraBetween(camera, dataInicial, dataFinal);
        int i = 10;
        Long n = (long) i; 
        return n;
    }

    public Long obterFatorDeIntensidade(Camera camera, Date dataInicial, Date dataFinal) {
        Long soma = obterSomaRegistrosPorCameraDataHora(camera, dataInicial, dataFinal);
        Long count = obterRegistrosPorCameraDataHora(camera, dataInicial, dataFinal);
        return count / soma;
    }
}
