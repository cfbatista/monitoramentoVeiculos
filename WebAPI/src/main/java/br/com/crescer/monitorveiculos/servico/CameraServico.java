package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.repositorio.CameraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diandra Rocha
 */
@Service
public class CameraServico {

    @Autowired
    private CameraRepositorio cameraRepositorio;

}
