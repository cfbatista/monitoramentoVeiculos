package br.com.crescer.monitorveiculos.controle;

import br.com.crescer.monitorveiculos.entidade.Cidade;
import br.com.crescer.monitorveiculos.entidade.Usuario;
import br.com.crescer.monitorveiculos.modelo.UsuarioModel;
import br.com.crescer.monitorveiculos.servico.CidadeServico;
import br.com.crescer.monitorveiculos.servico.ComponenteServico;
import br.com.crescer.monitorveiculos.servico.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private CidadeServico cidadeServico;

    @GetMapping
    public Usuario getUsuario() {
        return componenteServico.getUserSession();
    }

    @PostMapping("/cadastrar")
    public Usuario cadastrar(@RequestBody UsuarioModel usuario) throws Exception {

        Usuario usuarioPersist = CriarUsuarioBaseadoModel(usuario);

        if (usuarioServico.findByEmail(usuarioPersist.getEmail()) != null) {
            throw new Exception("Já possui um usuário cadastrado com esse e-mail");
        }

        return usuarioServico.save(usuarioPersist);
    }

    public Usuario CriarUsuarioBaseadoModel(UsuarioModel usuario) {
        Cidade cidade = cidadeServico.pegarCidadePorId(usuario.getIdcidade());
        Usuario u = new Usuario();
        u.setBairro(usuario.getBairro());
        u.setCpf(usuario.getCpf());
        u.setDatanascimento(usuario.getDatanascimento());
        u.setEmail(usuario.getEmail());
        u.setEndereco(usuario.getEndereco());
        u.setCidade(cidade);
        u.setRg(usuario.getRg());
        u.setSenha(usuario.getSenha());
        u.setTelefone(usuario.getTelefone());
        return u;
    }
}
