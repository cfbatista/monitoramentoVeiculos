package br.com.crescer.monitorveiculos.entidade;

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
public class RegistroCountModel {

    private Date dataInicial;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataFinal;

}
