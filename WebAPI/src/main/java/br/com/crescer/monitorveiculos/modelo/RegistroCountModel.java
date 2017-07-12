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
 * @author Diandra Rocha
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistroCountModel {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;

    private Long idCameraInicial;

    private Long idCameraFinal;

    private Character direcao;

    private Double metros;
}
