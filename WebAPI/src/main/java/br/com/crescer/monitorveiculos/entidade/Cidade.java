package br.com.crescer.monitorveiculos.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "CIDADE")

public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    private Long idcidade;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String nome;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    private String uf;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "IDCIDADE")
    private List<Veiculo> veiculos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "IDCIDADE")
    private List<Camera> cameras;

}
