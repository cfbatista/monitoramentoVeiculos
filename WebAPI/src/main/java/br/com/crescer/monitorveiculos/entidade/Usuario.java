package br.com.crescer.monitorveiculos.entidade;

import br.com.crescer.monitorveiculos.seguranca.MonitoramentoVeiculosRoles;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author diandra.rocha
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    private Long idusuario;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String email;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String senha;

    @JsonFormat(pattern="dd/MM/yyyy")
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date datanascimento;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String rg;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String cpf;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String telefone;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String endereco;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String bairro;

    @JoinColumn(name = "IDCIDADE", referencedColumnName = "IDCIDADE")
    @ManyToOne(optional = false)
    private Cidade idcidade;

    private MonitoramentoVeiculosRoles permissao;
}
