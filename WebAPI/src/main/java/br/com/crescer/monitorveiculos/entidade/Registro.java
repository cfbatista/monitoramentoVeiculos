package br.com.crescer.monitorveiculos.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "REGISTRO")

public class Registro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    private Long idregistro;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String placa;

    @Size(max = 30)
    @Column(name = "COR_PREDOMINANTE")
    private String corPredominante;

    private Long velocidade;

    @JoinColumn(name = "IDCAMERA", referencedColumnName = "IDCAMERA")
    @ManyToOne(optional = false)
    private Camera idcamera;

}
