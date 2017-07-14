package br.com.crescer.monitorveiculos.entidade;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "OCORRENCIA")
public class Ocorrencia implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SEQ_NAME = "SEQ_OCORRENCIA";

    @GeneratedValue(strategy = SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Id
    @Basic(optional = false)
    @NotNull
    private Long idocorrencia;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_OCORRENCIA")
    private Character tipoOcorrencia;

    @Basic(optional = false)
    @NotNull
    private Character estacionado;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTAVA_NO_CARRO")
    private Character estavaNoCarro;

    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_MELIANTES")
    private short numeroMeliantes;

    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_VITIMAS")
    private short numeroVitimas;

    @Basic(optional = false)
    @NotNull
    @Column(name = "SEXO_PROPRIETARIO")
    private Character sexoProprietario;

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDADE_VITIMA")
    private short idadeVitima;

    @Basic(optional = false)
    @NotNull
    @Column(name = "MELIANTE_EM_OUTRO_VEICULO")
    private Character melianteEmOutroVeiculo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "OUTROS_PERTENCES_LEVADOS")
    private Character outrosPertencesLevados;

    @Basic(optional = false)
    @NotNull
    @Column(name = "VEICULO_SEGURADO")
    private Character veiculoSegurado;

    @Basic(optional = false)
    @NotNull
    @Column(name = "VEICULO_COM_RASTREADOR")
    private Character veiculoComRastreador;

    @Basic(optional = false)
    @NotNull
    @Column(name = "SITUACAO_OCORRENCIA")
    private Character situacaoOcorrencia;

    @JoinColumn(name = "IDVEICULO", referencedColumnName = "IDVEICULO")
    @ManyToOne(optional = false)
    private Veiculo veiculo;

    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario usuario;

    @JoinColumn(name = "IDCIDADE", referencedColumnName = "IDCIDADE")
    @ManyToOne(optional = false)
    private Cidade cidade;

    @Column(name = "LATITUDE")
    private BigInteger latitude;

    @Column(name = "LONGITUDE")
    private BigInteger longitude;

}
