package br.com.crescer.monitorveiculos.modelo;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *
 * @author William
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UsuarioModel {
    
    private Long idusuario;
    private String email;
    private String senha;
    private Date datanascimento;
    private String rg;
    private String cpf;
    private String telefone;
    private String endereco;
    private String bairro;
    private Long idcidade;
}
