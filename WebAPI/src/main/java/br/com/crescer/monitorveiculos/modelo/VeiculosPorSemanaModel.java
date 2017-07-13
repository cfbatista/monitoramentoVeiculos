
package br.com.crescer.monitorveiculos.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author william.goncalves
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class VeiculosPorSemanaModel {
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date diaSemana;
    
    private Long numeroCarros;
    
}
