package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Usuario;
import br.com.crescer.monitorveiculos.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diandra.rocha
 */
@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public Usuario findByEmail(String email) {
        return usuarioRepositorio.findByEmail(email);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }
}
