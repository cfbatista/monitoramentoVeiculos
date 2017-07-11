package br.com.crescer.monitorveiculos.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "VEICULO")
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    private Long idveiculo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String modelo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    private String cor;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ANO_FABRICACAO")
    private short anoFabricacao;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ANO_MODELO")
    private short anoModelo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    private String placa;

    @Basic(optional = false)
    @NotNull
    private Character situacao;

    @Column(name = "TIPO_VEICULO")
    private Character tipoVeiculo;

    @JoinColumn(name = "IDCIDADE", referencedColumnName = "IDCIDADE")
    @ManyToOne(optional = false)
    private Cidade cidade;

    @JoinColumn(name = "IDMARCA", referencedColumnName = "IDMARCA")
    @ManyToOne
    
    private Marca marca;

}
