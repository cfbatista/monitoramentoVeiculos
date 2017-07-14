package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Usuario;
import br.com.crescer.monitorveiculos.repositorio.UsuarioRepositorio;
import br.com.crescer.monitorveiculos.seguranca.MonitoramentoVeiculosException;
import br.com.crescer.monitorveiculos.seguranca.MonitoramentoVeiculosRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    public Usuario save(Usuario usuario) throws MonitoramentoVeiculosException {

        if (usuario.getSenha() == null || usuario.getEmail() == null) {
            throw new MonitoramentoVeiculosException("Usuário inválido");
        }

        if (usuario.getIdusuario() == null) {
            usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));

        }

        usuario.setPermissao(MonitoramentoVeiculosRoles.ROLE_USUARIO);
        return usuarioRepositorio.save(usuario);
    }

    public void delete(Usuario usuario) {
        usuarioRepositorio.delete(usuario);
    }
}
