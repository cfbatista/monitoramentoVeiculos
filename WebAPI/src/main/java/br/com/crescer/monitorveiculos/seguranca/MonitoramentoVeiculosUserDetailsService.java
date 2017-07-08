package br.com.crescer.monitorveiculos.seguranca;

import br.com.crescer.monitorveiculos.entidade.Usuario;
import br.com.crescer.monitorveiculos.servico.UsuarioServico;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MonitoramentoVeiculosUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioServico usuarioServico;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioServico.findByEmail(email);

        if (email.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        final GrantedAuthority grant = usuario.getPermissao();

        return new User(usuario.getEmail(), usuario.getSenha(), Arrays.asList(usuario.getPermissao()));

    }
}
