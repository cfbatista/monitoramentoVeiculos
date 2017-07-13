package br.com.crescer.monitorveiculos.repositorio;

import br.com.crescer.monitorveiculos.entidade.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author diandra.rocha
 */
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

    public Usuario findByEmail(String email);

}
