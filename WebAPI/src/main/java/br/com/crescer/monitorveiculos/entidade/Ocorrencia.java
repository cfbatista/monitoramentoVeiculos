/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.monitorveiculos.entidade;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDOCORRENCIA")
    private BigDecimal idocorrencia;
    
    @JsonFormat(pattern="dd/MM/yyyy")
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
    @Column(name = "ESTACIONADO")
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idocorrencia != null ? idocorrencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ocorrencia)) {
            return false;
        }
        Ocorrencia other = (Ocorrencia) object;
        if ((this.idocorrencia == null && other.idocorrencia != null) || (this.idocorrencia != null && !this.idocorrencia.equals(other.idocorrencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.monitorveiculos.entidade.Ocorrencia[ idocorrencia=" + idocorrencia + " ]";
    }
    
}
