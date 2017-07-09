package br.com.crescer.monitorveiculos.servico;

import br.com.crescer.monitorveiculos.entidade.Ocorrencia;
import br.com.crescer.monitorveiculos.repositorio.OcorrenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcorrenciaServico {
    @Autowired
    private OcorrenciaRepositorio ocorrenciaRepositorio;
    
    public Iterable<Ocorrencia> todasOcorrencias(){
        return ocorrenciaRepositorio.findAll();
    }
    
    public Ocorrencia criarOcorrencia(Ocorrencia ocorrencia){
        return ocorrenciaRepositorio.save(ocorrencia);
    }
}
