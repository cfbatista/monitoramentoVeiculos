package br.com.crescer.monitorveiculos.service;

import br.com.crescer.monitorveiculos.entidade.Usuario;
import br.com.crescer.monitorveiculos.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author diandra.rocha
 */
public class UsuarioService {

    @Autowired
    public UsuarioRepositorio repo;

    Usuario findByEmail(String email) {
        return repo.findByEmail(email);
    }
}
