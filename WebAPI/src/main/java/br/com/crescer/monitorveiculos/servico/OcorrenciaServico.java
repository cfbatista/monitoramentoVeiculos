package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Ocorrencia;
import br.com.crescer.monitorveiculos.repositorio.OcorrenciaRepositorio;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcorrenciaServico {

    @Autowired
    private OcorrenciaRepositorio ocorrenciaRepositorio;

    public List<Ocorrencia> todasOcorrencias() {
        return (List<Ocorrencia>) ocorrenciaRepositorio.findAll();
    }

    public Ocorrencia criarOcorrencia(Ocorrencia ocorrencia) {
        return ocorrenciaRepositorio.save(ocorrencia);
    }

    public Long listarOcorrenciasUltimosTresMeses() {
        return ocorrenciaRepositorio.getOcorrenciasTresUltimosMeses(buscarAtualMenosTresMeses(), buscarDataAtual());
    }

    public Date buscarDataAtual() {
        Calendar call = Calendar.getInstance();
        Date d = call.getTime();
        return d;
    }

    public Date buscarAtualMenosTresMeses() {
        Calendar call = Calendar.getInstance();
        call.add(Calendar.MONTH, -3);
        Date d = call.getTime();
        return d;
    }
}
