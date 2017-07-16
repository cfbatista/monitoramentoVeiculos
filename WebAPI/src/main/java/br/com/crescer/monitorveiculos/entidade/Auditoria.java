package br.com.crescer.monitorveiculos.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
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
@Table(name = "AUDITORIA")

public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SEQ_NAME = "SQ_AUDITORIA";

    @GeneratedValue(strategy = SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Id
    @Basic(optional = false)
    @NotNull
    private Long idauditoria;

    @Basic(optional = false)
    @NotNull
    @Size(max = 255)
    private String tipoconsulta;

    @Basic(optional = false)
    @NotNull
    private String dadoconsultado;

    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario usuario;

}
