package br.com.crescer.monitorveiculos.modelo;

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

    private Date data;

    private Long idCameraInicial;

    private Long idCameraFinal;

    private Character direcao;

    private Double metros;
}
