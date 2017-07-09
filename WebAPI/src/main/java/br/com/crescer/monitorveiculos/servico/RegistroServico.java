package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.repositorio.CameraRepositorio;
import br.com.crescer.monitorveiculos.repositorio.RegistroRepositorio;
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

    public long buscarPorRegistros(long id) {
        return registroRepositorio.buscarPorRegistros(id);
    }

}
