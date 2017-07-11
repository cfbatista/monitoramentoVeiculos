package br.com.crescer.monitorveiculos.entidade;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Diandra Rocha
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RetornoHeatMapModel {

    private Long idcamera;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String nome;

    private Date Data_Hora;

    private Long countRegistros;
}
