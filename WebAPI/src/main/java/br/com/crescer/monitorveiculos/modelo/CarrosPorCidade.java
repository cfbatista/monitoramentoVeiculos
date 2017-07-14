package br.com.crescer.monitorveiculos.modelo;

import br.com.crescer.monitorveiculos.entidade.Cidade;
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
public class CarrosPorCidade {

    private Cidade cidade;
    
    private Long contagemCarros;

}
