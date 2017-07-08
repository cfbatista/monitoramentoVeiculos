package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Usuario;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author Diandra Rocha
 */
@Component
public class ComponenteServico {

    @Autowired
    private UsuarioServico usuarioServico;

    public Usuario getUserSession() {
        return Optional
                .ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .map(User::getUsername)
                .map(usuarioServico::findByEmail)
                .orElse(null);
    }

}
