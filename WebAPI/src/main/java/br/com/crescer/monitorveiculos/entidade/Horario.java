package br.com.crescer.monitorveiculos.entidade;

/**
 *
 * @author diandra.rocha
 */
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public enum Horario {

    MADRUGADA(Arrays.asList(LocalTime.of(0, 0, 0), LocalTime.of(6, 0, 0))),
    INICIO_MANHA(Arrays.asList(LocalTime.of(6, 1, 0), LocalTime.of(9, 0, 0))),
    MANHA(Arrays.asList(LocalTime.of(9, 1, 0), LocalTime.of(11, 30, 0))),
    MEIO_DIA(Arrays.asList(LocalTime.of(11, 31, 0), LocalTime.of(13, 30, 0))),
    TARDE(Arrays.asList(LocalTime.of(13, 31, 0), LocalTime.of(17, 30, 0))),
    FINAL_TARDE(Arrays.asList(LocalTime.of(17, 31, 0), LocalTime.of(19, 30, 0))),
    NOITE(Arrays.asList(LocalTime.of(19, 01, 0), LocalTime.of(23, 59, 0)));

    private final List<LocalTime> horarios;

    private Horario(List<LocalTime> horarios) {
        this.horarios = horarios;
    }

    public List<LocalTime> getHorarios() {
        return horarios;
    }
}
