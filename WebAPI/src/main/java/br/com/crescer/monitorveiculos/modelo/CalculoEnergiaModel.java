package br.com.crescer.monitorveiculos.modelo;

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
public class CalculoEnergiaModel {

    private Double distancia;

    private Double energia;
    
    private Long numeroVeiculos;
}
