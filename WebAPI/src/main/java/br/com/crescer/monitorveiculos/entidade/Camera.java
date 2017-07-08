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
@Table(name = "CAMERA")

public class Camera implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    private Long idcamera;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String nome;

    @Basic(optional = false)
    @NotNull
    private Character situacao;

    @Basic(optional = false)
    @NotNull
    @Column(name = "VELOCIDADE_MAXIMA")
    private short velocidadeMaxima;

    @Column(name = "LONGITUDE")
    private Long longitude;

    @Column(name = "LATITUDE")
    private Long latitude;

    @JoinColumn(name = "IDCIDADE", referencedColumnName = "IDCIDADE")
    @ManyToOne(optional = false)
    private Cidade idcidade;

}
