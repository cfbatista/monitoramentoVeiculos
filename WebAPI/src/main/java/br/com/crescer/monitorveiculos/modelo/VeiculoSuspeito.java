package br.com.crescer.monitorveiculos.modelo;

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

public class VeiculoSuspeito {

    private String placa;

    private Long registros;

    private Long estadosDiferentes;

}
