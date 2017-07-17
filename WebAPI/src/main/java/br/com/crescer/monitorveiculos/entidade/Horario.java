package br.com.crescer.monitorveiculos.entidade;

/**
 *
 * @author diandra.rocha
 */
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public enum Horario {

    MADRUGADA(Arrays.asList(LocalTime.of(0, 0, 0), LocalTime.of(6, 0, 0)), "00:00 - 06:00"),
    INICIO_MANHA(Arrays.asList(LocalTime.of(6, 1, 0), LocalTime.of(9, 0, 0)),"06:00 - 09:00"),
    MANHA(Arrays.asList(LocalTime.of(9, 1, 0), LocalTime.of(11, 30, 0)), "09:00 - 11:30"),
    MEIO_DIA(Arrays.asList(LocalTime.of(11, 31, 0), LocalTime.of(13, 30, 0)),"11;30 - 13:30"),
    TARDE(Arrays.asList(LocalTime.of(13, 31, 0), LocalTime.of(17, 30, 0)), "13:30 - 17:30"),
    FINAL_TARDE(Arrays.asList(LocalTime.of(17, 31, 0), LocalTime.of(19, 30, 0)), "17:30 - 19:30"),
    NOITE(Arrays.asList(LocalTime.of(19, 31, 0), LocalTime.of(23, 59, 0)),"19:30 - 23:59");

    private final List<LocalTime> horarios;
    private final String descricao;

    private Horario(List<LocalTime> horarios, String descricao) {
        this.horarios = horarios;
        this.descricao = descricao;
    }
    
    public List<LocalTime> getHorarios() {
        return horarios;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
