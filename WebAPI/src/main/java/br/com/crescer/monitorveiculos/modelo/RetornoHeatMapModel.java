package br.com.crescer.monitorveiculos.modelo;

import br.com.crescer.monitorveiculos.entidade.Camera;
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

    private Camera camera;

    private Long countRegistros;
}
