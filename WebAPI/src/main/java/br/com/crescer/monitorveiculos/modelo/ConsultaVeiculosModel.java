package br.com.crescer.monitorveiculos.modelo;

import br.com.crescer.monitorveiculos.entidade.Cidade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author camila.batista
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ConsultaVeiculosModel {

    private Long totalOcorrencias;

    private Long totalRegistros;

    private Long quantidadeCameras;

    private Cidade cidadeVeiculo;

    private Long vezesUltrapassouLimite;

    private Long numeroDiasNoutraCidade;
}
