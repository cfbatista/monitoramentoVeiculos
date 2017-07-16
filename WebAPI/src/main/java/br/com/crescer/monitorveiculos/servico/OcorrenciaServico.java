package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Ocorrencia;
import br.com.crescer.monitorveiculos.modelo.RetornoTop;
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

    public Iterable<Ocorrencia> todasOcorrencias() {
        return ocorrenciaRepositorio.findAll();
    }
  
    public Ocorrencia criarOcorrencia(Ocorrencia ocorrencia) {
        return ocorrenciaRepositorio.save(ocorrencia);
    }

    public Ocorrencia obterPorId(Long id) {
        return ocorrenciaRepositorio.findOne(id);
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

    public List<RetornoTop> topMarcasOcorrencia() {
        return ocorrenciaRepositorio.topMarcasOcorrencia();
    }

    public List<RetornoTop> topModelosOcorrencia() {
        return ocorrenciaRepositorio.topModelosOcorrencia();
    }

    public List<RetornoTop> topCidadesOcorrencia() {
        return ocorrenciaRepositorio.topCidadesOcorrencia();
    }

    public List<Ocorrencia> listarPorUsuario(Long idusuario) {
        return ocorrenciaRepositorio.listarPorUsuario(idusuario);
    }

    public List<Ocorrencia> listarTodas() {
        return (List<Ocorrencia>) ocorrenciaRepositorio.findAll();
    }

    public Ocorrencia pegarOcorrenciaId(Long id) {
        return ocorrenciaRepositorio.findOne(id);
    }
}
