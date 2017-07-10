package br.com.crescer.monitorveiculos.controle;

import br.com.crescer.monitorveiculos.entidade.Usuario;
import br.com.crescer.monitorveiculos.seguranca.MonitoramentoVeiculosRoles;
import br.com.crescer.monitorveiculos.servico.ComponenteServico;
import br.com.crescer.monitorveiculos.servico.UsuarioServico;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diandra.rocha
 */
@RestController
@RequestMapping(value = "/usuario")
public class LoginControle {

    @Autowired
    private UsuarioServico usuarioServico;
    @Autowired
    private ComponenteServico componenteServico;
    
    @GetMapping
    public Usuario getUsuario() {
        return componenteServico.getUserSession();
    }

    @PostMapping("/cadastrar")
    public Usuario cadastrar(@Valid @RequestBody Usuario usuario) throws Exception {
        if (usuarioServico.findByEmail(usuario.getEmail()) != null) {
              throw new Exception("Já possui um usuário cadastrado com esse e-mail");
        }
        return usuarioServico.save(usuario);
    }

}
